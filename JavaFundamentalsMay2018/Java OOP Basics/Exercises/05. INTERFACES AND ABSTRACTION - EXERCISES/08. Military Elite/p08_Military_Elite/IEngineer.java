package p08_Military_Elite;

import java.util.Set;

/**
 * Created by Nino Bonev - 30.6.2018 г., 10:51
 */
public interface IEngineer {
    Set<Repair> getRepairs();
    void addRepair(Repair newRepair);
}
