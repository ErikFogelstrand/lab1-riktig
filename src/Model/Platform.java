package Model;

public interface Platform {
    double getAngle();
    double getMinAngle();
    double getMaxAngle();
    void tilt(double newAngle);
}
