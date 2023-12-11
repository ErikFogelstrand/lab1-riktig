package View;

import Model.UpdateListener;
import Model.Vehicle;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Objects;
import javax.imageio.ImageIO;
import javax.swing.*;

// This panel represent the animated part of the view with the car images.

public class CarView extends JPanel implements UpdateListener {

    BufferedImage volvoImage;
    BufferedImage scaniaImage;
    BufferedImage saab95Image;

    // To keep track of a singel cars position
    Point volvoPoint = new Point();
    Point scaniaPoint = new Point();
    Point saab95Point = new Point();

    public void updateSent(int x, int y, String modelName){
        moveit(x, y, modelName);
        repaint();
    }
    public void moveit(int x, int y, String modelName){
        switch (modelName){
            case ("Model.Volvo240"): {volvoPoint = new Point(x, y); break;}
            case ("Model.Saab95"): {saab95Point = new Point(x, y); break;}
            case ("Model.Scania"): {scaniaPoint = new Point(x, y); break;}
        }
    }

    // Initializes the panel and reads the images
    public CarView(int x, int y) {
        this.setDoubleBuffered(true);
        this.setPreferredSize(new Dimension(x, y));
        this.setBackground(Color.pink);
        // Print an error message in case file is not found with a try/catch block

        try {
            // You can remove the "pics" part if running outside of IntelliJ and
            // everything is in the same main folder.
            // volvoImage = ImageIO.read(new File("Model.Volvo240.jpg"));

            // Rememember to rightclick src New -> Package -> name: pics -> MOVE *.jpg to pics.
            // if you are starting in IntelliJ.

            volvoImage = ImageIO.read(Objects.requireNonNull(CarView.class.getResourceAsStream("/Volvo240.jpg")));
            scaniaImage = ImageIO.read(Objects.requireNonNull(CarView.class.getResourceAsStream("/Scania.jpg")));
            saab95Image = ImageIO.read(Objects.requireNonNull(CarView.class.getResourceAsStream("/Saab95.jpg")));
        } catch (IOException ex) {
            ex.printStackTrace();
            }
        }

    // This method is called each time the panel updates/refreshes/repaints itself
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawImage(volvoImage, volvoPoint.x, volvoPoint.y, null);
        g.drawImage(saab95Image, saab95Point.x, saab95Point.y, null);
        g.drawImage(scaniaImage, scaniaPoint.x, scaniaPoint.y, null); // see javadoc for more info on the parameters
    }
}
