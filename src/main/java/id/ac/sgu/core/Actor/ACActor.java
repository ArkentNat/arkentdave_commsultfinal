package id.ac.sgu.core.Actor;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.time.LocalTime;

public class ACActor {

    public String detect(double temp){
        if(temp > 20){
            return "AC ON";
        }
        else {
            return "AC OFF";
        }
    }
}
