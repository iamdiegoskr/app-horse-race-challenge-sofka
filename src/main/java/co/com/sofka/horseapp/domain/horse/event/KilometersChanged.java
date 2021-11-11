package co.com.sofka.horseapp.domain.horse.event;

import co.com.sofka.horseapp.domain.generic.DomainEvent;

public class KilometersChanged extends DomainEvent {

    private final Integer advance;
    private final String laneId;
    private final String gameId;

    public KilometersChanged(Integer advance, String laneId, String gameId) {
        super("sofkau.horse.kilometerschanged");
        this.advance = advance;
        this.laneId = laneId;
        this.gameId = gameId;
    }

    public Integer getAdvance() {
        return advance;
    }

    public String getLaneId() {
        return laneId;
    }

    public String getGameId() {
        return gameId;
    }
}
