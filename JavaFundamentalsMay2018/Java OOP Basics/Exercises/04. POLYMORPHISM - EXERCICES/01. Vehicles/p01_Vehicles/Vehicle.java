package p01_Vehicles;

/**
 * Created by Nino Bonev - 26.6.2018 г., 9:03
 */
public interface Vehicle {
    void drive(double distance);
    void refuel(double quantity);
    double distanceTravelled(double distance);
}