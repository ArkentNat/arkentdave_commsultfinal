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

import java.text.DecimalFormat;


public class SensorStatus implements PropertyChangeListener{
    JFrame frame;
    JTextArea logTextArea;
    JLabel title;
    JLabel acLabel;
    JLabel blindLabel;
    private String currentTimeString;
    private ACActor ac = new ACActor();
    private BlindActor bc = new BlindActor();
    DecimalFormat df = new DecimalFormat("#.#");

    public SensorStatus() {

        
        title = new JLabel ("Current Time : " + currentTimeString);
        title.setBounds(450,10, 200, 100);
        Font labelFont = title.getFont();
        title.setFont(new Font(labelFont.getName(), Font.PLAIN, 20));
        
        acLabel = new JLabel("Air Conditioner: ");
        acLabel.setBounds(20,100, 170,20);

        blindLabel = new JLabel("Blind Window: ");
        blindLabel.setBounds(20,140,170,20);

        
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
        frame.add(blindLabel);
        
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
            logData("Temperature: " + df.format(evt.getNewValue()) + " C || AC STATUS: " + ac.detect((double)evt.getNewValue()));
            acLabel.setText("AC Status: " + ac.detect((double)evt.getNewValue()));
        } 
        else if (evt.getPropertyName() == "wind"){
            logData("\nWind: " + df.format(evt.getNewValue()) + " kph");
        } else {
            setCurrentTimeString((LocalTime) evt.getNewValue());
            logData("\nTime: " + evt.getNewValue() + " || BLINDER STATUS: " + bc.detect((LocalTime)evt.getNewValue()) + "\n\n");
            blindLabel.setText("Blind Status: " + bc.detect((LocalTime)evt.getNewValue()));
        }        
    }
}
