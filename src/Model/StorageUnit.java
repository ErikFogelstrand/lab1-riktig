package Model;

import Model.Car;

public interface StorageUnit<CarType extends Car> {
    boolean getOpen();
    void open();
    void close();
    boolean driveIn(CarType newCar);
    boolean driveOut();
    void updateStorage();
}
