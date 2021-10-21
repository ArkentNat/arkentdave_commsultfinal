package id.ac.sgu.core;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.text.DecimalFormat;

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
        
        // support.fireIndexedPropertyChange("time", 0, tms.getTime().minusHours(1), tms.getTime());
        // support.fireIndexedPropertyChange("temperature", 2, evt.getOldValue(), evt.getNewValue());
        
    }

}
