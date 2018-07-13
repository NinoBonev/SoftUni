package app.engine;

import app.entities.Organism;
import app.entities.cells.Cell;
import app.entities.clusters.Cluster;
import app.factories.CellFactory;
import app.factories.ClusterFactory;
import app.factories.OrganismFactory;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * Created by Nino Bonev - 11.7.2018 г., 18:12
 */
public class HealthManager {
    private Map<String, Organism> organisms;

    public HealthManager() {
        this.organisms = new LinkedHashMap<>();
    }

    public String checkCondition(String organismName){

        if (this.organisms.containsKey(organismName)){
            return this.organisms.get(organismName).toString();
        }
        return "";
    }

    public String createOrganism(String organismName){
        if (this.organisms.containsKey(organismName)){
            return String.format("Organism %s already exists%n", organismName);
        }
        this.organisms.put(organismName, OrganismFactory.createOrganism(organismName));

        return String.format("Created organism %s%n", organismName);
    }

    public String addCluster(String organismName, String clusterId, int row, int col){
        if (this.organisms.containsKey(organismName)){
            Cluster cluster = ClusterFactory.createCluster(clusterId, row, col);
            boolean isAdded = this.organisms.get(organismName).addCluster(cluster);
            if (isAdded) {
                return String.format("Organism %s: Created cluster %s%n", organismName, clusterId);
            }
        }
        return "";
    }

    public String addCell(String organismName, String clusterId,
                          String cellType, String cellId , int health,
                          int row, int col, int addProperty){
        Cell cell = CellFactory.createCell(cellType, cellId, health, row, col, addProperty);
        if (this.organisms.containsKey(organismName)){
            Cluster cluster = this.organisms.get(organismName).getClusterById(clusterId);
            if (cluster != null){
                cluster.addCells(cell);
                return String.format("Organism %s: Created cell %s in cluster %s%n", organismName, cellId, clusterId);
            }
        }
        return "";
    }

    public String activateCluster(String organismName){
        if (this.organisms.containsKey(organismName)) {
            if (this.organisms.get(organismName).getClusters().size() > 0) {
                Cluster cluster = this.organisms.get(organismName).getClusters().get(0);

                cluster.activate();

                this.organisms.get(organismName).moveClusterToTheEnd();

                return String.format("Organism %s: Activated cluster %s." +
                                " Cells left: %d%n", organismName, cluster.getId(),
                        cluster.getCellsCount());
            }
        }
        return "";
    }
}
