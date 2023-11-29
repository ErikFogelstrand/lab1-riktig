import org.junit.*;


public class TestScania {
    Scania scania;
    @Before
    public void init() { scania = new Scania();}

    //Scania
    @Test
    public void testScaniaGetNrDoors(){assert scania.getNrDoors() == 2;}

    @Test
    public void testScaniagetAngle(){
        scania.tilt(Math.PI/4);
        assert scania.getAngle() == Math.PI/4;}

    @Test
    public void testScaniaTiltRange(){
        scania.tilt(Math.PI);
        assert scania.getAngle() == Math.toRadians(70);
    }

    @Test
    public void testScaniaGetMinAngle(){
        assert scania.getMinAngle() == 0;
    }

    @Test
    public void testScaniaGetMaxAngle(){
        assert scania.getMaxAngle() == Math.toRadians(70);
    }

    @Test
    public void testScaniaTilt(){
        scania.tilt(Math.PI/4);
        assert (Math.PI/4) == scania.getAngle();
    }



    @Test
    public void testScaniaGasIfTilt(){
        scania.tilt(Math.PI/4);
        scania.gas(0.5);
        assert scania.getCurrentSpeed() == 0;
    }
}
