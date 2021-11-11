package co.com.sofka.horseapp.domain.lane.events;

import co.com.sofka.domain.generic.Incremental;
import co.com.sofka.horseapp.domain.generic.DomainEvent;

public class GoalAchieved extends DomainEvent implements Incremental {

    private final String playerId;
    private final String gameId;

    public GoalAchieved(String playerId, String gameId) {
        super("sofkau.lane.goalachieved");
        this.playerId = playerId;
        this.gameId = gameId;
    }

    public String getPlayerId() {
        return playerId;
    }

    public String getGameId() {
        return gameId;
    }
}
