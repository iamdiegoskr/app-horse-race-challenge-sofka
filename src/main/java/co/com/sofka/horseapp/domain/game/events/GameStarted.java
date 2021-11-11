package co.com.sofka.horseapp.domain.game.events;

import co.com.sofka.horseapp.domain.generic.DomainEvent;

import java.time.LocalDateTime;


public class GameStarted extends DomainEvent {

    private final LocalDateTime localDate;
    private final Boolean state;

    public GameStarted() {
        super("sofkau.game.gamestarted");
        this.localDate = LocalDateTime.now();
        this.state = true;
    }

    public LocalDateTime getLocalDate() {
        return localDate;
    }

    public Boolean getState() {
        return state;
    }
}
