package id.ac.sgu;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

public class Controller implements PropertyChangeListener {
    private TemperatureSensor ts;

    public Controller(){};
    public Controller(TemperatureSensor ts) {
        this.ts = ts;
    }

    @Override
	public void propertyChange(PropertyChangeEvent evt) {
		System.out.println("Temperature: " + evt.getNewValue() + "\n");
    }
}
