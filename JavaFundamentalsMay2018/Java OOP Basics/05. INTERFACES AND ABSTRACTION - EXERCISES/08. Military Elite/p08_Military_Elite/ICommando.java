package p08_Military_Elite;

import java.util.Set;

/**
 * Created by Nino Bonev - 30.6.2018 г., 10:19
 */
public interface ICommando {
    Set<Mission> getMissions();
    void addMission(Mission newMission);
}
