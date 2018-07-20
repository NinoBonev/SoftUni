package centers;


/**
 * Created by Nino Bonev - 18.7.2018 г., 21:25
 */
public abstract class Center {
    private String name;

    Center(String name) {
        this.name = name;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

}
