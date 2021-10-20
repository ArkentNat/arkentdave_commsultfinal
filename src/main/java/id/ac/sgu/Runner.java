package id.ac.sgu;

public class Runner {
    public static void main(String[] args){
        // Controller c = new Controller();
        World w = new World();
        TemperatureSensor ts = new TemperatureSensor(0);
        // TemperatureSensor ts = new TemperatureSensor(0);

        w.startSensor();

    }
}
