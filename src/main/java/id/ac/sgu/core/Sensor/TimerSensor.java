package id.ac.sgu.core.Sensor;

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

    public void setTime( LocalTime oldTime, LocalTime newTime) {
        this.time = newTime;
        support.firePropertyChange("time", oldTime, newTime);
    }

    @Override
    public void propertyChange(PropertyChangeEvent evt) {
        setTime((LocalTime)evt.getOldValue(), (LocalTime)evt.getNewValue());
    }
}
