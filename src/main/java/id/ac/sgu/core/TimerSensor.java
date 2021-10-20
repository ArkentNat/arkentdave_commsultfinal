package id.ac.sgu.core;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.time.LocalTime;

public class TimerSensor implements PropertyChangeListener {
    
    private LocalTime time;
    private final PropertyChangeSupport support = new PropertyChangeSupport(this);

    public TimerSensor(LocalTime time){
        this.time = time;
        // System.out.println(time);
    }

    public void addPropertyChangeListener(String propertyName, PropertyChangeListener listener) {
        this.support.addPropertyChangeListener(propertyName, listener);
    }

    public void removePropertyChangeListener(PropertyChangeListener listener) {
        this.support.removePropertyChangeListener(listener);
    }

    public LocalTime getTime() {
        return time;
    }

    public void setTime(LocalTime newTime) {
        System.out.println("New Time: " + newTime);
        System.out.println("Old Time" + this.time);
        LocalTime oldTime = this.time;
        this.time = newTime;
        support.firePropertyChange("time", oldTime, newTime);
    }

    @Override
    public void propertyChange(PropertyChangeEvent evt) {
        // setTemperature(evt.getNewValue());
        System.out.println("From listener: " + evt.getNewValue());
        // setTemperature((double) evt.getNewValue());
        setTime((LocalTime)evt.getNewValue());
        // support.firePropertyChange("time", evt.getNewValue(), evt.getOldValue());

    }

    
}
