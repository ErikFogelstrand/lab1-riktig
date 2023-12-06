package Model;

import Model.Body;
import Model.Movable;

import java.awt.*;

public abstract class Vehicle extends Body implements Movable {
    protected int nrDoors; // Number of doors on the car
    protected double enginePower; // Engine power of the car
    protected double currentSpeed; // The current speed of the car
    protected Color color; // Color of the car
    protected String modelName; // The car model name
    public int getNrDoors(){
        return nrDoors;
    }

    public double getEnginePower(){
        return enginePower;
    }
    public double getCurrentSpeed(){
        return currentSpeed;
    }

    public Color getColor(){
        return color;
    }
    public String getModelName(){return modelName;}

    public void setColor(Color clr){
        color = clr;
    }

    public void startEngine(){
        currentSpeed = 0.1;
    }

    public void stopEngine(){
        currentSpeed = 0;
    }


    // Implemented from Model.Movable (move, turnLeft, turnRight)
    public void move(int boundX, int boundY) {
        if (x < 0 || x > boundX){
            x = Math.max(Math.min(x, boundX), 0);
            direction = Math.PI - direction;
        }
        if (y < 0 || y > boundY){
            y = Math.max(Math.min(y, boundY), 0);
            direction = Math.PI*2 - direction;
        }
        y += Math.sin(direction) * currentSpeed;
        x += Math.cos(direction) * currentSpeed;
    }

    public void turnLeft(double turnAngle){
        direction -= turnAngle;
    }

    public void turnRight(double turnAngle){
        direction += turnAngle;
    }

    protected void incrementSpeed(double amount){
        currentSpeed = Math.min(getCurrentSpeed() + speedFactor() * amount, enginePower);
    }
    protected void decrementSpeed(double amount){
        currentSpeed = Math.max(getCurrentSpeed() - speedFactor() * amount,0);
    }
    protected abstract double speedFactor();

    public void gas(double amount){
        incrementSpeed(Math.max(Math.min(amount, 1), 0));
    }
    public void brake(double amount){
        decrementSpeed(Math.max(Math.min(amount, 1), 0));

    }
}
