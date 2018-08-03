package cresla.IdGenerator;

/**
 * Created by Nino Bonev - 3.8.2018 г., 9:23
 */
public class IdGenerator {
    private int Id;

    public IdGenerator() {
        Id = 0;
    }

    public int takeId(){
        this.Id++;
       return this.Id;
    }
}
