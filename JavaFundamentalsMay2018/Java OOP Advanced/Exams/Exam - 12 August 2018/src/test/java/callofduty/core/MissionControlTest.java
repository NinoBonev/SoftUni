package callofduty.core;

import callofduty.interfaces.Mission;
import callofduty.interfaces.MissionControl;
import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by Nino Bonev - 20.8.2018 г., 9:56
 */
public class MissionControlTest {
    private MissionControl missionControl;

    @org.junit.Before
    public void setUp() throws Exception {
        this.missionControl = new MissionControlImpl();
    }

    @org.junit.Test
    public void generateMission() {
        String name = "1x1";
        Double rating = 100D;
        Double bounty = 100D;
        Mission mission;

        mission = this.missionControl.generateMission(name, rating, bounty);
        Assert.assertEquals(mission.getClass().getName(), "callofduty.domain.missions.EscortMission");
        Assert.assertEquals(name, mission.getId());
        Assert.assertEquals((rating * 0.75), mission.getRating(), 0.1);
        Assert.assertEquals(bounty * 1.25, mission.getBounty(), 0.1);

        mission = this.missionControl.generateMission(name, rating, bounty);
        Assert.assertEquals(mission.getClass().getName(), "callofduty.domain.missions.HuntMission");
        Assert.assertEquals(name, mission.getId());
        Assert.assertEquals((rating * 1.5), mission.getRating(), 0.1);
        Assert.assertEquals(bounty * 2.0, mission.getBounty(), 0.1);

        mission = this.missionControl.generateMission(name, rating, bounty);
        Assert.assertEquals(mission.getClass().getName(), "callofduty.domain.missions.SurveillanceMission");
        Assert.assertEquals(name, mission.getId());
        Assert.assertEquals((rating * 0.25), mission.getRating(), 0.1);
        Assert.assertEquals(bounty * 1.5, mission.getBounty(), 0.1);

        mission = this.missionControl.generateMission(name, rating, bounty);
        Assert.assertEquals(mission.getClass().getName(), "callofduty.domain.missions.EscortMission");
        Assert.assertEquals(name, mission.getId());
        Assert.assertEquals((rating * 0.75), mission.getRating(), 0.1);
        Assert.assertEquals(bounty * 1.25, mission.getBounty(), 0.1);
    }

    @Test
    public void testUnderBoundaries() {
        String missionId = "12345678";
        Double missionRating = -100D;
        Double missionBounty = -100D;
        Mission mission;

        // EscortMission - rating*0.75, bounty*1.25
        mission = missionControl.generateMission(missionId, missionRating, missionBounty);
        Assert.assertEquals(mission.getClass().getName(), "callofduty.domain.missions.EscortMission");
        Assert.assertEquals(missionId, mission.getId());
        Assert.assertEquals(0D * 0.75, mission.getRating(), 0.1);
        Assert.assertEquals(0D * 1.25, mission.getBounty(), 0.1);

        // HuntMission - rating*1.5, bounty*2
        mission = missionControl.generateMission(missionId, missionRating, missionBounty);
        Assert.assertEquals(mission.getClass().getName(), "callofduty.domain.missions.HuntMission");
        Assert.assertEquals(missionId, mission.getId());
        Assert.assertEquals(0D * 1.5, mission.getRating(), 0.1);
        Assert.assertEquals(0D * 2, mission.getBounty(), 0.1);

        // SurveillanceMission - rating * 0.25, bounty * 1.5
        mission = missionControl.generateMission(missionId, missionRating, missionBounty);
        Assert.assertEquals(mission.getClass().getName(), "callofduty.domain.missions.SurveillanceMission");
        Assert.assertEquals(missionId, mission.getId());
        Assert.assertEquals(0D * 0.25, mission.getRating(), 0.1);
        Assert.assertEquals(0D * 1.5, mission.getBounty(), 0.1);

        // EscortMission - rating*0.75, bounty*1.25
        mission = missionControl.generateMission(missionId, missionRating, missionBounty);
        Assert.assertEquals(mission.getClass().getName(), "callofduty.domain.missions.EscortMission");
        Assert.assertEquals(missionId, mission.getId());
        Assert.assertEquals(0D * 0.75, mission.getRating(), 0.1);
        Assert.assertEquals(0D * 1.25, mission.getBounty(), 0.1);
    }

    @Test
    public void testAboveBoundaries() {
        String missionId = "1234567890";
        Double missionRating = 1_000D;
        Double missionBounty = 1_000_000D;
        Mission mission;

        // EscortMission - rating*0.75, bounty*1.25
        mission = missionControl.generateMission(missionId, missionRating, missionBounty);
        Assert.assertEquals(mission.getClass().getName(), "callofduty.domain.missions.EscortMission");
        Assert.assertEquals(missionId.substring(0, 8), mission.getId());
        Assert.assertEquals(100D * 0.75, mission.getRating(), 0.1);
        Assert.assertEquals(100_000D * 1.25, mission.getBounty(), 0.1);

        // HuntMission - rating*1.5, bounty*2
        mission = missionControl.generateMission(missionId, missionRating, missionBounty);
        Assert.assertEquals(mission.getClass().getName(), "callofduty.domain.missions.HuntMission");
        Assert.assertEquals(missionId.substring(0, 8), mission.getId());
        Assert.assertEquals(100D * 1.5, mission.getRating(), 0.1);
        Assert.assertEquals(100_000D * 2, mission.getBounty(), 0.1);

        // SurveillanceMission - rating * 0.25, bounty * 1.5
        mission = missionControl.generateMission(missionId, missionRating, missionBounty);
        Assert.assertEquals(mission.getClass().getName(), "callofduty.domain.missions.SurveillanceMission");
        Assert.assertEquals(missionId.substring(0, 8), mission.getId());
        Assert.assertEquals(100D * 0.25, mission.getRating(), 0.1);
        Assert.assertEquals(100_000D * 1.5, mission.getBounty(), 0.1);

        // EscortMission - rating*0.75, bounty*1.25
        mission = missionControl.generateMission(missionId, missionRating, missionBounty);
        Assert.assertEquals(mission.getClass().getName(), "callofduty.domain.missions.EscortMission");
        Assert.assertEquals(missionId.substring(0, 8), mission.getId());
        Assert.assertEquals(100D * 0.75, mission.getRating(), 0.1);
        Assert.assertEquals(100_000D * 1.25, mission.getBounty(), 0.1);
    }
}