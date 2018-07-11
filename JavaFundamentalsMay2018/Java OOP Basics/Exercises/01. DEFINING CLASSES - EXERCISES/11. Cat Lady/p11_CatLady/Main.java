package p11_CatLady;

import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

/**
 * Created by Nino Bonev - 19.6.2018 г., 11:30
 */
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Cat> cats = new LinkedList<>();
        Cat cat = new Cat();
        cats.add(cat);

        String line;
        while (!"End".equals(line = scanner.nextLine())){
            String[] catInfo = line.split(" ");
            String breed = catInfo[0];
            switch (breed){
                case "Siamese" :
                    String name = catInfo[1];
                    double earSize = Double.parseDouble(catInfo[2]);
                    cat.addSiamese(name, earSize);
                    break;
                case "Cymric" :
                    String catName = catInfo[1];
                    double furLength = Double.parseDouble(catInfo[2]);
                    cat.addCymrics(catName, furLength);
                    break;
                case "StreetExtraordinaire" :
                    String cat_name = catInfo[1];
                    double decibelsOfMeows = Double.parseDouble(catInfo[2]);
                    cat.addStreetExtraordinaires(cat_name, decibelsOfMeows);
                    break;
            }
        }

        String nameToPrint = scanner.nextLine();
        for (Cat _cat:
             cats) {
            for (Cymric cymric:
                 _cat.getCymrics()) {
                if (cymric.getName().equals(nameToPrint)){
                    System.out.printf("Cymric %s %.2f", cymric.getName(), cymric.getFurLength());
                }
            }
            for (Siamese siamese:
                 _cat.getSiamese()) {
                if (siamese.getName().equals(nameToPrint)){
                    System.out.printf("Siamese %s %.2f", siamese.getName(), siamese.getEarSize());
                }
            }
            for (StreetExtraordinaire str:
                 _cat.getStreetExtraordinaires()) {
                if (str.getName().equals(nameToPrint)){
                    System.out.printf("StreetExtraordinaire %s %.2f", str.getName(), str.getDecibelsOfMeows());
                }
            }
        }
    }
}
