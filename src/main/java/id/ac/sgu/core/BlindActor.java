package id.ac.sgu.core;

import java.time.LocalTime;

public class BlindActor {
    public String detect(LocalTime time) {
        int value = time.compareTo(LocalTime.of(12,0));

        if(value > 0) {
            return "Blind is Closed";
        }
        else {
            return "Blind is Opened";
        }
    }
}

// public class BlindActor implements PropertyChangeListener{

//     @Override
// 	public void propertyChange(PropertyChangeEvent evt) {
//         System.out.println(evt);
//         System.out.println("Blind Actor: " + evt.getNewValue());
//     }
// }
