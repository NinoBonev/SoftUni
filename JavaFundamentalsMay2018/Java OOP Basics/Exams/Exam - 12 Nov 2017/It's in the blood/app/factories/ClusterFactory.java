package app.factories;

import app.entities.clusters.Cluster;

/**
 * Created by Nino Bonev - 12.7.2018 г., 0:25
 */
public final class ClusterFactory {

    private ClusterFactory(){}

    public static Cluster createCluster(String Id, int row, int col){
        return new Cluster(Id, row, col);
    }
}
