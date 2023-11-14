import java.awt.*;

public class carTransport extends Car{
    private final PlatformHelper platform;
    private boolean
    public carTransport(){
        platform = new PlatformHelper(0, 70);
        nrDoors = 2;
        color = Color.red;
        enginePower = 90;
        modelName = "carTransport";
        stopEngine();
    }
    protected double speedFactor(){
        if (!angle)
            return enginePower*0.01;
        else
            return 0;
    }

    public void tilt(double newAngle){
        platform.tilt(newAngle, this);
    }

    public boolean tiltable(double currentSpeed){
        return platform.tiltable(currentSpeed);
    }

}
