package panzer.factories;

import panzer.contracts.Vehicle;
import panzer.models.vehicles.Revenger;
import panzer.models.vehicles.Vanguard;

import java.math.BigDecimal;

/**
 * Created by Nino Bonev - 1.8.2018 г., 19:42
 */
public class VehicleFactoryImpl {

    public VehicleFactoryImpl() {}

    public Vehicle createVehicle(String[] vehicleInfo) {
        String type = vehicleInfo[0];
        String model = vehicleInfo[1];
        double weight = Double.parseDouble(vehicleInfo[2]);
        BigDecimal price = new BigDecimal(vehicleInfo[3]);
        int attack = Integer.parseInt(vehicleInfo[4]);
        int defence = Integer.parseInt(vehicleInfo[5]);
        int hitPoints = Integer.parseInt(vehicleInfo[6]);
        switch (type) {
            case "Vanguard":
                return new Vanguard(model, weight, price, attack, defence, hitPoints);
            case "Revenger":
                return new Revenger(model, weight, price, attack, defence, hitPoints);
            default:
                return null;
        }
    }
}
