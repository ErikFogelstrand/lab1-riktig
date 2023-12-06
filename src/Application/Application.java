package Application;

import Model.FuncDistribution;
import Model.VehicleFactory;
import Controller.CarController;
import View.CarView;

import javax.swing.*;
import java.awt.*;

public class Application extends JFrame{
    private static final int boundX = 800;
    private static final int boundY = 700;

    private void initApp(String title, CarView cv, CarController cc) {
        // Make the frame pack all it's components by respecting the sizes if possible.
        this.setPreferredSize(new Dimension(boundX,boundY));
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
        this.add(cv);
        this.add(cc.carView);

    }
    public static void main(String[] args) {
        // Instance of this class
        Application app = new Application();
        FuncDistribution fc = new FuncDistribution(boundX - 100, boundY - 240 - 60);
        CarView cv = new CarView(boundX, boundY - 240);
        CarController cc = new CarController(fc, boundX);

        fc.AddUpdateListener(cv);
        fc.AddCar(VehicleFactory.Volvo240());
        fc.AddCar(VehicleFactory.Saab95());
        fc.AddCar(VehicleFactory.Scania());
        fc.StartTimer();

        app.initApp("Hilarious CarGame FUN!", cv, cc);
    }


}
