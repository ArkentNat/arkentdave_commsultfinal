package id.ac.sgu.core;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.text.DecimalFormat;
import java.time.LocalTime;

public class Controller implements PropertyChangeListener {
    private TemperatureSensor ts;
    private WindSensor ws;
    private TimerSensor tms;
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
        // ACActor ac = new ACActor();
        // this.addPropertyChangeListener("temperature", ac);
    }

    @Override
	public void propertyChange(PropertyChangeEvent evt) {
		System.out.println("Temperature Controller: " + df.format(ts.getValue()));
        System.out.println("Wind Controller: " + df.format(ws.getValue()));
        System.out.println("Timer Controller: " + tms.getTime());
        
        if (evt.getNewValue() instanceof LocalTime) {
            support.firePropertyChange("time", tms.getTime().minusHours(1), tms.getTime());
        } else {
            support.firePropertyChange("temperature", evt.getOldValue(), evt.getNewValue());
        }
    }

}
