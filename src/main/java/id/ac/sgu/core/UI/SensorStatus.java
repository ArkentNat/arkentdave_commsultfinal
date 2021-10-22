package id.ac.sgu.core.UI;

import java.awt.Font;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.time.LocalTime;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.ScrollPaneConstants;
import javax.swing.border.EtchedBorder;
import javax.swing.border.TitledBorder;

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

        
        title = new JLabel ("Current Time : " + currentTimeString);
        title.setBounds(450,10, 200, 100);
        Font labelFont = title.getFont();
        title.setFont(new Font(labelFont.getName(), Font.PLAIN, 20));

        
        JLabel acLabel = new JLabel("Air Conditioner: ");
        acLabel.setBounds(20,100, 100,20);

        
        JPanel middlePanel=new JPanel();
        //middlePanel.setBorder(new TitledBorder(new EtchedBorder(), "Log Area"));
        middlePanel.setBounds(250,80,550,400);
        
        logTextArea = new JTextArea(50,50);
        //logTextArea.setBounds(350,100, 450,200);
        logTextArea.setVisible(true);
        logTextArea.setEditable(false);
        logTextArea.setLineWrap(true);
        
        JScrollPane scrollPane = new JScrollPane(logTextArea);
        scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
        scrollPane.setPreferredSize(new Dimension(550,400));
        
        middlePanel.add(scrollPane);
        
        frame = new JFrame();
        frame.setTitle("Homy");
        frame.setVisible(true);
        frame.setLayout(null);
        frame.setSize(960,680);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        frame.add(acLabel);
        frame.add(title);
        frame.add(middlePanel);
        

        
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
            logData("\nWind: " + evt.getNewValue() + " kph");
        } else {
            // setBlinder((LocalTime) evt.getNewValue());
            setCurrentTimeString((LocalTime) evt.getNewValue());
            logData("\nTime: " + evt.getNewValue() + " || BLINDER STATUS: " + bc.detect((LocalTime)evt.getNewValue()) + "\n\n");
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
