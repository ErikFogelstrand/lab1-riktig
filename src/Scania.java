import java.awt.*;

public class Scania extends Car implements Platform{
    private final PlatformHelper platform;

    public Scania(){
        platform = new PlatformHelper(0, 70);
        nrDoors = 2;
        color = Color.red;
        enginePower = 125;
        modelName = "Scania";
        stopEngine();
    }
    protected double speedFactor(){
        if (!platform.tiltable(getCurrentSpeed()))
            return enginePower*0.01;
        else
            return 0;
    }

    public void tilt(double newAngle){
        platform.tilt(newAngle);
    }
    public boolean tiltable(double currentSpeed){
        return platform.tiltable(currentSpeed);
    }

}
