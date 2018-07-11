import java.awt.geom.Area;

/**
 * Created by Nino Bonev - 26.6.2018 г., 8:25
 */
public class Rectangle implements AreaNino{
    private double sideA;
    private double sideB;

    protected Rectangle(double sideA) {
        this.sideA = sideA;
    }

    public Rectangle(double sideA, double sideB) {
        this.sideA = sideA;
        this.sideB = sideB;
    }

    public double getSideA() {
        return sideA;
    }

    public void setSideA(double sideA) {
        this.sideA = sideA;
    }

    public double getSideB() {
        return sideB;
    }

    public void setSideB(double sideB) {
        this.sideB = sideB;
    }

    @Override
    public Double area() {
        return this.sideA * this.sideB;
    }
}
