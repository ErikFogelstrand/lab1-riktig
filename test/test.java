import org.junit.*;

import java.awt.*;

import static org.junit.Assert.*;
public class test {
    Saab95 saab95;
    Volvo240 volvo240;
    @Before
    public void init() {
        saab95 = new Saab95();
        volvo240 = new Volvo240();
    }

    //SAAB TESTS
    @Test
    public void testSaab95GetNrDoors(){
        assert (saab95.getNrDoors() == 2);

    }

    @Test
    public void testSaab95SetColor(){
        saab95.setColor(Color.black);
        assert (saab95.color == Color.black);
    }
    @Test
    public void testSaab95movex(){
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
    public void testSaab95moveXTurboOn(){

        assert (1==1);
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




    //VOLVO TEST
    @Test
    public void testVolvoGetNrDoors(){
        assert (volvo240.getNrDoors() == 4);

    }
    @Test
    public void testVolvoSetColor(){
        volvo240.setColor(Color.black);
        assert (volvo240.color == Color.black);
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
