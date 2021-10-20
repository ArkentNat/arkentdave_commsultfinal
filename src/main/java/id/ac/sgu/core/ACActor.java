package id.ac.sgu.core;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

public class ACActor implements PropertyChangeListener{
   double temperature;
    // public String turnOnOff(){
    //     if(getTemperature() > 30){
    //         this.status = "Open";
    //         return "Blind Open";
    //     }
    //     else {
    //         this.status = "Closed";
    //         return "Blind Closed";
    //     }
    // }

    @Override
	public void propertyChange(PropertyChangeEvent evt) {
        if((double) evt.getNewValue() > 20) {
            System.out.println("Temperature Actor: " + evt.getNewValue() + " :  AC Closed.");
        }
        else {
            System.out.println("Temperature Actor: " + evt.getNewValue() + " : AC Open.");
        }
        setTemperature((double) evt.getNewValue());
    }

    

    public double getTemperature() {
        return temperature;
    }

    public void setTemperature(double temperature) {
        this.temperature = temperature;
    }
}
