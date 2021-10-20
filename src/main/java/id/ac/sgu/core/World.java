package id.ac.sgu.core;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.util.Random;

public class World {
    double temperature;
    private final PropertyChangeSupport support = new PropertyChangeSupport(this);

    public void addPropertyChangeListener(String propertyName, PropertyChangeListener listener) {
        this.support.addPropertyChangeListener(propertyName, listener);
    }

    public void removePropertyChangeListener(PropertyChangeListener listener) {
        this.support.removePropertyChangeListener(listener);
    }

    public void startSensor() {
        Random rand = new Random();
        TemperatureSensor ts = new TemperatureSensor(0);
        this.addPropertyChangeListener("temperature", ts);
        Thread t = new Thread(new Runnable() {
            @Override
            public void run(){
                while(true){
                    double temp = 40 * rand.nextDouble();
                    setTemperature(temp);
                    System.out.println("World: " + temp);
                    try {
                        Thread.sleep(3000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        });
        t.start();
    }

    public double getTemperature() {
        return temperature;
    }

    public void setTemperature(double temperature) {
        double oldTemperature = this.temperature;
        double newTemperature = temperature;
        this.temperature = temperature;
        support.firePropertyChange("temperature", oldTemperature, newTemperature);
    }

    
}
