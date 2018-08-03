package panzer.factories;

import panzer.contracts.Part;
import panzer.models.parts.ArsenalPart;
import panzer.models.parts.EndurancePart;
import panzer.models.parts.ShellPart;

import java.math.BigDecimal;

/**
 * Created by Nino Bonev - 1.8.2018 г., 19:42
 */
public class PartFactoryImpl{

    public PartFactoryImpl(){}

    public Part createPart(String[] partInfo) {
        /*
        Parameters – vehicleModel (string), type (string), model (string), weight (double), price (decimal), additionalParameter (integer).
         */
        String vehicleModel = partInfo[0];
        String type = partInfo[1];
        String model = partInfo[2];
        double weight = Double.parseDouble(partInfo[3]);
        BigDecimal price = new BigDecimal(partInfo[4]);
        int additionalParameter = Integer.parseInt(partInfo[5]);

        switch (type){
            case "Arsenal" : return new ArsenalPart(model, weight, price, additionalParameter);
            case "Shell" : return new ShellPart(model, weight, price, additionalParameter);
            case "Endurance" : return new EndurancePart(model, weight, price, additionalParameter);
            default: return null;
        }
    }
}
