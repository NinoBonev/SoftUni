package p04_Telephony;

import java.util.List;

/**
 * Created by Nino Bonev - 29.6.2018 г., 13:09
 */
public class Smartphone implements Call, Browse {
//    public List<String> numbers;
//    public List<String> URLs;

    @Override
    public void browseURL(String URL) {
        if (URL == null || URL.chars().anyMatch(Character::isDigit)){
            throw new IllegalArgumentException("Invalid URL!");
        }
        System.out.println(String.format("Browsing: %s!", URL));
    }

    @Override
    public void callNumber(String number) {
        if (number == null || !number.chars().allMatch(Character::isDigit)){
            throw new IllegalArgumentException("Invalid number!");
        }
        System.out.println(String.format("Calling... %s", number));
    }
}
