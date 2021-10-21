package id.ac.sgu.core;

import java.time.LocalTime;

import id.ac.sgu.core.Sensor.TemperatureSensor;
import id.ac.sgu.core.Sensor.TimerSensor;
import id.ac.sgu.core.Sensor.WindSensor;
import id.ac.sgu.core.UI.HomeUI;

public class Runner {
    public static void main(String[] args){
        TemperatureSensor ts = new TemperatureSensor(0);
        WindSensor ws = new WindSensor(0);
        TimerSensor tms = new TimerSensor(LocalTime.of(0,0));
        HomeUI hUI = new HomeUI();
        // ACActor ac = new ACActor();
        // BlindActor bc = new BlindActor();
        Controller c = new Controller(ts, ws, tms);
        ts.addPropertyChangeListener("temperature", c);
        ts.addPropertyChangeListener("temperature", hUI);
        // c.addPropertyChangeListener("temperature", ac);
        ws.addPropertyChangeListener("wind", c);
        ws.addPropertyChangeListener("wind", hUI);
        tms.addPropertyChangeListener("time", c);
        tms.addPropertyChangeListener("time", hUI);
        // c.addPropertyChangeListener("time", bc);
        World w = new World();
        w.addPropertyChangeListener("temperature", ts);
        w.addPropertyChangeListener("wind", ws);
        w.addPropertyChangeListener("time", tms);
        w.startSensor();

    }
}
