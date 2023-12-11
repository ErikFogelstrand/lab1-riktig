package Model;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.concurrent.ThreadLocalRandom;


/*
* This class represents the Controller part in the MVC pattern.
* It's responsibilities is to listen to the View and responds in a appropriate manner by
* modifying the model state and the updating the view.
 */

public class FuncDistribution {
    private ArrayList<UpdateListener> updateListeners;
    private int carBoundX;
    private int carBoundY;
    // member fields:

    // The delay (ms) corresponds to 20 updates a sec (hz)
    private final int delay = 50;
    // The timer is started with an listener (see below) that executes the statements
    // each step between delays.
    private Timer timer = new Timer(delay, new TimerListener());
    // A list of cars, modify if needed
    private ArrayList<Vehicle> cars = new ArrayList<>();

    //methods:
    public FuncDistribution(int BoundX, int BoundY){
        updateListeners = new ArrayList<>();
        carBoundX = BoundX;
        carBoundY = BoundY;
    }
    public void addToCars(Vehicle car){cars.add(car);}
    public void AddUpdateListener(UpdateListener newUpdateListener){
        updateListeners.add(newUpdateListener);
    }
    public void StartTimer(){timer.start();}
    public ArrayList<Vehicle> getCars(){
        ArrayList<Vehicle> newCars = new ArrayList<Vehicle>();
        for (Vehicle car : cars){
            switch (car.modelName){
                case ("Volvo240"): {newCars.add(VehicleFactory.Volvo240(car)); break;}
                case ("Saab95"): {newCars.add(VehicleFactory.Saab95(car)); break;}
                case ("Scania"): {newCars.add(VehicleFactory.Scania(car)); break;}
            }
        }
        return newCars;
    }
    /* Each step the TimerListener moves all the cars in the list and tells the
    * view to update its images. Change this method to your needs.
    * */
    private class TimerListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            for (Vehicle car : cars) {
                car.move(carBoundX, carBoundY);
                int x = (int) Math.round(car.getX());
                int y = (int) Math.round(car.getY());
                for (UpdateListener listener : updateListeners){
                    listener.updateSent(x, y, getCars());
                }
            }
        }
    }

    // Calls the gas method for each car once
    public void gas(int amount) {
        double gas = ((double) amount) / 100;
        for (Vehicle car : cars) {
            car.gas(gas);
        }
    }
    public void brake(int amount) {
        double brake = ((double) amount) / 100;
        for (Vehicle car : cars) {
            car.brake(brake);
        }
    }

    public void stopAllCars() {
        for (Vehicle car : cars) {car.stopEngine();}
    }

    public void startAllCars() {
        for (Vehicle car : cars) {
            car.startEngine();
        }
    }
    public void turnLeft() {
        for (Vehicle car : cars) {
            car.turnLeft(Math.PI/10);
        }
    }
    public void turnRight() {
        for (Vehicle car : cars) {
            car.turnRight(Math.PI/10);
        }
    }

    public void saabTurboOn(){
        for (Vehicle car : cars) {
            if (car instanceof Saab95){((Saab95) car).setTurboOn();}
        }
    }
    public void saabTurboOff(){
        for (Vehicle car : cars){
            if (car instanceof Saab95){((Saab95) car).setTurboOff();}
        }
    }
    public void scaniaLiftBed(){
        for (Vehicle car : cars){
            if (car instanceof Scania){((Scania) car).tilt(Math.toRadians(70));}
        }
    }
    public void scaniaLowerBed(){
        for (Vehicle car : cars){
            if (car instanceof Scania){((Scania) car).tilt(0);}
        }
    }
    public void addCar(){
        int randomNum = ThreadLocalRandom.current().nextInt(0, 3);
            if(cars.size()<10){
                switch (randomNum){
                    case (0): {cars.add(VehicleFactory.Volvo240()); break;}
                    case (1): {cars.add(VehicleFactory.Saab95()); break;}
                    case (2): {cars.add(VehicleFactory.Scania()); break;}
                }
                }
    }
    public void removeCar(){
        if (!cars.isEmpty()) {
            cars.remove(0);
        }
    }

}
