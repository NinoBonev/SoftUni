package p06_Animals;

/**
 * Created by Nino Bonev - 24.6.2018 г., 10:38
 */
public class Animal {
    private String name;
    private double age;
    private String gender;

    public Animal() {
    }

    public Animal(String name, double age, String gender) {
        this.setName(name);
        this.setAge(age);
        this.setGender(gender);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        if (name == null || name.trim().isEmpty()){
            throw new IllegalArgumentException("Invalid input!");
        }
        this.name = name;
    }

    public double getAge() {
        return age;
    }

    public void setAge(Double age) {
        if (age < 1){
            throw new IllegalArgumentException("Invalid input!");
        }
        this.age = age;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        if (gender == null || gender.trim().isEmpty()){
            throw new IllegalArgumentException("Invalid input!");
        }
        this.gender = gender;
    }

    protected String produceSound(){
        return "Not implemented!";
    }

    @Override
    public String toString() {
        return String.format("%s\n%s %.0f %s\n%s", this.getClass().getSimpleName(),
                this.getName(), this.getAge(), this.getGender(), this.produceSound());
    }
}
