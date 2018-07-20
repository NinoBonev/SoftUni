package app.entities.races;

import app.entities.cars.Car;

import java.util.*;

/**
 * Created by Nino Bonev - 14.7.2018 г., 8:54
 */
public abstract class Race {
    private int length;
    private String route;
    private int prizePool;
    private LinkedList<Car> participants;

    public Race(int length, String route, int prizePool) {
        this.length = length;
        this.route = route;
        this.prizePool = prizePool;
        this.participants = new LinkedList<>();
    }

    public int getLength() {
        return length;
    }

    public void setLength(int length) {
        this.length = length;
    }

    public String getRoute() {
        return route;
    }

    public void setRoute(String route) {
        this.route = route;
    }

    public int getPrizePool() {
        return prizePool;
    }

    public void setPrizePool(int prizePool) {
        this.prizePool = prizePool;
    }

    public List<Car> getParticipants() {
        return Collections.unmodifiableList(this.participants);
    }

    public void addParticipants(Car participant) {
        this.participants.add(participant);
    }

    @Override
    public String toString(){
        StringBuilder sb = new StringBuilder();
        sb.append(String.format("%s - %d%n", this.getRoute(), this.getLength()));
        return sb.toString();
    }

    public int getPercent(int position){
        int percent = 0;
        switch (position){
            case 2 :
                percent = 50;
                break;
            case 3 :
                percent = 30;
                break;
            case 4 :
                percent = 20;
                break;
        }
        return percent;
    }
}
