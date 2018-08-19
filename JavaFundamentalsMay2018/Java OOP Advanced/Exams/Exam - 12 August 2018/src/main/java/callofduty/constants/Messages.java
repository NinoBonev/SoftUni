package callofduty.constants;

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
}
