import java.util.*;

/**
 * Created by Nino Bonev - 22.6.2018 г., 18:41
 */
public class Robotics {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Map<String, Integer> robots = new LinkedHashMap<>();
        String[] robotsInfo = scanner.nextLine().split(";");
        for (int i = 0; i < robotsInfo.length; i++) {
            String robot = robotsInfo[i].split("-")[0];
            Integer processingTime = Integer.parseInt(robotsInfo[1].split("-")[1]);
            robots.putIfAbsent(robot, processingTime);
        }

        String startTime = scanner.nextLine();
        Integer hour = Integer.parseInt(startTime.split(":")[0]);
        Integer minutes = Integer.parseInt(startTime.split(":")[1]);
        Integer seconds = Integer.parseInt(startTime.split(":")[2]);

        ArrayDeque<String> elementsQueue = new ArrayDeque<>();
        String line;
        while (!"End".equals(line = scanner.nextLine())){
            elementsQueue.offer(line);
        }
        while (!elementsQueue.isEmpty()){
            Map<String, String> robotsTime = new HashMap<>();
            String elementToTake = elementsQueue.poll();
            for (Map.Entry<String, Integer> entry:
                 robots.entrySet()) {
                if (!robotsTime.containsKey(entry.getKey())){
                    robotsTime.put(entry.getKey(), setTime(hour, minutes, seconds, entry.getValue()));
                    seconds++;
                    if (seconds > 60){
                        Integer addMinutes = seconds % 60;
                        minutes += addMinutes;
                        if (minutes >= 60){
                            Integer addHours = minutes % 60;
                            hour += addHours;
                        }
                    }
                }
                System.out.println(String.format("%s - %s [%d:%d:%d]", entry.getKey(), elementToTake, hour, minutes, seconds));
            }
        }
    }

    private static String setTime(Integer hour, Integer minutes, Integer seconds, Integer addTimeInSeconds){
        seconds += addTimeInSeconds;
        if (seconds >= 60){
            Integer addMinutes = seconds % 60;
            minutes += addMinutes;
            if (minutes >= 60){
                Integer addHours = minutes % 60;
                hour += addHours;
            }
        }
        return String.format("%d:%d:%d", hour, minutes, seconds);
    }
}
