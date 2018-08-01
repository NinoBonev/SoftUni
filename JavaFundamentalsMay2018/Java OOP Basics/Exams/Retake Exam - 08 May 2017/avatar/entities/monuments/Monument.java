package entities.monuments;

/**
 * Created by Nino Bonev - 31.7.2018 г., 18:50
 */
public abstract class Monument {
    private String name;

    Monument(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public abstract int getAffinity();
}
