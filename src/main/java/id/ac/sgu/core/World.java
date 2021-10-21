package id.ac.sgu.core;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.time.LocalTime;
import java.util.Random;

public class World {
    double temperature;
    double wind;
    LocalTime time;
    private final PropertyChangeSupport support = new PropertyChangeSupport(this);

    public void addPropertyChangeListener(String propertyName, PropertyChangeListener listener) {
        this.support.addPropertyChangeListener(propertyName, listener);
    }

    public void removePropertyChangeListener(PropertyChangeListener listener) {
        this.support.removePropertyChangeListener(listener);
    }

    public void startSensor() {
        Random rand = new Random();
        time = LocalTime.of(0,0);
        // TemperatureSensor ts = new TemperatureSensor(0);
        // this.addPropertyChangeListener("temperature", ts);
        Thread t = new Thread(new Runnable() {
            @Override
            public void run(){
                while(true){
                    double temp = 40 * rand.nextDouble();
                    double wind = 50 * rand.nextDouble();
                    time = time.plusHours(1);
                    setTemperature(temp);
                    setWind(wind);
                    setTime(time);

                    // System.out.println("World: " + temp);
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

    public double getWind() {
        return wind;
    }

    public void setWind(double wind) {
        double oldWind = this.wind;
        double newWind = wind;
        this.wind = wind;
        support.firePropertyChange("wind", oldWind, newWind);
    }

    public LocalTime getTime() {
        return time;
    }

    public void setTime(LocalTime time) {
        LocalTime oldTime = this.time.minusHours(1);
        LocalTime newTime = time;
        this.time = time;
        System.out.println(time);
        System.out.println(oldTime);

        support.firePropertyChange("time", oldTime, newTime);
    }
}
