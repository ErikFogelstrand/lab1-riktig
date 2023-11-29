import java.awt.*;

public class Volvo240 extends Car {

    private final static double trimFactor = 1.25;

    public Volvo240(){
        inStorage = false;
        nrDoors = 4;
        color = Color.black;
        enginePower = 100;
        modelName = "Volvo240";
        stopEngine();
    }

    protected double speedFactor(){
        return enginePower * 0.01 * trimFactor;
    }
}
