package p01_ClassBox;

/**
 * Created by Nino Bonev - 21.6.2018 г., 11:31
 */
public class Box {
    private double length;
    private double width;
    private double height;
    private double surfaceArea;
    private double lateralSurfaceArea;
    private double volume;

    public Box(double length, double width, double height) {
        this.setLength(length);
        this.setWidth(width);
        this.setHeight(height);
    }

    public void setLength(double length) {
        if (length <= 0){
            throw new IllegalArgumentException("Length cannot be zero or negative.");
        }
        this.length = length;
    }

    public void setWidth(double width) {
        if (width <= 0){
            throw new IllegalArgumentException("Width cannot be zero or negative.");
        }
        this.width = width;
    }

    public void setHeight(double height) {
        if (height <= 0){
            throw new IllegalArgumentException("Height cannot be zero or negative.");
        }
        this.height = height;
    }

    public double calculateSurfaceArea(){
        this.surfaceArea = 2 * length * width + 2 * length * height + 2 * width * height;
        return this.surfaceArea;
    }

    public double calculateLateralSurfaceArea() {
        this.lateralSurfaceArea = 2 * length * height + 2 * width * height;
        return this.lateralSurfaceArea;
    }

    public double calculateVolume() {
        this.volume = length * width * height;
        return this.volume;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Surface Area - ").append(String.format("%.2f", calculateSurfaceArea())).append(System.lineSeparator());
        sb.append("Lateral Surface Area - ").append(String.format("%.2f", calculateLateralSurfaceArea())).append(System.lineSeparator());
        sb.append("Volume - ").append(String.format("%.2f", calculateVolume())).append(System.lineSeparator());
        return sb.toString().replace(",", ".");
    }
}
