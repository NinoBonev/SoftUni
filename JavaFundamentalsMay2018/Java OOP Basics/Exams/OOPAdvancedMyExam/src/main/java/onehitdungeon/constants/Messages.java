package onehitdungeon.constants;

import java.util.Locale;

/**
 * Created by Nino Bonev - 3.8.2018 г., 16:01
 */
public class Messages {

    public static final String AGENT_CREATED = "Registered Agent - %s:%s"; //name, id
    public static final String REQUEST_MISSION = "Assigned %s Mission - %s to Agent - %s";//{missionType} - {missionId} - {agentName}
    public static final String COMPLETE = "Agent - %s:%s has completed all assigned missions.";//{name} - {id}
    public static final String OPEN_MISSION_STATUS = "Open";
    public static final String COMPLETED_MISSION_STATUS = "Completed";
    //{agentType} - {name} - {id} - {assignedMissionsCount} - {completedMissionsCount} - {rating}
    public static final String NOVICE_AGENT_STATUS = "%s - %s\n" +
            "Personal Code: %s\n" +
            "Assigned Missions: %d\n" +
            "Completed Missions: %d\n" +
            "Rating: %.2f\n";
    //{agentType} - {name} - {id} - {assignedMissionsCount} - {completedMissionsCount} - {rating} - {bounty}
    public static final String MASTER_AGENT_STATUS = "%s - %s\n" +
            "Personal Code: %s\n" +
            "Assigned Missions: %d\n" +
            "Completed Missions: %d\n" +
            "Rating: %.2f\n" +
            "Bounty Earned: $%.2f\n";
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

    public static final String ADDED_HERO = "Successfully added %s - %s.";
    public static final String SELECTED_HERO = "Successfully selected %s - %s.";
    public static final String GET_SELECTED_PALADIN_INFO = "%s - Lvl. %d Paladin\n" +
            "* Mace - %d (BP)\n" +
            "* Shield - %d (BP)\n" +
            "* Cuirass - %d (BP)\n" +
            "####################\n" +
            "Gold: %.2f\n" +
            "Upgrade cost: %.2f\n";
    public static final String GET_SELECTED_MAGE_INFO = "%s - Lvl. %d Mage\n" +
            "* Staff - %d (BP)\n" +
            "* Orb - %d (BP)\n" +
            "* Cape - %d (BP)\n" +
            "####################\n" +
            "Gold: %.2f\n" +
            "Upgrade cost: %.2f\n";
    public static final String MAGE = "Mage";
    public static final String PALADIN = "Paladin";
    public static final String ADVANCED = "Successfully advanced to dungeon level %d.";
    public static final String FIGHT_WON = "Fight won. You've gained %.2f gold.";
    public static final String FIGHT_LOST = "Fight lost. You've returned to the previous level.";
    public static final String TRAIN_HERO = "Successfully trained hero. Current total battle power: %d.";
    public static final String UNABLE_TO_TRAIN_HERO = "Insufficient gold for training. Needed %.2f. Got %.2f.";
    public static final String HERO_DETAILS = "%s %s - %d (BP)";
    public static final String DUNGEON_INFO = "Dungeon level reached: %d";
}
