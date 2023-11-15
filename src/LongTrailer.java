import java.awt.*;

public class LongTrailer extends Car implements Transport{
    private final TransportHelper transport;
    public LongTrailer(){
        transport = new TransportHelper(this);
        nrDoors = 2;
        color = Color.red;
        enginePower = 90;
        modelName = "carTransport";
        stopEngine();
    }
    protected double speedFactor(){
        if (getOpen())
            return enginePower*0.01;
        else
            return 0;
    }
    public boolean getOpen(){return transport.getOpen();}
    public void setOpen(boolean newOpen){transport.setOpen(newOpen);}
    public boolean openable(){return getCurrentSpeed() == 0;}
}
