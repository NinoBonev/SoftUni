import java.util.*;
import java.util.stream.Collectors;

/**
 * Created by Nino Bonev - 27.8.2018 г., 7:08
 */
public class Agency {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] Ids = scanner.nextLine().split(" ");
        ArrayDeque<String> IdStack = new ArrayDeque<>();

        for (int i = 0; i < Ids.length; i++) {
            IdStack.push(Ids[i]);

        }

        String[] agents = scanner.nextLine().split(" ");
        ArrayDeque<String> agentsQueue = new ArrayDeque<>();

        for (int i = 0; i < agents.length; i++) {
            agentsQueue.offer(agents[i]);
        }

        String line;
        while (!"stop".equals(line = scanner.nextLine())){
            String command = line.split(" ")[0];
            switch (command){
                case "add-ID" :
                    String Id = line.split(" ")[1];
                    IdStack.push(Id);
                    break;
                case "add-agent" :
                    String agent = line.split(" ")[1];
                    agentsQueue.offer(agent);
                    break;
                case "remove-ID" :
                    String removedId = IdStack.pop();
                    System.out.println(String.format("%s has been removed.", removedId));
                    break;
                case "remove-agent" :
                    String removedAgent = agentsQueue.pollLast();
                    System.out.println(String.format("%s has left the queue.", removedAgent));
                    break;
                case "sort-ID" :
                    IdStack = IdStack.stream()
                            .sorted(Comparator.reverseOrder())
                            .collect(Collectors.toCollection(ArrayDeque::new));
                    break;
            }
        }

        while (!(IdStack.isEmpty() || agentsQueue.isEmpty())){
            String currentAgent = agentsQueue.poll();
            String currentId = IdStack.pop();
            System.out.println(String.format("%s takes ID number: %s", currentAgent, currentId));
        }
        if (IdStack.size() > 0){
            System.out.println("No more agents left.");
            while (!IdStack.isEmpty()){
                String leftId = IdStack.pop();
                System.out.println(String.format("ID number: %s", leftId));
            }
        }
        if (agentsQueue.size() > 0){
            while (!agentsQueue.isEmpty()){
                String leftAgent = agentsQueue.poll();
                System.out.println(String.format("%s does not have an ID.", leftAgent));
            }
        }
    }
}
