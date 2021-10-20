package id.ac.sgu.core;
import java.beans.PropertyChangeEvent;

public class TemperatureSensor extends SensorImpl implements Sensor {
    private double temperature;

    public TemperatureSensor(double temperature){
        super(temperature);
        System.out.println("Temperature Sensor: " + temperature);
        World world = new World();
        world.addPropertyChangeListener(e ->
            setTemperature((double) e.getNewValue())
        );
    }

    public double getTemperature() {
        return temperature;
    }

    public void setTemperature(double temperature) {
        this.temperature = temperature;
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
