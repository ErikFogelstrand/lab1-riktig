import org.junit.Before;
import org.junit.Test;

public class TestLongTrailer {
    LongTrailer longTrailer;
    @Before
    public void init() {
        longTrailer = new LongTrailer();

    }

    @Test
    public void testLongtrailerSpeedfactorClosedPlatform() {
        assert (90 * 0.01 == longTrailer.speedFactor());
    }

    @Test
    public void testLongtrailerSpeedFactorWhenOpenedPlatform() {
        longTrailer.open();
        assert(longTrailer.speedFactor() == 0);
    }

    @Test
    public void testLongtrailerGetOpen(){
        longTrailer.open();
        assert(longTrailer.getOpen());
    }

    @Test
    public void testLongtrailerOpen(){
        longTrailer.open();
        assert(longTrailer.getOpen());
    }

    @Test
    public void testLongtrailerClose(){
        longTrailer.close();
        assert(!longTrailer.getOpen());
    }
    @Test
    public void testLongtrailerDriveIn(){
        Volvo240 volvo240 = new Volvo240();
        longTrailer.open();
        assert(longTrailer.driveIn(volvo240));
    }

    @Test
    public void testLongtrailerDriveOut(){
        Saab95 saab95 = new Saab95();
        longTrailer.open();
        longTrailer.driveIn(saab95);
        assert(longTrailer.driveOut());
    }

    @Test
    public void testLongtrailerUpdateStorage(){
        Volvo240 volvo240 = new Volvo240();
        longTrailer.open();
        longTrailer.driveIn(volvo240);
        longTrailer.updateStorage();
        assert(longTrailer.driveOut());
    }
}
