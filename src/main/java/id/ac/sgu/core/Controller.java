package id.ac.sgu.core;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.text.DecimalFormat;
import java.time.LocalTime;

import id.ac.sgu.core.Actor.ACActor;
import id.ac.sgu.core.Actor.BlindActor;
import id.ac.sgu.core.Sensor.TemperatureSensor;
import id.ac.sgu.core.Sensor.TimerSensor;
import id.ac.sgu.core.Sensor.WindSensor;
import javafx.fxml.FXML;
import javafx.scene.control.Label;

public class Controller implements PropertyChangeListener {
    private TemperatureSensor ts;
    private WindSensor ws;
    private TimerSensor tms;
    private ACActor ac = new ACActor();
    private BlindActor bc = new BlindActor();
    private double temperature;
    private double wind;
    private LocalTime time;
    private String acStatus;
    private String blinderStatus;
    DecimalFormat df = new DecimalFormat("#.#");

    @FXML
    private Label currentTime;

    private final PropertyChangeSupport support = new PropertyChangeSupport(this);

    public void addPropertyChangeListener(String propertyName, PropertyChangeListener listener) {
        this.support.addPropertyChangeListener(propertyName, listener);
    
    }

    public void removePropertyChangeListener(PropertyChangeListener listener) {
        this.support.removePropertyChangeListener(listener);
    }

    public Controller(){};
    public Controller(TemperatureSensor ts, WindSensor ws, TimerSensor tms) {
        this.ts = ts;
        this.ws = ws;
        this.tms = tms;
    }

    @Override
	public void propertyChange(PropertyChangeEvent evt) {

        if(evt.getPropertyName() == "temperature"){
            System.out.println("Temperature Controller: " + df.format(ts.getValue()) + " || " + ac.detect(ts.getValue()));
            setTemperature(ts.getValue());
            setAcStatus(ac.detect(ts.getValue()));
        } 
        else if (evt.getPropertyName() == "wind"){
            System.out.println("Wind Controller: " + df.format(ws.getValue()));
            setWind(ws.getValue());
        } else {
            System.out.println("Timer Controller: " + tms.getTime() + " || " + bc.detect(tms.getTime()));
            System.out.println("_____________________________________________\n");
            currentTime.setText(tms.getTime().toString());
            setTime(tms.getTime());
            setBlinderStatus(bc.detect(tms.getTime()));
        }
        
        // support.firePropertyChange("time", tms.getTime().minusHours(1), tms.getTime());
        // support.firePropertyChange("temperature", evt.getOldValue(), evt.getNewValue());
    }

    public double getTemperature() {
        return temperature;
    }

    public void setTemperature(double temperature) {
        this.temperature = temperature;
    }

    public double getWind() {
        return wind;
    }

    public void setWind(double wind) {
        this.wind = wind;
    }

    public LocalTime getTime() {
        return time;
    }

    public void setTime(LocalTime time) {
        this.time = time;
    }

    public String getAcStatus() {
        return acStatus;
    }

    public void setAcStatus(String acStatus) {
        this.acStatus = acStatus;
    }

    public String getBlinderStatus() {
        return blinderStatus;
    }

    public void setBlinderStatus(String blinderStatus) {
        this.blinderStatus = blinderStatus;
    }

    

    

}
