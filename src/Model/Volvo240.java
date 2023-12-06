package Model;

import Model.Car;

import java.awt.*;

public class Volvo240 extends Car {

    private final static double trimFactor = 1.25;

    public Volvo240(){
        this(0, 0);
    }
    public Volvo240(double x, double y){
        this.x = x;
        this.y = y;
        inStorage = false;
        nrDoors = 4;
        color = Color.black;
        enginePower = 100;
        modelName = "Model.Volvo240";
        stopEngine();
    }

    protected double speedFactor(){
        return enginePower * 0.01 * trimFactor;
    }
}
