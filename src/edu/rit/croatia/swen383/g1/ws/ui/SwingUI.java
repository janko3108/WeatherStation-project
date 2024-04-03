package edu.rit.croatia.swen383.g1.ws.ui;
/*
 * Initial Author
 *      Michael J. Lutz
 *
 * Other Contributers
 *
 * Acknowledgements
 */

/*
 * Swing UI class used for displaying the information from the
 * associated weather station object.
 * This is an extension of JFrame, the outermost container in
 * a Swing application.
 */

import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.EnumMap;
import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import edu.rit.croatia.swen383.g1.ws.WeatherStation;
import edu.rit.croatia.swen383.g1.ws.observer.Observer;
import edu.rit.croatia.swen383.g1.ws.util.MeasurementUnit;

//import java.text.DecimalFormat ;

public class SwingUI extends JFrame implements Observer {
    // TemperatureSensor sensor = new TemperatureSensor();
    private EnumMap<MeasurementUnit, JLabel> jLabelMap;
    private final WeatherStation station;
    private static Font labelFont = new Font(Font.SERIF, Font.PLAIN, 52);

    public SwingUI(WeatherStation station) {
        super("Weather Station - SwingUI");
        this.station = station;
        this.station.attach(this);
        jLabelMap = new EnumMap<>(MeasurementUnit.class);
        this.setLayout(new GridLayout(1, 0));

        for (MeasurementUnit unit : MeasurementUnit.values()) {
            JPanel panel = createPanel(unit);
            this.add(panel);
        }

        this.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
        this.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                handleClosing();
            }
        });
        this.pack();
        this.setVisible(true);
    }

    public void handleClosing() {
        System.out.println("Closing the application....");
        System.exit(0);
    }

    /**
     * Method to add a label
     * 
     * @param unit  - temperature unit
     * @param value - temperatue unit value
     */
    private void setJLabel(MeasurementUnit unit, double value) {
        jLabelMap.get(unit).setText(String.format("%6.2f", value));
    }

    /**
     * Method to create panels without hard-coding
     * 
     * @param unit - gets the kind of a unit
     * @return panel
     */
    private JPanel createPanel(MeasurementUnit unit) {
        JPanel panel = new JPanel(new GridLayout(2, 1));
        // label for unit name
        JLabel labelUnitName = createLabel(unit.name());
        // label for unit value
        JLabel labelUnitValue = createLabel(" ");
        // add labels to panel
        panel.add(labelUnitName);
        panel.add(labelUnitValue);
        jLabelMap.put(unit, labelUnitValue);
        return panel;
    }

    /*
     * Create a Label with the initial value <title>, place it in
     * the specified <panel>, and return a reference to the Label
     * in case the caller wants to remember it.
     */
    private JLabel createLabel(String title) {
        JLabel label = new JLabel(title);
        label.setHorizontalAlignment(JLabel.CENTER);
        label.setVerticalAlignment(JLabel.TOP);
        label.setFont(labelFont);
        label.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        return label;
    }

    /**
     * Update values for the SwingUI class
     * 
     * @param reading - the value for the sensor that is currently reading
     */

    public void update() {
        for (MeasurementUnit unit : MeasurementUnit.values()) {
            setJLabel(unit, station.getReading(unit));
        }
    }

}
