package co.com.sofka.horseapp.domain.horse.event;

import co.com.sofka.horseapp.domain.generic.DomainEvent;

public class HorseCreated extends DomainEvent {

    private final String horseId;
    private final String gameId;

    public HorseCreated(String horseId, String gameId) {
        super("sofkau.horse.horsecreated");
        this.horseId = horseId;
        this.gameId = gameId;
    }

    public String getHorseId() {
        return horseId;
    }

    public String getGameId() {
        return gameId;
    }
}
