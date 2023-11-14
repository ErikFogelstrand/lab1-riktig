import java.awt.*;

public class Scania extends Truck{
    private final PlatformHelper platform;
    private double angle;
    private double minAngle;
    private double maxAngle;

    public Scania(){
        nrDoors = 2;
        color = Color.red;
        enginePower = 125;
        modelName = "Scania";
        angle = 0;
        minAngle = 0;
        maxAngle = 70;
        platform = new PlatformHelper();
        stopEngine();
    }
    protected double speedFactor(){
        if (angle == 0)
            return enginePower*0.01;
        else
            return 0;
    }


}
