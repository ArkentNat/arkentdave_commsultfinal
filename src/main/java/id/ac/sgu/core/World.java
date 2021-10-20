package id.ac.sgu.core;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.util.Random;

public class World {
    double temperature;
    private final PropertyChangeSupport support = new PropertyChangeSupport(this);

    public void addPropertyChangeListener(PropertyChangeListener listener) {
        this.support.addPropertyChangeListener(listener);
    }

    public void removePropertyChangeListener(PropertyChangeListener listener) {
        this.support.removePropertyChangeListener(listener);
    }

    public void startSensor() {
        Random rand = new Random();
        
        Thread t = new Thread(new Runnable() {
            @Override
            public void run(){
                while(true){
                    setTemperature(40 * rand.nextDouble());
                    System.out.println("World: " + 40*rand.nextDouble());
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

    public void setTemperature(double newValue) {
        double oldValue = this.temperature;
        this.temperature = newValue;
        support.firePropertyChange("value", oldValue, newValue);
    }

    
}
