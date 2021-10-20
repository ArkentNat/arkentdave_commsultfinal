package id.ac.sgu.core;
import java.text.DecimalFormat;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;

public class SensorImpl implements PropertyChangeListener {
    private double value;
    DecimalFormat df = new DecimalFormat("#.#");
    private final PropertyChangeSupport support = new PropertyChangeSupport(this);

    public SensorImpl(double value){
        this.value = value;
    }

    public void addPropertyChangeListener(String propertyName, PropertyChangeListener listener) {
        System.out.println("Listener added");
        this.support.addPropertyChangeListener(propertyName, listener);
    }

    public void removePropertyChangeListener(PropertyChangeListener listener) {
        this.support.removePropertyChangeListener(listener);
    }

    public double getValue() {
        return value;
    }

    public void setValue(String property, double newValue) {
        // System.out.println(property + " " + newValue + " " + this.value);
        double oldValue = this.value;
        this.value = newValue;
        support.firePropertyChange(property, oldValue, newValue);
    }

    @Override
	public void propertyChange(PropertyChangeEvent evt) {}
    
}
