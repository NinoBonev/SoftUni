package p09_TrafficLights;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

/**
 * Created by Nino Bonev - 24.7.2018 г., 16:02
 */
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Signal> signals = Arrays.stream(scanner.nextLine().split(" ")).map(Signal::valueOf).collect(Collectors.toList());
        List<TrafficLight> trafficLights = new LinkedList<>();

        for (Signal signal:
             signals) {
            TrafficLight trafficLight = new TrafficLight(signal);
            trafficLights.add(trafficLight);
        }

        Integer updateIndex = Integer.parseInt(scanner.nextLine());

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < updateIndex; i++) {
            StringBuilder current = new StringBuilder();
            trafficLights.forEach(x -> current.append(x.update() + " "));
            sb.append(current.toString().trim()).append(System.lineSeparator());
        }

        System.out.println(sb.toString());
    }
}
