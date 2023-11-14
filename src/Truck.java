public class Truck extends Car{
    private final PlatformHelper platform = new PlatformHelper();
    private double angle = 0;
    private double minAngle;
    private double maxAngle;

    public double getAngle(){
        return angle;
    }
    public double getMinAngle(){
        return minAngle;
    }
    public double getMaxAngle(){
        return maxAngle;
    }
    public void tilt(double newAngle){
        platform.tilt(newAngle, this);
    }
    public boolean tiltable(double currentSpeed){
        return platform.tiltable(currentSpeed);
    }
}
