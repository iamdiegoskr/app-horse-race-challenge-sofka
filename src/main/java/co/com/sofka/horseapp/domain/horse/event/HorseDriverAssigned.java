package co.com.sofka.horseapp.domain.horse.event;

import co.com.sofka.horseapp.domain.generic.DomainEvent;

public class HorseDriverAssigned extends DomainEvent {

    private final String name;
    private final String identificationCard;

    public HorseDriverAssigned(String name, String identificationCard) {
        super("sofkau.horse.horsedriverassigned");
        this.name = name;
        this.identificationCard = identificationCard;
    }

    public String getName() {
        return name;
    }

    public String getIdentificationCard() {
        return identificationCard;
    }
}
