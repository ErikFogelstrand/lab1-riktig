package Model;

public class VehicleFactory {
    public static Vehicle Volvo240(){
        return new Volvo240(0, 0);
    }
    public static Vehicle Saab95(){
        return new Saab95(0, 100);
    }
    public static Vehicle Scania(){
        return new Scania(0, 200);
    }
}
