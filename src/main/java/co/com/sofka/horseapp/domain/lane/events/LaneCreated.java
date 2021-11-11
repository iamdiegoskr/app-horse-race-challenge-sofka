package co.com.sofka.horseapp.domain.lane.events;

import co.com.sofka.horseapp.domain.generic.DomainEvent;

public class LaneCreated extends DomainEvent {

    private final Integer goal;
    private final String gameId;

    public LaneCreated(Integer goal, String gameId) {
        super("sofkau.lane.lanecreated");
        this.goal = goal;
        this.gameId = gameId;
    }

    public Integer getGoal() {
        return goal;
    }

    public String getGameId() {
        return gameId;
    }
}
