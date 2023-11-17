import org.junit.Before;
import org.junit.Test;

import java.awt.*;

public class TestSaab95 {

    Saab95 saab95;
    @Before
    public void init() {
        saab95 = new Saab95();
    }


    @Test
    public void testSaab95GetNrDoors(){
        assert (saab95.getNrDoors() == 2);

    }

    @Test
    public void testSaab95SetColor(){
        saab95.setColor(Color.blue);
        assert (saab95.color == saab95.getColor());
    }
    @Test
    public void testSaab95moveX(){
        double temp = saab95.getX();
        saab95.move();
        assert (saab95.getX() == temp + Math.cos(saab95.getDirection()) * saab95.getCurrentSpeed());
    }

    @Test
    public void testSaab95moveY(){
        double temp = saab95.getY();
        saab95.move();
        assert (saab95.getY() == temp + Math.sin(saab95.getDirection()) * saab95.getCurrentSpeed());
    }
    @Test
    public void testSaab95EnginePower(){
        assert (saab95.getEnginePower() == saab95.enginePower);
    }

    @Test
    public void testSaab95StartEngine(){
        saab95.startEngine();
        assert (saab95.currentSpeed == 0.1);
    }

    @Test
    public void testSaab95turnLeft(){
        saab95.turnLeft(90);
        assert (saab95.getDirection() == 90);
    }

    @Test
    public void testSaab95turnRight(){
        saab95.turnRight(90);
        assert (saab95.getDirection() == -90);
    }

    @Test
    public void testsaab95Speedfactor(){ //also turboOff lol
        //saab95.setTurboOff();
        assert (saab95.speedFactor() == 125*0.01*1);
    }
    @Test
    public void testsaab95turboOn(){
        saab95.setTurboOn();
        assert (saab95.speedFactor() == 125*0.01*1.3);
    }
    @Test
    public void testsaab95IncrementSpeed(){ //also turboOn
        saab95.setTurboOn();
        double tempSpeed = Math.min(saab95.getCurrentSpeed()+(125*0.01*1.3*10),saab95.enginePower); //speedfactor*amount
        saab95.incrementSpeed(10);
        assert (saab95.currentSpeed == tempSpeed);
    }

    @Test
    public void testsaab95DecrementSpeed(){
        saab95.setTurboOff();
        double tempSpeed = Math.max(saab95.getCurrentSpeed()-(125*0.01*1*1),0); //speedfactor*amount
        saab95.decrementSpeed(1);
        assert (saab95.currentSpeed == tempSpeed);
    }
    @Test
    public void testSaab95GasOver1(){
        Saab95 otherSaab95 = new Saab95();
        otherSaab95.gas(1);
        saab95.gas(3);
        assert(saab95.getCurrentSpeed() == otherSaab95.getCurrentSpeed());
    }
    @Test
    public void testSaab95GasUnder0(){
        Saab95 otherSaab95 = new Saab95();
        otherSaab95.gas(0);
        saab95.gas(-3);
        assert(saab95.getCurrentSpeed() == otherSaab95.getCurrentSpeed());
    }


}
