package cresla.entities.modules;

import cresla.constants.Messages;
import cresla.interfaces.Module;

/**
 * Created by Nino Bonev - 3.8.2018 г., 8:43
 */
public abstract class BaseModule implements Module {
    private int Id;

    BaseModule(int id) {
        Id = id;
    }

    @Override
    public int getId() {
        return this.Id;
    }

    @Override
    public String toString() {
        return String.format(Messages.BASIC_MODULE_STRING, this.getClass().getSimpleName(), this.getId());
    }
}
