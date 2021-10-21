package id.ac.sgu.core;

import java.time.LocalTime;

import id.ac.sgu.core.Sensor.TemperatureSensor;
import id.ac.sgu.core.Sensor.TimerSensor;
import id.ac.sgu.core.Sensor.WindSensor;

public class Runner {
	private TemperatureSensor ts;
	private WindSensor ws;
	private TimerSensor tms;
	
	private Controller c;
	
	private World w;
    public Runner() {
        ts = new TemperatureSensor(0);
        ws = new WindSensor(0);
        tms = new TimerSensor(LocalTime.of(0,0));
        // ACActor ac = new ACActor();
        // BlindActor bc = new BlindActor();
        c = new Controller(ts, ws, tms);
        ts.addPropertyChangeListener("temperature", c);
        // c.addPropertyChangeListener("temperature", ac);
        ws.addPropertyChangeListener("wind", c);
        tms.addPropertyChangeListener("time", c);
        // c.addPropertyChangeListener("time", bc);
        w = new World();
        w.addPropertyChangeListener("temperature", ts);
        w.addPropertyChangeListener("wind", ws);
        w.addPropertyChangeListener("time", tms);
        w.startSensor();

    }
    
    public World getWorld() {
    	return w;
    }
    
    public Controller getController() {
    	return c;
    }
}
