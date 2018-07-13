package app.entities;

import app.entities.cells.Cell;
import app.entities.clusters.Cluster;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Created by Nino Bonev - 11.7.2018 г., 18:23
 */
public class Organism {
    private String name;
    private List<Cluster> clusters;

    public Organism(String name) {
        this.name = name;
        this.clusters = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public List<Cluster> getClusters() {
        return Collections.unmodifiableList(this.clusters);
    }

    public boolean addCluster(Cluster cluster){
        for (Cluster currentCluster:
             clusters) {
            if (currentCluster.getId().equals(cluster.getId())){
                return false;
            }
        }
        this.clusters.add(cluster);
        return true;
    }

    public Cluster getClusterById(String clusterId){
        for (Cluster cluster : clusters) {
            if (cluster.getId().equals(clusterId)){
                return cluster;
            }
        }

        return null;
    }

    public int getCellsCount(){
        int count = 0;

        for (Cluster cluster:
             clusters) {
            for (Cell[] cells:
                 cluster.getCells()) {
                for (Cell cell:
                     cells) {
                    if (cell != null){
                        count++;
                    }
                }
            }
        }

        return count;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(String.format("Organism - %s%n--Clusters: %d%n--Cells: %d%n",
                this.name, this.clusters.size(), this.getCellsCount()));

        for (Cluster cluster : clusters) {
            sb.append(cluster.toString());
        }

        return sb.toString();
    }

    public void moveClusterToTheEnd() {
        Cluster cluster = this.clusters.get(0);
        this.clusters.remove(cluster);
        this.clusters.add(cluster);
    }
}
