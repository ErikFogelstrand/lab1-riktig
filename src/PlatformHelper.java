public class PlatformHelper implements Platform{
    private double angle;
    private final double minAngle;
    private final double maxAngle;
    public PlatformHelper(double minAngle, double maxAngle){
        this.angle = 0;
        this.minAngle = minAngle;
        this.maxAngle = maxAngle;
    }
    public double getAngle(){return angle;}
    public double getMinAngle(){return minAngle;}
    public double getMaxAngle(){return maxAngle;}
    public void tilt(double newAngle){
        angle = Math.min(getMaxAngle(), Math.max(newAngle, getMinAngle()));
        System.out.println(angle);
    }
}