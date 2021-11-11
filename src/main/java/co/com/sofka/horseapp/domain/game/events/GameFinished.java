package co.com.sofka.horseapp.domain.game.events;

import co.com.sofka.horseapp.domain.generic.DomainEvent;

import java.time.LocalDateTime;


public class GameFinished extends DomainEvent {

    private final LocalDateTime localDate;
    private final Boolean state;

    public GameFinished() {
        super("sofkau.game.gamefinished");
        this.localDate = LocalDateTime.now();
        this.state = false;
    }

    public LocalDateTime getLocalDate() {
        return localDate;
    }

    public Boolean getState() {
        return state;
    }
}
