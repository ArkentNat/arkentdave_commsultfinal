package id.ac.sgu.core.Sensor;
import java.beans.PropertyChangeEvent;

public class TemperatureSensor extends SensorImpl {

    public TemperatureSensor(double temperature){
        super(temperature);
    }

    @Override
    public void propertyChange(PropertyChangeEvent evt) {
        setValue("temperature", (double)evt.getNewValue());
    }
    
}
