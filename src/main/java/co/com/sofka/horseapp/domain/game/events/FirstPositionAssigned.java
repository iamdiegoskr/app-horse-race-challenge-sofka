package co.com.sofka.horseapp.domain.game.events;

import co.com.sofka.horseapp.domain.generic.DomainEvent;

public class FirstPositionAssigned extends DomainEvent {

    private final String playerId;
    public FirstPositionAssigned(String playerId) {
        super("sofkau.game.firstpositionassigned");
        this.playerId = playerId;
    }

    public String getPlayerId() {
        return playerId;
    }
}
