package co.com.sofka.horseapp.domain.game.events;

import co.com.sofka.horseapp.domain.generic.DomainEvent;

public class GameCreated extends DomainEvent {

    private final String gameId;
    private final Integer kilometers;
    private final Integer numberOfLanes;
    private final Integer currentFinalPosition;
    private final Boolean state;

    public GameCreated(String id, Integer kilometers, Integer numberOfLanes) {
        super("sofkau.game.gamecreated");
        this.gameId = id;
        this.kilometers = kilometers;
        this.numberOfLanes = numberOfLanes;
        this.currentFinalPosition = 0;
        this.state = false;
    }

    public Integer getCurrentFinalPosition() {
        return currentFinalPosition;
    }

    public String getGameId() {
        return gameId;
    }

    public Boolean getState() {
        return state;
    }

    public Integer getKilometers() {
        return kilometers;
    }

    public Integer getNumberOfLanes() {
        return numberOfLanes;
    }
}
