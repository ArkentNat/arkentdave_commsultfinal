package id.ac.sgu.core;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;

public class Controller implements PropertyChangeListener {
    private TemperatureSensor ts;
    private final PropertyChangeSupport support = new PropertyChangeSupport(this);

    public void addPropertyChangeListener(String propertyName, PropertyChangeListener listener) {
        this.support.addPropertyChangeListener(propertyName, listener);
    }

    public void removePropertyChangeListener(PropertyChangeListener listener) {
        this.support.removePropertyChangeListener(listener);
    }

    public Controller(){};
    public Controller(TemperatureSensor ts) {
        this.ts = ts;

        ACActor ac = new ACActor();
        this.addPropertyChangeListener("temperature", ac);
    }

    @Override
	public void propertyChange(PropertyChangeEvent evt) {
		// System.out.println("Temperature Controller: " + ts.getTemperature());
        support.firePropertyChange("temperature", evt.getOldValue(), evt.getNewValue());
    }
}
