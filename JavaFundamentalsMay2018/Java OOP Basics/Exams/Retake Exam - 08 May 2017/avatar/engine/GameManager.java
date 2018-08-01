package engine;

import entities.benders.Bender;
import entities.monuments.Monument;
import factories.BenderFactory;
import factories.MonumentFactory;
import utils.Constants;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Nino Bonev - 31.7.2018 г., 21:23
 */
public class GameManager {
    private Map<String, List<Bender>> benders;
    private Map<String, List<Monument>> monuments;
    private List<String> warsData;

    public GameManager() {
        this.setBenders();
        this.setMonuments();
        this.warsData = new ArrayList<>();
    }

    public void createBender(String type, String name, long power, double secondaryParameter){
        Bender bender = BenderFactory.createBender(type, name, power, secondaryParameter);
        List<Bender> benderList = this.benders.get(type);
        benderList.add(bender);
        this.benders.put(type, benderList);
    }

    public void createMonument(String type, String name, int affinity){
        Monument monument = MonumentFactory.createMonument(type, name, affinity);
        List<Monument> monumentList = this.monuments.get(type);
        monumentList.add(monument);
        this.monuments.put(type, monumentList);
    }

    public String getStatus(String nation){
        StringBuilder status = new StringBuilder();
        status.append(String.format("%s Nation\nBenders:", nation));
        if (this.benders.get(nation).size() > 0) {
            status.append(System.lineSeparator());
            for (Bender bender : this.benders.get(nation)) {
                status.append("###").append(bender.toString());
            }
        } else {
            status.append(" None\n");
        }
        status.append("Monuments:");
        if (this.monuments.get(nation).size() > 0) {
            status.append(System.lineSeparator());
            for (Monument monument : this.monuments.get(nation)) {
                status.append("###").append(monument.toString());
            }
        } else {
            status.append(" None\n");
        }
        return status.toString().trim();
    }

    public void war(String nation){
        this.warsData.add(nation);
        double result = 0;
        String winner = "";
        for (Map.Entry<String, List<Bender>> entry : benders.entrySet()) {
            double currentResult = entry.getValue().stream().mapToDouble(Bender::getTotalPower).sum() +
                    entry.getValue().stream().mapToDouble(Bender::getTotalPower).sum() / Constants.DIVIDER *
                    this.monuments.get(entry.getKey()).stream().mapToInt(Monument::getAffinity).sum();

            if (currentResult > result){
                result = currentResult;
                winner = entry.getKey();
            }
        }
        for (String bender : this.benders.keySet()) {
            if (bender != winner){
                this.benders.put(bender, new ArrayList<Bender>());
            }
        }
        for (String monument : monuments.keySet()) {
            if (monument != winner){
                this.monuments.put(monument, new ArrayList<Monument>());
            }
        }
    }

    public String quit(){
        StringBuilder sb = new StringBuilder();
        int count = 1;
        for (String war : warsData) {
            sb.append(String.format("War %d issued by %s\n", count++, war));
        }
        return sb.toString().trim();
    }

    public void setBenders() {
        this.benders = new LinkedHashMap<>();
        this.benders.put("Air", new ArrayList<>());
        this.benders.put("Water", new ArrayList<>());
        this.benders.put("Fire", new ArrayList<>());
        this.benders.put("Earth", new ArrayList<>());

    }

    public void setMonuments() {
        this.monuments = new LinkedHashMap<>();
        this.monuments.put("Air", new ArrayList<>());
        this.monuments.put("Water", new ArrayList<>());
        this.monuments.put("Fire", new ArrayList<>());
        this.monuments.put("Earth", new ArrayList<>());
    }
}
