public interface StorageUnit<CarType extends Car> {
    boolean getOpen();
    boolean driveIn(CarType newCar);
    boolean driveOut();
    void updateStorage();
}
