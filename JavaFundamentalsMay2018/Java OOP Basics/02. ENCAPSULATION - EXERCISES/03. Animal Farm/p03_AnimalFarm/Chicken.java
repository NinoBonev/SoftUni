package p03_AnimalFarm;

import com.sun.org.apache.xpath.internal.operations.Operation;

/**
 * Created by Nino Bonev - 21.6.2018 г., 12:33
 */
public class Chicken {
    private String name;
    private Integer age;
    private String productPerDay;

    public Chicken(String name, Integer age) {
        this.setName(name);
        this.setAge(age);
    }

    private void setName(String name) {
        if (name.trim().length() < 1){
            throw new IllegalArgumentException("Name cannot be empty.");
        }
        this.name = name;
    }

    private void setAge(Integer age) {
        if (age < 0 || age > 15){
            throw new IllegalArgumentException("Age should be between 0 and 15.");
        }
        this.age = age;
    }

    private String calculateProductPerDay(){
        if (this.age <= 5){
            this.productPerDay = "2";
        } else if (this.age >= 6 || this.age <= 11){
            this.productPerDay = "1";
        } else {
            this.productPerDay = "0.75";
        }
        return this.productPerDay;
    }

    @Override
    public String toString() {
        return "Chicken " + this.name + " (age " + this.age + ") can produce " + this.calculateProductPerDay() + " eggs per day.";
    }
}
