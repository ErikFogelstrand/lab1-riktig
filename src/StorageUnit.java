public interface StorageUnit<CarType extends Car> {
    boolean getOpen();
    void setOpen(boolean newOpen);
    boolean openable();
    boolean driveIn(CarType newCar);
    boolean driveOut();
    void updateStorage();
}
