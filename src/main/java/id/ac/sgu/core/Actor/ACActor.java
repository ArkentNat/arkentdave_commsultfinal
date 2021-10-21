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

// public class ACActor implements PropertyChangeListener {
//     double temperature;
//     TemperatureSensor ts;
//     // public String turnOnOff(){
//     // if(getTemperature() > 30){
//     // this.status = "Open";
//     // return "Blind Open";
//     // }
//     // else {
//     // this.status = "Closed";
//     // return "Blind Closed";
//     // }
//     // }
    
//     @Override
//     public void propertyChange(PropertyChangeEvent evt) {

//         System.out.print(evt);
//         if ((double) evt.getNewValue() > 20) {
//             System.out.println("Temperature Actor: " + evt.getNewValue() + " :  AC Closed.");
//         } else {
//             System.out.println("Temperature Actor: " + evt.getNewValue() + " : AC Open.");
//         }
//         // if (evt.getNewValue() instanceof LocalTime) {
//         //     LocalTime time = (LocalTime) evt.getNewValue();
//         // } else {
//         //     System.out.print(evt);
//         //     if ((double) evt.getNewValue() > 20) {
//         //         System.out.println("Temperature Actor: " + evt.getNewValue() + " :  AC Closed.");
//         //     } else {
//         //         System.out.println("Temperature Actor: " + evt.getNewValue() + " : AC Open.");
//         //     }
//         //     setTemperature((double) evt.getNewValue());
//         // }

//     }

//     public double getTemperature() {
//         return temperature;
//     }

//     public void setTemperature(double temperature) {
//         this.temperature = temperature;
//     }
// }
