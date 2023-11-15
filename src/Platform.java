public interface Platform<T> {
    double getAngle();
    double getMinAngle();
    double getMaxAngle();
    void tilt(double newAngle);
    boolean tiltable();
}
