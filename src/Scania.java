import java.awt.*;

public class Scania extends Truck implements Platform{
    private final PlatformHelper platform;
    public Scania(){
        nrDoors = 2;
        color = Color.red;
        enginePower = 90;
        modelName = "Scania";
        platform = new PlatformHelper(this, 0, 70);
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
        platform.tilt(newAngle);
    }
    public boolean tiltable(){
        return platform.tiltable();
    }


}
