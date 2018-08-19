package hell.interfaces;

import java.util.List;

/**
 * Created by Nino Bonev - 19.8.2018 г., 19:11
 */
public interface Manager {

    public String createHero(List<String> arguments);

    public String createCommonItem(List<String> arguments);

    public String createRecipeItem(List<String> arguments);

    public String inspectHero(List<String> arguments);

    public String quitCommand(List<String> arguments);


}
