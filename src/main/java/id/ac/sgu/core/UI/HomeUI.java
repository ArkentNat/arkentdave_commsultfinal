package id.ac.sgu.core.UI;

import javax.swing.JLabel;

import id.ac.sgu.core.Actor.ACActor;
import id.ac.sgu.core.Actor.BlindActor;

import javax.swing.JFrame;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.text.DecimalFormat;
import java.time.LocalTime;

public class HomeUI implements PropertyChangeListener{
    private JLabel value1;
    private JLabel value2;
    private JLabel value3;
    private ACActor ac = new ACActor();
    private BlindActor bc = new BlindActor();
    DecimalFormat df = new DecimalFormat("#.#");


    public HomeUI(){
        JFrame HomeUIFrame = new JFrame();

        //Temperature

        JLabel label1 = new JLabel("Temperature: ");
        label1.setBounds(10,40,200,40);
        HomeUIFrame.add(label1);

        value1 = new JLabel("20 C");
        value1.setBounds(10,62,200,30);
        HomeUIFrame.add(value1);

        //Wind Speed
        JLabel label2 = new JLabel("Wind Speed: ");
        label2.setBounds(10,80,200,40);
        HomeUIFrame.add(label2);

        value2 = new JLabel("50 kmph");
        value2.setBounds(10,102,200,30);
        HomeUIFrame.add(value2);

        //Humidity

        JLabel label3 = new JLabel("Timer: ");
        label3.setBounds(10,120,200,40);
        HomeUIFrame.add(label3);

        value3 = new JLabel("30 %");
        value3.setBounds(10,142,200,40);
        HomeUIFrame.add(value3);

        HomeUIFrame.setSize(400,400);
        HomeUIFrame.setLayout(null);
        HomeUIFrame.setVisible(true);
        HomeUIFrame.setTitle("Home UI Sensor");

    }

	public void propertyChange(PropertyChangeEvent evt) {

        if(evt.getPropertyName() == "temperature"){
            setTemperatureText((double) evt.getNewValue());
        } 
        else if (evt.getPropertyName() == "wind"){
            setWind((double) evt.getNewValue());
        } else {
            setTimer((LocalTime) evt.getNewValue());
        }
    }

    public void setTemperatureText(double newTemperature){
        value1.setText(df.format(newTemperature) + " C" + " || " + ac.detect(newTemperature));
    }

    public void setWind(double wind) {
        value2.setText(df.format(wind) + " kmph");
    }

    public void setTimer(LocalTime time){
        value3.setText(time.toString() + " || " + bc.detect(time));
    }
}
