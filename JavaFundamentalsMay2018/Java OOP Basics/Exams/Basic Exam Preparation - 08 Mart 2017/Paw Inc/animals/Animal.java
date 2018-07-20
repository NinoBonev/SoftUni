package animals;

/**
 * Created by Nino Bonev - 18.7.2018 г., 21:25
 */
public abstract class Animal {
    private String name;
    private int age;
    private boolean cleansingStatus;

    Animal(String name, int age) {
        this.name = name;
        this.age = age;
        this.cleansingStatus = false;
    }

    public String getName() {
        return this.name;
    }

    public int getAge() {
        return this.age;
    }

    public boolean isCleansingStatus() {
        return this.cleansingStatus;
    }

    public void changeCleansingStatus(boolean changeStatus) {
        this.cleansingStatus = changeStatus;
    }

    @Override
    public String toString() {
        return this.getName();
    }
}
