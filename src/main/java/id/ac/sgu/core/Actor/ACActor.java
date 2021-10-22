package id.ac.sgu.core.Actor;

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
