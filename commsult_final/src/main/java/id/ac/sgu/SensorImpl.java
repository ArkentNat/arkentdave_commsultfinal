package id.ac.sgu;
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

    public double getValue() {
        return value;
    }

    public void setValue(double newValue) {
        double oldValue = this.value;
        this.value = newValue;
        support.firePropertyChange("value", oldValue, newValue);
    }

    @Override
	public void propertyChange(PropertyChangeEvent evt) {}
    
}
