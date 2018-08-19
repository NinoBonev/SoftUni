package callofduty.manager;

import callofduty.constants.Messages;
import callofduty.domain.agents.BaseAgent;
import callofduty.domain.agents.MasterAgent;
import callofduty.domain.agents.NoviceAgent;
import callofduty.factories.AgentFactory;
import callofduty.interfaces.Agent;
import callofduty.interfaces.Mission;
import callofduty.interfaces.MissionControl;
import callofduty.interfaces.MissionManager;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Nino Bonev - 3.8.2018 г., 15:59
 */
public class ManagerImpl implements MissionManager {
    private final MissionControl missionControl;
    private final AgentFactory agentFactory;
    private final Map<String, Agent> agents;
    private final Map<String, Mission> missions;

    public ManagerImpl(MissionControl missionControl) {
        this.missionControl = missionControl;
        this.agents = new LinkedHashMap<>();
        this.missions = new LinkedHashMap<>();
        this.agentFactory = new AgentFactory();
    }

    @Override
    public String agent(List<String> arguments) {
        String id = arguments.get(0);
        String name = arguments.get(1);
        Agent agent = agentFactory.createAgent(arguments);
        this.agents.put(id, agent);

        return String.format(Messages.AGENT_CREATED, name, id);
    }

    @Override
    public String request(List<String> arguments) {
        String agentId = arguments.get(0);
        String missionId = arguments.get(1);
        Double missionRating = Double.parseDouble(arguments.get(2));
        Double missionBounty = Double.parseDouble(arguments.get(3));
        Mission mission = missionControl.generateMission(missionId, missionRating, missionBounty);
        this.missions.put(missionId, mission);
        this.agents.get(agentId).acceptMission(mission);
        return String.format(Messages.REQUEST_MISSION,
                mission.getClass().getSimpleName().replace("Mission", ""),
                missionId,
                this.agents.get(agentId).getName());
    }

    @Override
    public String complete(List<String> arguments) {
        String agentId = arguments.get(0);
        Agent agent = this.agents.get(agentId);
        agent.completeMissions();
        int completedMissionsCount = 0;
        List<Mission> getList = null;
        try {
            Field completedMissions = BaseAgent.class.getDeclaredField("completedMissions");
            completedMissions.setAccessible(true);
            List<Mission> castCompletedMissions = (List<Mission>) completedMissions.get(agent);
            getList = castCompletedMissions;
            completedMissionsCount = castCompletedMissions.size();
        } catch (NoSuchFieldException | IllegalAccessException e) {
            e.printStackTrace();
        }
        if (completedMissionsCount >= 3 && agent instanceof NoviceAgent){
            Agent masterAgent = new MasterAgent(agent.getId(), agent.getName(), agent.getRating());
            setAgentMissions(masterAgent, "completedMissions", getList);

            this.agents.remove(agentId);
            this.agents.put(agentId, masterAgent);
        }
        return String.format(Messages.COMPLETE,
                this.agents.get(agentId).getName(),
                this.agents.get(agentId).getId());
    }

    @Override
    public String status(List<String> arguments) {
        String result = "";
        if (this.agents.containsKey(arguments.get(0))){
            Agent agent = this.agents.get(arguments.get(0));
            int allMissionsCount = 0;
            int completedMissionsCount = 0;
            try {
                Field allMissions = BaseAgent.class.getDeclaredField("missions");
                Field completedMissions = BaseAgent.class.getDeclaredField("completedMissions");
                allMissions.setAccessible(true);
                completedMissions.setAccessible(true);
                List<Mission> castMissions = (List<Mission>) allMissions.get(agent);
                List<Mission> castCompletedMissions = (List<Mission>) completedMissions.get(agent);
                allMissionsCount = castMissions.size();
                completedMissionsCount = castCompletedMissions.size();
            } catch (NoSuchFieldException | IllegalAccessException e) {
                e.printStackTrace();
            }
            String agentType = agent.getClass().getSimpleName();
            switch (agentType){
                case "NoviceAgent" : result = String.format(Messages.NOVICE_AGENT_STATUS,
                        agentType.replace("Agent", " Agent"),
                        agent.getName(),
                        agent.getId(),
                        allMissionsCount,
                        completedMissionsCount,
                        agent.getRating());
                break;
                case "MasterAgent" : result = String.format(Messages.MASTER_AGENT_STATUS,
                        agentType.replace("Agent", " Agent"),
                        agent.getName(),
                        agent.getId(),
                        allMissionsCount,
                        completedMissionsCount,
                        agent.getRating(),
                        ((MasterAgent)agent).getBounty()); break;
            }
        }
        if (missions.containsKey(arguments.get(0))){
            Mission mission = this.missions.get(arguments.get(0));
            Boolean isOpen = false;
            for (Agent agent : this.agents.values()) {
                try {
                    Field allMissions = BaseAgent.class.getDeclaredField("missions");
                    allMissions.setAccessible(true);
                    List<Mission> castMissions = (List<Mission>) allMissions.get(agent);
                    if (castMissions.contains(mission)){
                        isOpen = true;
                    }
                } catch (NoSuchFieldException | IllegalAccessException e) {
                    e.printStackTrace();
                }
            }
            result = String.format(Messages.MISSION_STATUS,
                    mission.getClass().getSimpleName().replace("Mission", ""),
                    mission.getId(),
                    isOpen ? Messages.OPEN_MISSION_STATUS : Messages.COMPLETED_MISSION_STATUS,
                    mission.getRating(),
                    mission.getBounty());
        }
        return result;
    }

    @Override
    public String over(List<String> arguments) {
        Integer noviceAgentsCount = 0;
        Integer masterAgentsCount = 0;
        Integer totalAssignedMissionsCount = 0;
        Integer totalCompletedMissionsCount = 0;
        Double totalRatingEarned = 0.0;
        Double totalBountyEarned = 0.0;

        for (Agent agent : agents.values()) {
            if (agent instanceof NoviceAgent){
                noviceAgentsCount++;
                totalRatingEarned += agent.getRating();
            }
            if (agent instanceof MasterAgent){
                masterAgentsCount++;
                totalRatingEarned += agent.getRating();
                totalBountyEarned += ((MasterAgent)agent).getBounty();
            }
            try {
                Field completedMissions = BaseAgent.class.getDeclaredField("completedMissions");
                completedMissions.setAccessible(true);
                List<Mission> castMissions = (List<Mission>) completedMissions.get(agent);
                totalCompletedMissionsCount += castMissions.size();
            } catch (NoSuchFieldException | IllegalAccessException e) {
                e.printStackTrace();
            }
        }
        totalAssignedMissionsCount = this.missions.size();

        return String.format(Messages.OVER_MESSAGE,
                noviceAgentsCount,
                masterAgentsCount,
                totalAssignedMissionsCount,
                totalCompletedMissionsCount,
                totalRatingEarned,
                totalBountyEarned);
    }

    private void setAgentMissions(Agent agent, String missionType, List<Mission> missions) {
        try {
            Field field = BaseAgent.class.getDeclaredField(missionType);
            field.setAccessible(true);
            field.set(agent, missions);
        } catch (NoSuchFieldException | SecurityException | IllegalArgumentException | IllegalAccessException e) {
            e.printStackTrace();
            missions = new ArrayList<>();
        }
    }
}
