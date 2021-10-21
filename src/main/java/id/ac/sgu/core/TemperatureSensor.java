package id.ac.sgu.core;
import java.beans.PropertyChangeEvent;

public class TemperatureSensor extends SensorImpl {

    public TemperatureSensor(double temperature){
        super(temperature);
    }

    @Override
    public void propertyChange(PropertyChangeEvent evt) {
        setValue("temperature", 0,(double)evt.getNewValue());
        // support.firePropertyChange("temperature", evt.getNewValue(), evt.getOldValue());

    }
    
}
