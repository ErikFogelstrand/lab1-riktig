package Model;

public class Workshop<CarType extends Car> extends Body {
    protected final StorageUnitHelper<CarType> storage; // Ska vara private!

    public Workshop(int capacity){
        storage = new StorageUnitHelper<>(this, capacity);
    }
    public boolean getOpen(){return storage.getOpen();}
    public void open(){storage.open();}
    public void close(){storage.close();}
    public boolean driveIn(CarType newCar) {return storage.driveIn(newCar);}
    public boolean driveOut() {return storage.driveOut();}
    public void updateStorage() {storage.updateStorage();}

}
