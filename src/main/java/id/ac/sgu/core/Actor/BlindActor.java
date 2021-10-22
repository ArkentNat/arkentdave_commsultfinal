package id.ac.sgu.core.Actor;

import java.time.LocalTime;

public class BlindActor {
    
    public String detect(LocalTime time) {
        int value = time.compareTo(LocalTime.of(12,0));

        if(value > 0) {
            return "Blind Closed";
        }
        else {
            return "Blind Opened";
        }
    }
}
