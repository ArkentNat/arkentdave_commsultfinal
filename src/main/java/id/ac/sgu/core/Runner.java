package id.ac.sgu.core;

import java.time.LocalTime;

import id.ac.sgu.core.Sensor.TemperatureSensor;
import id.ac.sgu.core.Sensor.TimerSensor;
import id.ac.sgu.core.Sensor.WindSensor;
import id.ac.sgu.core.UI.HomeUI;
import id.ac.sgu.core.UI.SensorStatus;

public class Runner {
    public static void main(String[] args){
        TemperatureSensor ts = new TemperatureSensor(0);
        WindSensor ws = new WindSensor(0);
        TimerSensor tms = new TimerSensor(LocalTime.of(0,0));
        SensorStatus sUI = new SensorStatus();
        Controller c = new Controller(ts, ws, tms);

        ts.addPropertyChangeListener("temperature", c);
        ts.addPropertyChangeListener("temperature", sUI);
        ws.addPropertyChangeListener("wind", c);
        ws.addPropertyChangeListener("wind",sUI);
        tms.addPropertyChangeListener("time", c);
        tms.addPropertyChangeListener("time", sUI);
        
        World w = new World();
        w.addPropertyChangeListener("temperature", ts);
        w.addPropertyChangeListener("wind", ws);
        w.addPropertyChangeListener("time", tms);
        w.startSensor();

    }
}