package hell.interfaces;

import hell.entities.items.CommonItem;

import java.util.List;

/**
 * Created by Nino Bonev - 19.8.2018 г., 19:05
 */
public interface CommonItemFactory {

    public CommonItem createCommonItem(List<String> arguments);
}
