public interface Transport {
    boolean getOpen();
    void setOpen(boolean newOpen);
    boolean openable();
    boolean driveIn(Car newCar);
    boolean driveOut();
    void updateCars();


}
