public interface Platform {
    double tilt(double newAngle, Car car);
    boolean tiltable(double currentSpeed);
}
