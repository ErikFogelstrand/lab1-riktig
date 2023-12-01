import java.awt.*;

public class Scania extends Truck implements Platform{
    private final PlatformHelper platform;
    public Scania(){
        this(0, 0);
    }
    public Scania(double x, double y) {
        this.x = x;
        this.y = y;
        nrDoors = 2;
        color = Color.red;
        enginePower = 90;
        modelName = "Scania";
        platform = new PlatformHelper(0, Math.toRadians(70));
        stopEngine();
    }
    protected double speedFactor(){
        if (getAngle() == 0)
            return enginePower*0.01;
        else
            return 0;
    }
    public double getAngle(){return platform.getAngle();}
    public double getMinAngle(){return platform.getMinAngle();}
    public double getMaxAngle(){return platform.getMaxAngle();}
    public void tilt(double newAngle){
        if (currentSpeed == 0) platform.tilt(newAngle);
        else platform.tilt(0);
    }

}
