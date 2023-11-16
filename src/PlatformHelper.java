public class PlatformHelper implements Platform{
    private final Truck truck;
    private double angle;
    private final double minAngle;
    private final double maxAngle;
    public PlatformHelper(Truck truck, double minAngle, double maxAngle){
        this.truck = truck;
        this.angle = 0;
        this.minAngle = minAngle;
        this.maxAngle = maxAngle;
    }
    public double getAngle(){return angle;}
    public double getMinAngle(){return minAngle;}
    public double getMaxAngle(){return maxAngle;}
    public void tilt(double newAngle){
        if (tiltable()) angle = Math.min(getMaxAngle(), Math.max(newAngle, getMinAngle()));
        else angle = minAngle;
    }
    public boolean tiltable(){return truck.getCurrentSpeed() == 0;}
}