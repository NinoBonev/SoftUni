package p08_Military_Elite;

/**
 * Created by Nino Bonev - 30.6.2018 г., 10:15
 */
public class Mission {
    private String codeName;
    private String state;

    public Mission(String codeName, String state) {
        this.codeName = codeName;
        this.setState(state);
    }

    public void setState(String state) {
        if (!(state.equals("inProgress") || state.equals("Finished"))){
            throw new IllegalArgumentException("");
        }
        this.state = state;
    }

    public String getCodeName() {
        return codeName;
    }

    public void setCodeName(String codeName) {
        this.codeName = codeName;
    }

    public String getState() {
        return state;
    }

    @Override
    public String toString() {
        return String.format("Code Name: %s State: %s", this.getCodeName(), this.getState());
    }
}
