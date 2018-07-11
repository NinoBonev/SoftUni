package p09_Google;

/**
 * Created by Nino Bonev - 19.6.2018 г., 10:00
 */
public class Pokemon {
    private String name;
    private String type;

    public Pokemon() {
    }

    public Pokemon(String name, String type) {
        this.name = name;
        this.type = type;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return this.type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getInfo(){return String.format("%s %s", this.getName(), this.getType());}
}
