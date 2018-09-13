package entities.places;

import constants.Messages;
import interfaces.IProvince;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Nino Bonev - 29.8.2018 г., 9:21
 */
public class Province implements IProvince {
    private String name;
    private Map<String, Guild> guilds;

    public Province(String name) {
        this.name = name;
        this.guilds = new LinkedHashMap<>();
    }

    public Map<String, Guild> getGuilds() {
        return guilds;
    }

    @Override
    public String addGuild(Guild guild) {
        if (!this.guilds.containsKey(guild.getName())){
            this.guilds.put(guild.getName(), guild);
        }
        return String.format(Messages.ADDED_GUILD, guild.getName());
    }

    @Override
    public String removeGuild(Guild guild) {
        if (this.guilds.containsKey(guild.getName())){
            this.guilds.remove(guild.getName());
        }
        return String.format(Messages.REMOVE_GUILD, guild.getName(), guild.getGuildSize());
    }

    @Override
    public Guild getGuildByName(String guildName) {
        if (this.guilds.containsKey(guildName)){
            return this.guilds.get(guildName);
        }
        return null;
    }

    @Override
    public boolean contains(String guildName) {
        return this.guilds.containsKey(guildName);
    }
}
