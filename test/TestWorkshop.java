import org.junit.*;

public class TestWorkshop {
    Workshop<Car> carWorkshop;
    Workshop<Volvo240> volvo240Workshop;
    Workshop<Saab95> saab95Workshop;
    @Before
    public void init(){
        carWorkshop = new Workshop<>(2);
        volvo240Workshop = new Workshop<>(1);
        saab95Workshop = new Workshop<>(0);
    }
    @Test
    public void testOpenGetOpen(){
        carWorkshop.open();
        assert carWorkshop.getOpen();
    }
    @Test
    public void testStoreCar(){
        Volvo240 volvo240 = new Volvo240();
        volvo240Workshop.open();
        assert volvo240Workshop.driveIn(volvo240);
    }
    @Test
    public void testStoreCarAndNumberOfCarsInStorageIsPlusOne(){
        Volvo240 volvo240 = new Volvo240();
        volvo240Workshop.open();
        volvo240Workshop.driveIn(volvo240);
        assert volvo240Workshop.storage.cars.size() == 1;
    }
    @Test
    public void testStoreCarWhenWorkshopHasNoCapacity(){
        Saab95 saab95 = new Saab95();
        saab95Workshop.open();
        assert !saab95Workshop.driveIn(saab95);
    }
    @Test
    public void testStoreCarAndCarIsInStorage(){
        Volvo240 volvo240 = new Volvo240();
        volvo240Workshop.open();
        volvo240Workshop.driveIn(volvo240);
        assert volvo240Workshop.storage.cars.get(0).inStorage;
    }
    @Test
    public void testStoreCarAndItPekarTillbaksToWorkshop(){
        Volvo240 volvo240 = new Volvo240();
        volvo240Workshop.open();
        volvo240Workshop.driveIn(volvo240);
        assert volvo240Workshop.storage.cars.get(0).storageUnit == volvo240Workshop;
    }
    @Test
    public void testIfTwoCarsGetInTheOneLängstInCantGetOutFirst(){
        Volvo240 volvo240 = new Volvo240();
        Saab95 saab95 = new Saab95();
        carWorkshop.open();
        carWorkshop.driveIn(volvo240);
        carWorkshop.driveIn(saab95);
        carWorkshop.driveOut();
        assert carWorkshop.storage.cars.get(0) == volvo240;
    }
    @Test
    public void testStorageUnitHelperDriveOutWithEmptyStorage(){
        carWorkshop.open();
        assert !carWorkshop.driveOut();
    }
}
