package softuniBabies.bindingModel;

public class BabyBindingModel {

    private String name;

    private String gender;

    private String birthday;

    public BabyBindingModel() {
    }

    public BabyBindingModel(String name, String gender, String birthday) {
        this.name = name;
        this.gender = gender;
        this.birthday = birthday;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getGender() {
        return this.gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getBirthday() {
        return this.birthday;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }
}
