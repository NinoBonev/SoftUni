import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class PadawanEquipment {
    public static void main(String[] args) throws IOException {

        BufferedReader console = new BufferedReader(new InputStreamReader(System.in));

        double money = Double.parseDouble(console.readLine());
        short studentsCount = Short.parseShort(console.readLine());
        double lightsabers = Double.parseDouble(console.readLine());
        double robes = Double.parseDouble(console.readLine());
        double belts = Double.parseDouble(console.readLine());

        double equipmentCost = 0;
        double realLightsabrsCount = Math.ceil(studentsCount * 1.1);
        double realBeltsCount = studentsCount - (studentsCount / 6);

        equipmentCost = studentsCount * robes + realLightsabrsCount * lightsabers + realBeltsCount * belts;

        if (equipmentCost <= money)
            {
            System.out.printf("The money is enough - it would cost %.2flv.%n", equipmentCost);
            }
        else
            {
                System.out.printf("Ivan Cho will need %.2flv more.", equipmentCost - money);
            }
    }

}

