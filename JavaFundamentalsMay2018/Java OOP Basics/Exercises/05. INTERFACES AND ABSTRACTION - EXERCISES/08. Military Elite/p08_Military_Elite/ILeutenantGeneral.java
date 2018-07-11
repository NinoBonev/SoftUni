package p08_Military_Elite;

import java.util.Set;

/**
 * Created by Nino Bonev - 30.6.2018 г., 10:41
 */
public interface ILeutenantGeneral {
    Set<Private> getPrivates();
    void addPrivate(Private newPrivate);
}
