package interfaces;

import entities.places.Guild;

/**
 * Created by Nino Bonev - 29.8.2018 г., 9:56
 */
public interface IProvince {

    String addGuild(Guild guild);

    String removeGuild(Guild guild);

    Guild getGuildByName(String guildName);

    boolean contains(String guildName);
}
