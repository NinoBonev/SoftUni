package app.entities.races;

import app.entities.cars.Car;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by Nino Bonev - 14.7.2018 г., 8:55
 */
public class CasualRace extends Race {
    public CasualRace(int length, String route, int prizePool) {
        super(length, route, prizePool);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(String.format("%s", super.toString()));
        int[] index = new int[]{1};
        this.getParticipants().stream()
                .sorted((a, b) -> Integer.compare(b.getOverallPerformance(), a.getOverallPerformance()))
                .limit(3)
                .forEach(car -> {
                    sb.append(String.format("%d. %s %s %dPP - $%d%n", index[0]++, car.getBrand(), car.getModel(), car.getOverallPerformance(),
                            this.getPrizePool() * getPercent(index[0]) / 100));
                });
        return sb.toString().trim();
    }
}
