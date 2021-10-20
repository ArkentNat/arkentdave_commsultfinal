package id.ac.sgu.core;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;

public class WindSensor extends SensorImpl implements Sensor{
    private double wind;
    private final PropertyChangeSupport support = new PropertyChangeSupport(this);

    // public void addPropertyChangeListener(String propertyName, PropertyChangeListener listener) {
    //     this.support.addPropertyChangeListener(propertyName, listener);
    // }

    // public void removePropertyChangeListener(PropertyChangeListener listener) {
    //     this.support.removePropertyChangeListener(listener);
    // }

    public WindSensor(double wind){
        super(wind);
    }


    @Override
    public void propertyChange(PropertyChangeEvent evt) {
        // setTemperature(evt.getNewValue());
        // System.out.println("From listener: " + evt.getNewValue());
        // setTemperature((double) evt.getNewValue());
        setValue("wind", (double)evt.getNewValue());
        // support.firePropertyChange("temperature", evt.getNewValue(), evt.getOldValue());

    }


    @Override
    public String turnOnOff(){
        String result;
        if(super.getValue() > 25){
            //super.setTrigger("AC ON");
            System.out.println("AC ON");
            result = "AC ON";
        }
        else{
            //super.setTrigger("AC OFF");
            System.out.println("AC OFF");
            result = "AC OFF";
        }

        return result;
    }
    
}
