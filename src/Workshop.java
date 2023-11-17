public class Workshop<CarType extends Car> extends Body implements StorageUnit<CarType>{
    private final StorageUnit storage;

    public Workshop(int capacity){
        storage = new StorageUnitHelper(this, capacity);
    }
    public boolean getOpen(){return storage.getOpen();}
    public void setOpen(boolean newOpen){

    }
    public boolean openable() {return true;} // går alltid att öppna
    public boolean driveIn(CarType newCar) {return storage.driveIn(newCar);}
    public boolean driveOut() {return storage.driveOut();}
    public void updateStorage() {storage.updateStorage();}

}
