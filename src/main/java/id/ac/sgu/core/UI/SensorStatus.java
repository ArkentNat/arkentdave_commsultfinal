package id.ac.sgu.core.UI;

import java.awt.Font;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.time.LocalTime;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextArea;

import id.ac.sgu.core.Actor.ACActor;
import id.ac.sgu.core.Actor.BlindActor;


public class SensorStatus implements PropertyChangeListener{
    JFrame frame;
    JTextArea logTextArea;
    JLabel title;
    private String currentTimeString;
    private ACActor ac = new ACActor();
    private BlindActor bc = new BlindActor();

    public SensorStatus() {
        frame = new JFrame();
        frame.setTitle("Homy");
        
        title = new JLabel ("Current Time : " + currentTimeString);
        title.setBounds(100,30, 200, 100);
        Font labelFont = title.getFont();
        title.setFont(new Font(labelFont.getName(), Font.PLAIN, 20));
        
        frame.add(title);
        
        logTextArea = new JTextArea(50,50);
        logTextArea.setVisible(true);
        logTextArea.setText("Hello");
        logTextArea.setEditable(false);
        frame.add(logTextArea);
        
        frame.setVisible(true);
        frame.setLayout(null);
        frame.setSize(960,480);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
    }
    
    public void setCurrentTimeString(LocalTime time) {
        this.title.setText(time.toString());
    }
    
    public void logData(String text) {
        this.logTextArea.append(text);
    }

    @Override
    public void propertyChange(PropertyChangeEvent evt) {
        if(evt.getPropertyName() == "temperature"){
            // setAC((double) evt.getNewValue());
            logData("Temperature: " + evt.getNewValue() + " C || AC STATUS: " + ac.detect((double)evt.getNewValue()));
        } 
        else if (evt.getPropertyName() == "wind"){
            // setWind((double) evt.getNewValue());
            logData("Wind: " + evt.getNewValue() + " kph");
        } else {
            // setBlinder((LocalTime) evt.getNewValue());
            setCurrentTimeString((LocalTime) evt.getNewValue());
            logData("Time: " + evt.getNewValue() + " || BLINDER STATUS: " + bc.detect((LocalTime)evt.getNewValue()));
        }        
    }

    // public void setAC(double newTemperature){
    //     jLabel6.setText(ac.detect(newTemperature));
    //     jTextArea1.setText("Temperature: " + newTemperature + " C || AC STATUS: " + ac.detect(newTemperature));
    // }

    // public void setBlinder(LocalTime time) {
    //     jLabel7.setText(bc.detect(time));
    //     jLabel1.setText("Time: " + time.toString() + " || BLINDER STATUS: " + bc.detect(time));
    //     jLabel1.setText("____________________________________________________________");

    // }

    // public void setWind(double wind) {
    //     jTextArea1.setText("Wind: " + wind + " kph");
    // }
    
}