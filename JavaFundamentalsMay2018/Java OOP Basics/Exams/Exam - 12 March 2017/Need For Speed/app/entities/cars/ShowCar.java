package app.entities.cars;

import app.utils.Constants;

/**
 * Created by Nino Bonev - 14.7.2018 г., 8:58
 */
public class ShowCar extends Car {
    private int stars;

    public ShowCar(String brand, String model, int yearOfProduction,
                   int horsepower, int acceleration, int suspension, int durability) {
        super(brand, model, yearOfProduction, horsepower, acceleration, suspension, durability);
        this.stars = Constants.SHOW_CAR_STARS_DEFAULT_VALUE;
    }

    public int getStars() {
        return stars;
    }

    public void setStars(int stars) {
        this.stars = stars;
    }

    @Override
    public void tune(int tuneIndex, String tuneAddOn) {
        super.tune(tuneIndex, tuneAddOn);
        this.setStars(this.stars + tuneIndex);
    }

    @Override
    public String toString() {
        return String.format("%s%d *%n", super.toString(), this.stars).trim();
    }
}
