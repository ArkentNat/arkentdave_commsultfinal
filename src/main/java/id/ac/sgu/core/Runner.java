package id.ac.sgu.core;

import java.time.LocalTime;

public class Runner {
    public static void main(String[] args){
        TemperatureSensor ts = new TemperatureSensor(0);
        WindSensor ws = new WindSensor(0);
        TimerSensor tms = new TimerSensor(LocalTime.of(0,0));
        ACActor ac = new ACActor();
        Controller c = new Controller(ts, ws, tms);
        ts.addPropertyChangeListener("temperature", c);
        c.addPropertyChangeListener("temperature", ac);
        ws.addPropertyChangeListener("wind", c);
        tms.addPropertyChangeListener("time", c);
        World w = new World();
        w.addPropertyChangeListener("temperature", ts);
        w.addPropertyChangeListener("wind", ws);
        w.addPropertyChangeListener("time", tms);
        w.startSensor();

    }
}
