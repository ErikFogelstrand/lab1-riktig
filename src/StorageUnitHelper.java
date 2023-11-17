import java.util.ArrayList;

public class StorageUnitHelper<CarType extends Car> implements StorageUnit<CarType> {
    private final Truck truck; // TODO ändra till en mer generell typ
    private boolean open;
    private final int capacity;
    private ArrayList<CarType> cars;
    public StorageUnitHelper(Truck truck, int capacity){
        this.truck = truck;
        open = false;
        this.capacity = capacity;
        cars = new ArrayList<>();
    }
    public boolean getOpen(){return open;}
    public void setOpen(boolean newOpen){open = newOpen;}
    public boolean openable(){return truck.openable();}
    public boolean driveIn(CarType car){
        double distance = Math.hypot(truck.getX() - car.getX(), truck.getY() - car.getY());
        if (open && cars.size() < capacity && !car.getInStorage() && distance < 3){
            cars.add(0, car);
            car.driveIn(truck);
            return true;
        }
        else return false;
    }
    public boolean driveOut(){
        if (open && !cars.isEmpty()){
            cars.get(0).driveOut();
            cars.remove(0);
            return true;
        }
        else return false;
    }
    public void updateStorage(){
        for (Car car : cars){
            car.updateStorage();
        }
    }
}