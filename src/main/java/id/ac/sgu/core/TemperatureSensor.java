package id.ac.sgu.core;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;

public class TemperatureSensor extends SensorImpl implements Sensor {
    private double temperature;
    private final PropertyChangeSupport support = new PropertyChangeSupport(this);

    public void addPropertyChangeListener(String propertyName, PropertyChangeListener listener) {
        this.support.addPropertyChangeListener(propertyName, listener);
    }

    public void removePropertyChangeListener(PropertyChangeListener listener) {
        this.support.removePropertyChangeListener(listener);
    }

    public TemperatureSensor(double temperature){
        super(temperature);
        
        Controller c = new Controller();
        this.addPropertyChangeListener("temperature", c);

    }

    public double getTemperature() {
        return temperature;
    }

    public void setTemperature(double temperature) {
        double oldTemperature = this.temperature;
        double newTemperature = temperature;
        this.temperature = temperature;
        // System.out.println("Test: " + temperature);
        support.firePropertyChange("temperature", oldTemperature, newTemperature);
    }

    @Override
    public void propertyChange(PropertyChangeEvent evt) {
        // setTemperature(evt.getNewValue());
        // System.out.println("From listener: " + evt.getNewValue());
        setTemperature((double) evt.getNewValue());
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
