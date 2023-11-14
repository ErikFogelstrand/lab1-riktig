public class PlatformHelper implements Platform{

    private final double minAngle;
    private final double maxAngle;
    private double angle;

    public PlatformHelper(double minAngle, double maxAngle){
        this.minAngle = minAngle;
        this.maxAngle = maxAngle;
        angle = 0;
    }
    public void tilt(double newAngle){
        angle = Math.min(this.maxAngle, Math.max(newAngle, minAngle));
    }
    public boolean tiltable(double currentSpeed){
        return currentSpeed == 0;
    }
}
