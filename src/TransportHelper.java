public class TransportHelper implements Transport{
    private final Car car; // TODO ändra till en mer generell typ
    private boolean open;
    public TransportHelper(Car car){
        this.car = car;
        open = false;
    }
    public boolean getOpen(){return open;}
    public void setOpen(boolean newOpen){open = newOpen;}
    public boolean openable(){return car.openable;}
}
