package p10_Inferno_Infinity;

import java.util.*;

/**
 * Created by Nino Bonev - 24.7.2018 г., 16:34
 */
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Map<String, Weapon> weapons = new LinkedHashMap<>();
        String line;

        while (!"END".equals(line = scanner.nextLine())){
            String[] lineData = line.split(";");
            String weaponType;
            String weaponName;
            Integer socketIndex;

            Class weaponClass = Weapon.class;
            MyAnnotation weaponInfo = (MyAnnotation) weaponClass.getAnnotation(MyAnnotation.class);

            switch (lineData[0]){
                case "Create" :
                    weaponType = lineData[1];
                    weaponName = lineData[2];
                    Weapon weapon = new Weapon(WeaponType.valueOf(weaponType), weaponName);
                    weapons.putIfAbsent(weaponName, weapon);
                    break;
                case "Add" :
                    weaponName = lineData[1];
                    socketIndex = Integer.parseInt(lineData[2]);
                    String gemType = lineData[3];
                    weapons.get(weaponName).addGem(socketIndex, Gem.valueOf(gemType));
                    break;
                case "Remove" :
                    weaponName = lineData[1];
                    socketIndex = Integer.parseInt(lineData[2]);
                    weapons.get(weaponName).removeGem(socketIndex);
                    break;
                case "Print" :
                    weaponName = lineData[1];
                    System.out.println(weapons.get(weaponName).toString());
                    break;
                case "Compare" :
                    weaponName = lineData[1];
                    String otherWeaponName = lineData[2];
                    if (weapons.get(weaponName).compareTo(weapons.get(otherWeaponName)) >= 0 ){
                        System.out.println(weapons.get(weaponName).print());
                    } else {
                        System.out.println(weapons.get(otherWeaponName).print());
                    }
                    break;
                case "Author" :
                    System.out.println(String.format("Author: %s", weaponInfo.author()));
                    break;
                case "Revision" :
                    System.out.println(String.format("Revision: %d", weaponInfo.revision()));
                    break;
                case "Description" :
                    System.out.println(String.format("Class description: %s", weaponInfo.description()));
                    break;
                case "Reviewers" :
                    StringBuilder sb = new StringBuilder();
                    sb.append("Reviewers: ");
                    sb.append(String.join(", ", weaponInfo.reviewers()));
                    System.out.println(sb.toString());
                    break;
            }
        }
    }
}
