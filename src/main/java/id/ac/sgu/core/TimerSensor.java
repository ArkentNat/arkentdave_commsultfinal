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
        LocalTime oldTime = this.time;
        this.time = newTime;
        support.fireIndexedPropertyChange("time", 2, oldTime, newTime);
    }

    @Override
    public void propertyChange(PropertyChangeEvent evt) {
        setTime((LocalTime)evt.getNewValue());
        // support.firePropertyChange("time", evt.getOldValue(), evt.getNewValue());
    }

    
}
