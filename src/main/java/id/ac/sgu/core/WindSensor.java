package id.ac.sgu.core;
import java.beans.PropertyChangeEvent;

public class WindSensor extends SensorImpl {

    public WindSensor(double wind){
        super(wind);
    }

    @Override
    public void propertyChange(PropertyChangeEvent evt) {
        setValue("wind", 1,(double)evt.getNewValue());
        // support.firePropertyChange("temperature", evt.getNewValue(), evt.getOldValue());

    }
    
}
