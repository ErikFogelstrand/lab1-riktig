import java.util.ArrayList;

public class StorageUnitHelper<CarType extends Car> implements StorageUnit<CarType> {
    private final Body body; // TODO ändra till en mer generell typ
    private boolean open;
    private final int capacity;
    protected ArrayList<CarType> cars; // Ska vara private!
    public StorageUnitHelper(Body body, int capacity){
        this.body = body;
        open = false;
        this.capacity = capacity;
        cars = new ArrayList<>();
    }
    public boolean getOpen(){return open;}
    public void open(boolean openable){
        if (openable)
            open = true;
    }
    public void close(){open = false;}
    public boolean driveIn(CarType car){
        double distance = Math.hypot(body.getX() - car.getX(), body.getY() - car.getY());
        if (open && cars.size() < capacity && !car.getInStorage() && distance < 3){
            cars.add(0, car);
            car.driveIn(body);
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