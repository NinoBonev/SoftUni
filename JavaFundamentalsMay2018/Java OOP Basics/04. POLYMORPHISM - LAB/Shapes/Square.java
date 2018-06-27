/**
 * Created by Nino Bonev - 26.6.2018 г., 8:25
 */
public class Square extends Rectangle implements AreaNino {
    private double sideA;


    public Square(double sideA) {
        super(sideA);
    }

    @Override
    public Double area() {
        return super.getSideA() * super.getSideA();
    }
}
