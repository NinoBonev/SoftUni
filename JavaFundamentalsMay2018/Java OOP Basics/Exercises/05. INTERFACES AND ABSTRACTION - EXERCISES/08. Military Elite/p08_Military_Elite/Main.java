package p08_Military_Elite;

import java.util.*;

/**
 * Created by Nino Bonev - 30.6.2018 г., 10:06
 */
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Map<String, Private> privateMap = new HashMap<>();
        List<Soldier> soldiers = new LinkedList<>();

        String line;
        while (!"End".equals(line = scanner.nextLine())){
            String[] data = line.split(" ");
            String id = data[1];
            String firstName = data[2];
            String lastName = data[3];
            Double salary = Double.parseDouble(data[4]);
            switch (data[0]){
                case "Private" :
                    Private private_ = new Private(id, firstName, lastName, salary);
                    privateMap.put(id, private_);
                    soldiers.add(private_);
                    break;
                case "LeutenantGeneral" :
                    LeutenantGeneral leutenantGeneral = new LeutenantGeneral(id, firstName, lastName, salary);
                    for (int i = 5; i < data.length; i++) {
                        leutenantGeneral.addPrivate(privateMap.get(data[i]));
                    }
                    soldiers.add(leutenantGeneral);
                    break;
                case "Engineer" :
                    String corps = data[5];
                    try {
                        Engineer engineer = new Engineer(id, firstName, lastName, salary, corps);
                        for (int i = 6; i < data.length; i += 2) {
                            String repairPart = data[i];
                            Integer repairHours = Integer.parseInt(data[i + 1]);
                            Repair repair = new Repair(repairPart, repairHours);
                            engineer.addRepair(repair);
                        }
                        soldiers.add(engineer);
                    } catch (IllegalArgumentException exp){
                        System.out.println(exp.getMessage());
                    }
                    break;
                case "Commando" :
                    String corps_ = data[5];
                    Commando commando = new Commando(id, firstName, lastName, salary, corps_);
                    for (int i = 6; i < data.length; i += 2) {
                        String missionCodeName = data[i];
                        String missionState = data[i + 1];
                        try {
                            Mission mission = new Mission(missionCodeName, missionState);
                            commando.addMission(mission);
                        } catch (IllegalArgumentException exp){
                            System.out.print(exp.getMessage());
                        }
                    }
                    soldiers.add(commando);
                    break;
                case "Spy" :
                    String codeNumber = data[4];
                    Spy spy = new Spy(id, firstName, lastName, codeNumber);
                    soldiers.add(spy);
                    break;
            }
        }

        soldiers.forEach(System.out::print);
    }
}
