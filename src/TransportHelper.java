import java.util.ArrayList;

public class TransportHelper implements Transport{
    private final Truck truck; // TODO ändra till en mer generell typ
    private boolean open;
    private final int capacity;
    private ArrayList<Car> cars;
    public TransportHelper(Truck truck, int capacity){
        this.truck = truck;
        open = false;
        this.capacity = capacity;
        cars = new ArrayList<>();
    }
    public boolean getOpen(){return open;}
    public void setOpen(boolean newOpen){open = newOpen;}
    public boolean openable(){return truck.openable;}
    public boolean driveIn(Car car){ // TODO bilarna måste vara nära för att kunna lastas på
        if (open && cars.size() < capacity && !car.getInStorage()){ // TODO gör så saker som implementar Transport inte kan transporteras själva (nu kan en bil med typen Car transportera andra bilar OCH transporteras själv)
            cars.add(0, car);
            car.driveIn(truck);
            return true;
        }
        else return false;
    }
    public boolean driveOut(){ // TODO sätt bilarnas position till nåt annat än truckens position
        if (open && !cars.isEmpty()){
            cars.remove(0);
            return true;
        }
        else return false;
    }
    public void updateCars(){
        for (Car car : cars){
            car.updateStoragePosition();
        }
    }
}
