package co.com.sofka.horseapp.domain.game.events;

import co.com.sofka.horseapp.domain.generic.DomainEvent;

public class PlayerAssigned extends DomainEvent {

    private final String identificationCard;
    private final String name;

    public PlayerAssigned(String identificationCard, String name) {
        super("sofkau.game.playerassigned");
        this.identificationCard = identificationCard;
        this.name = name;
    }


    public String getIdentificationCard() {
        return identificationCard;
    }

    public String getName() {
        return name;
    }
}
