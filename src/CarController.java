import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
public class CarController extends JFrame{
    // The controller member
    FuncDistribution funcD;

    //DrawPanel drawPanel = new DrawPanel(X, Y-240); //CarC som 3e arg.
    JPanel carView = new JPanel();
    JPanel controlPanel = new JPanel();

    JPanel gasPanel = new JPanel();
    JSpinner gasSpinner = new JSpinner();
    int gasAmount = 0;
    JLabel gasLabel = new JLabel("Amount of gas");

    JButton gasButton = new JButton("Gas");
    JButton brakeButton = new JButton("Brake");
    JButton turboOnButton = new JButton("Saab Turbo on");
    JButton turboOffButton = new JButton("Saab Turbo off");
    JButton liftBedButton = new JButton("Scania Lift Bed");
    JButton lowerBedButton = new JButton("Scania Lower Bed");
    JButton turnRightButton = new JButton("Swing right");
    JButton turnLeftButton = new JButton("Swing left");
    JButton addCarButton = new JButton("Add Car");
    JButton removeCarButton = new JButton("Remove Car");

    JButton startButton = new JButton("Start all cars");
    JButton stopButton = new JButton("Stop all cars");

    // Constructor
    public CarController(FuncDistribution cc, int boundX){
        this.funcD = cc;
        initComponents(boundX);
    }

    // Sets everything in place and fits everything
    private void initComponents(int boundX) {

        SpinnerModel spinnerModel =
                new SpinnerNumberModel(0, //initial value
                        0, //min
                        100, //max
                        1);//step
        gasSpinner = new JSpinner(spinnerModel);
        gasSpinner.addChangeListener(new ChangeListener() {
            public void stateChanged(ChangeEvent e) {
                gasAmount = (int) ((JSpinner)e.getSource()).getValue();
            }
        });

        gasPanel.setLayout(new BorderLayout());
        gasPanel.add(gasLabel, BorderLayout.PAGE_START);
        gasPanel.add(gasSpinner, BorderLayout.PAGE_END);

        controlPanel.setLayout(new GridLayout(2,5));

        controlPanel.add(gasButton, 0);
        controlPanel.add(turboOnButton, 1);
        controlPanel.add(liftBedButton, 2);
        controlPanel.add(brakeButton, 3);
        controlPanel.add(turboOffButton, 4);
        controlPanel.add(lowerBedButton, 5);
        controlPanel.add(turnLeftButton, 6);
        controlPanel.add(turnRightButton, 7);
        controlPanel.add(addCarButton,8);
        controlPanel.add(removeCarButton,9);

        controlPanel.setPreferredSize(new Dimension((boundX/2+4), 200));
        controlPanel.setBackground(Color.CYAN);


        startButton.setBackground(Color.blue);
        startButton.setForeground(Color.CYAN);
        startButton.setPreferredSize(new Dimension(boundX/5-15,200));


        stopButton.setBackground(Color.red);
        stopButton.setForeground(Color.black);
        stopButton.setPreferredSize(new Dimension(boundX/5-15,200));

        carView.add(gasPanel);
        carView.add(controlPanel);
        carView.add(startButton);
        carView.add(stopButton);

        // This actionListener is for the gas button only
        // TODO: Create more for each component as necessary
        gasButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                funcD.gas(gasAmount);
            }
        });

        brakeButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                funcD.brake(gasAmount);
            }
        });

        stopButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) { funcD.stopAllCars();
            }
        });

        stopButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) { funcD.startAllCars();
            }
        });

        turnRightButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                funcD.turnRight();
            }
        });

        turnLeftButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                funcD.turnLeft();
            }
        });

        turboOnButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                funcD.saabTurboOn();
            }
        });
        turboOffButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                funcD.saabTurboOff();
            }
        });

        liftBedButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                funcD.scaniaLiftBed();
            }
        });
        lowerBedButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                funcD.scaniaLowerBed();
            }
        });

        addCarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //funcD.addCar();
            }
        });

        removeCarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //funcD.removeCar();
            }
        });


    }
}