package p09_TrafficLights;

/**
 * Created by Nino Bonev - 24.7.2018 г., 16:12
 */
public class TrafficLight {
    private Signal signal;

    public TrafficLight(Signal signal) {
        this.signal = signal;
    }

    public String update(){
        int current = this.signal.ordinal();
        Signal[] signals= Signal.values();
        this.signal = signals[(current + 1) % 3];
        return this.signal.name();
    }

    @Override
    public String toString() {
        return "TrafficLight{" +
                "signal=" + signal +
                '}';
    }
}
