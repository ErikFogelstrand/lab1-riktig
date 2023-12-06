import javax.swing.*;
import java.awt.*;

public class Application extends JFrame{
    private static final int boundX = 800;
    private static final int boundY = 700;

    protected void initApp(String title, DrawPanel dp, CarView cv) { //TODO hämtad från CarView (initComponents)
        // Make the frame pack all it's components by respecting the sizes if possible.
        this.setPreferredSize(new Dimension(boundX,boundY));  //TODO flyttat till APP från initComp i carView
        this.setLayout(new FlowLayout(FlowLayout.LEFT, 0, 0));
        this.pack();
        this.setTitle(title);
        // Get the computer screen resolution
        Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
        // Center the frame
        this.setLocation(dim.width / 2 - this.getSize().width / 2, dim.height / 2 - this.getSize().height / 2);
        // Make the frame visible
        this.setVisible(true);

        // Make sure the frame exits when "x" is pressed
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.add(dp);
        this.add(cv.carView);

    }
    public static void main(String[] args) {
        // Instance of this class
        Application app = new Application();
        CarController cc = new CarController(boundX - 100, boundY - 240 - 60);
        DrawPanel dp = new DrawPanel(boundX, boundY - 240);
        CarView cv = new CarView(cc, boundX);

        cc.AddUpdateListener(dp);
        cc.cars.add(new Volvo240(0, 0));
        cc.cars.add(new Saab95(0, 100));
        cc.cars.add(new Scania(0, 200));

        // Start the timer
        cc.timer.start();
        app.initApp("Hilarious CarGame FUN!", dp, cv);
    }


}
