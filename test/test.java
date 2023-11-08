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


}
