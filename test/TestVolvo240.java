import org.junit.Before;
import org.junit.Test;

import java.awt.*;

public class TestVolvo240 {
    Volvo240 volvo240;
    @Before
    public void init() {
        volvo240 = new Volvo240();
    }

    //VOLVO TEST
    @Test
    public void testVolvo240GetNrDoors(){
        assert (volvo240.getNrDoors() == 4);
    }
    @Test
    public void testVolvo240SetColor(){
        volvo240.setColor(Color.blue);
        assert (volvo240.color == volvo240.getColor());
    }

    @Test
    public void testVolvo240StartEngine(){
        volvo240.startEngine();
        assert (volvo240.currentSpeed == 0.1);
    }

    @Test
    public void testVolvo240turnLeft(){
        volvo240.turnLeft(90);
        assert (volvo240.getDirection() == 90);
    }
    @Test
    public void testVolvo240turnRight(){
        volvo240.turnRight(90);
        assert (volvo240.getDirection() == -90);
    }

    @Test //testar även getEnginePower
    public void testVolvo240getEnginePower(){
        assert (volvo240.getEnginePower() == volvo240.enginePower);
    }
    @Test
    public void testVolvo240Speedfactor(){
        double tempSpeed = volvo240.enginePower*0.01*1.25; //trimfactor == 1.25
        assert (volvo240.speedFactor() == tempSpeed);
    }
    @Test
    public void testVolvo240speedFactor(){
        double tempSpeed = volvo240.enginePower*0.01*1.25; //trimfactor == 1.25
        assert (volvo240.speedFactor() == tempSpeed);
    }

    @Test
    public void testVolvo240IncrementSpeed(){
        double tempSpeed = Math.min(volvo240.currentSpeed + volvo240.speedFactor() * 10, volvo240.enginePower);
        volvo240.incrementSpeed(10);
        assert (volvo240.currentSpeed == tempSpeed);
    }

    @Test
    public void testVolvo240decrementSpeed(){
        double tempSpeed = Math.max(volvo240.currentSpeed - volvo240.speedFactor() * 10, 0);
        volvo240.decrementSpeed(10);
        assert (volvo240.currentSpeed == tempSpeed);
    }

    @Test
    public void testVolvo240GasOver1(){
        Volvo240 otherVolvo240 = new Volvo240();
        volvo240.gas(3);
        otherVolvo240.gas(1);
        assert(volvo240.currentSpeed == otherVolvo240.currentSpeed);
    }
    @Test
    public void testVolvo240GasUnder0(){
        Volvo240 otherVolvo240 = new Volvo240();
        volvo240.gas(-3);
        otherVolvo240.gas(0);
        assert(volvo240.getCurrentSpeed() == otherVolvo240.getCurrentSpeed());
    }
    @Test
    public void testVolvo240BrakeOver1(){
        Volvo240 otherVolvo240 = new Volvo240();
        otherVolvo240.gas(1);
        otherVolvo240.brake(1);
        volvo240.gas(1);
        volvo240.brake(10);
        assert(volvo240.getCurrentSpeed() == otherVolvo240.getCurrentSpeed());

    }
}
