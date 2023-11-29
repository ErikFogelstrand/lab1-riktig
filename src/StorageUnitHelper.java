import java.util.ArrayList;

public class StorageUnitHelper<CarType extends Car> implements StorageUnit<CarType> {
    private final Body storageUnit;
    private boolean open;
    private final int capacity;
    protected ArrayList<CarType> cars; // Ska vara private!
    public StorageUnitHelper(Body storageUnit,int capacity){
        this.storageUnit = storageUnit;
        open = false;
        this.capacity = capacity;
        cars = new ArrayList<>();
    }
    public boolean getOpen(){return open;}
    public void open(){
        open = true;
    }
    public void close(){open = false;}
    public boolean driveIn(CarType car){
        double distance = Math.hypot(storageUnit.getX() - car.getX(), storageUnit.getY() - car.getY());
        if (open && cars.size() < capacity && !car.getInStorage() && distance < 3){
            cars.add(0, car);
            car.driveIn();
            return true;
        }
        else return false;
    }
    public boolean driveOut(){
        if (open && !cars.isEmpty()){
            cars.get(0).driveOut(storageUnit.getX(), storageUnit.getY());
            cars.remove(0);
            return true;
        }
        else return false;
    }
    public void updateStorage(){
        for (Car car : cars){
            car.updateStorage(storageUnit.getX(), storageUnit.getY());
        }
    }
}