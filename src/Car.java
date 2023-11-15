import java.awt.*;

public abstract class Car implements Movable {

    protected int nrDoors; // Number of doors on the car
    protected double enginePower; // Engine power of the car
    protected double currentSpeed; // The current speed of the car
    protected Color color; // Color of the car
    protected String modelName; // The car model name
    protected double x; // x-coordinate of car
    protected double y; // y-coordinate of car
    protected double direction; // direction of car in degrees

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

    public void setColor(Color clr){
        color = clr;
    }

    public void startEngine(){
        currentSpeed = 0.1;
    }

    public void stopEngine(){
        currentSpeed = 0;
    }


    // Implemented from Movable (move, turnLeft, turnRight)
    public void move(){
        y += Math.sin(direction) * currentSpeed;
        x += Math.cos(direction) * currentSpeed;
    }


    public void turnLeft(double turnAngle){
        direction += turnAngle;
    }

    public void turnRight(double turnAngle){
        direction -= turnAngle;
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
        decrementSpeed(amount);
    }
    public double getDirection(){return direction;}
    public double getX(){return x;}
    public double getY(){return y;}
}
