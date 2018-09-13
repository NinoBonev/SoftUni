package constants;

/**
 * Created by Nino Bonev - 3.8.2018 г., 16:01
 */
public class Messages {

    public static final String ADDED_HERO = "Added hero: %s"; //name
    public static final String ADDED_GUILD = "Added Guild: %s"; //name
    public static final String ADDED_PROVINCE = "Created province %s"; //name
    public static final String SELECTED_PROVINCE = "Province %s selected!"; //name
    public static final String ALREADY_SELECTED = "Province %s has already been selected!";
    public static final String NOT_ADDED_PROVINCE = "Province with name %s already exists!"; //name
    public static final String NOT_EXISTING_PROVINCE = "Province %s does not exist"; //name
    public static final String UPDATED_HERO = "Updated hero: %s"; //{heroName}
    public static final String NOT_UPDATED = "Hero %s can not be replaced by a weaker one.";//{name}
    public static final String REMOVE_HERO = "Successfully removed hero [%s] from guild %s";//{heroName} - {guildName}
    public static final String REMOVE_GUILD = "Removed guild [%s] with %d members.";//{{guildName}} - {guildSize}
    public static final String NO_SUCH_HERO_TYPE = "No such hero type!";//{{guildName}} - {guildSize}
    public static final String INVALID_CHARACTERS = "Invalid character stats!";//{{guildName}} - {guildSize}
    public static final String EXISTING_GUILD = "Guild already exists.";//{{guildName}} - {guildSize}
    public static final String NO_PROVINCE_SELECTED = "No province selected!";//{{guildName}} - {guildSize}
    public static final String NO_EXISTING_GUILD = "Guild [%s] does not exist.";//{{guildName}} - {guildSize}
    public static final String REMOVED_GUILD = "Removed guild %s with %d members.";//{{guildName}} - {guildSize}


    public static final String COMPLETED_MISSION_STATUS = "Completed";
    //{name} - {name} - {id} - {assignedMissionsCount} - {completedMissionsCount} - {rating}
    public static final String GUILD_DETAILS_MESSAGE = "Guild: %s\n" +
            "###Heroes:";
    //{agentType} - {name} - {id} - {assignedMissionsCount} - {completedMissionsCount} - {rating} - {bounty}
    public static final String HERO_DETAILED_MESSAGE = "Hero: %s, Type: [%s]\n" +//{heroName} - {heroType}
            "#Stats: \n" +
            "Health: %d\n" + //health
            "Fatigue: %d\n" + //fatigue
            "Magicka: %d\n";
    //{missionType} - {id} - {Open / Completed} - {rating} - {bounty}
    public static final String MISSION_STATUS = "%s Mission - %s\n" +
            "Status: %s\n" +
            "Rating: %.2f\n" +
            "Bounty: %.2f\n";
    //{noviceAgentsCount} - {masterAgentsCount} - {totalAssignedMissionsCount} - {totalCompletedMissionsCount} - {totalRatingEarned} - {totalBountyEarned}
    public static final String OVER_MESSAGE = "Novice Agents: %d\n" +
            "Master Agents: %d\n" +
            "Assigned Missions: %d\n" +
            "Completed Missions: %d\n" +
            "Total Rating Given: %.2f\n" +
            "Total Bounty Given: $%.2f\n";

    public static final String NO_SUCH_HERO = "No such hero in this guild!";
    public static final String SUCCESSFULLY_REMOVED_HERO = "Successfully removed hero [%s] from guild %s";//{heroName} - {guildName}
    public static final String HEROES_INFO = "Hero: %s, Offense: %.2f, Defense: %.2f";
}
