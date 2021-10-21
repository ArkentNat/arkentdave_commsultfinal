package id.ac.sgu.core;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

public class BlindActor implements PropertyChangeListener{

    @Override
	public void propertyChange(PropertyChangeEvent evt) {
        System.out.println(evt);
        System.out.println("Blind Actor: " + evt.getNewValue());
    }
}
