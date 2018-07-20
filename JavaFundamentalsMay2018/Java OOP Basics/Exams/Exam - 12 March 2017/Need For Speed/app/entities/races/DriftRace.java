package app.entities.races;

/**
 * Created by Nino Bonev - 14.7.2018 г., 8:55
 */
public class DriftRace extends Race {
    public DriftRace(int length, String route, int prizePool) {
        super(length, route, prizePool);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(String.format("%s", super.toString()));
        int[] index = new int[]{1};
        this.getParticipants().stream()
                .sorted((a, b) -> Integer.compare(b.getSuspensionPerformance(), a.getSuspensionPerformance()))
                .limit(3)
                .forEach(car -> {
                    sb.append(String.format("%d. %s %s %dPP - $%d%n", index[0]++, car.getBrand(), car.getModel(),
                            car.getSuspensionPerformance(),
                            this.getPrizePool() * getPercent(index[0]) / 100));
                });
        return sb.toString().trim();
    }
}
