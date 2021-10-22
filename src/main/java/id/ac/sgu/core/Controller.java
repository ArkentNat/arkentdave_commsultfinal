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

public class Controller implements PropertyChangeListener {
    private TemperatureSensor ts;
    private WindSensor ws;
    private TimerSensor tms;
    private ACActor ac = new ACActor();
    private BlindActor bc = new BlindActor();
    DecimalFormat df = new DecimalFormat("#.#");

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
        } 
        else if (evt.getPropertyName() == "wind"){
            System.out.println("Wind Controller: " + df.format(ws.getValue()));
        } else {
            System.out.println("Timer Controller: " + tms.getTime() + " || " + bc.detect(tms.getTime()));
            System.out.println("_____________________________________________\n");
        }
    } 
}