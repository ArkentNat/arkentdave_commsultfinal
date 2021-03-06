package id.ac.sgu.core.Sensor;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;

public class SensorImpl implements PropertyChangeListener {
    private double value;
    private final PropertyChangeSupport support = new PropertyChangeSupport(this);

    public SensorImpl(double value){
        this.value = value;
    }

    public void addPropertyChangeListener(String propertyName, PropertyChangeListener listener) {
        this.support.addPropertyChangeListener(propertyName, listener);
    }

    public void removePropertyChangeListener(PropertyChangeListener listener) {
        this.support.removePropertyChangeListener(listener);
    }

    public double getValue() {
        return value;
    }

    public void setValue(String property, double newValue) {
        double oldValue = this.value;
        this.value = newValue;
        support.firePropertyChange(property, oldValue, newValue);
    }

    @Override
	public void propertyChange(PropertyChangeEvent evt) {}
    
}
