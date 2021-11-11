package co.com.sofka.horseapp.domain.horse;

import co.com.sofka.horseapp.domain.game.Player;
import co.com.sofka.horseapp.domain.generic.EventChange;
import co.com.sofka.horseapp.domain.horse.event.HorseCreated;
import co.com.sofka.horseapp.domain.horse.event.HorseDriverAssigned;
import co.com.sofka.horseapp.domain.horse.event.KilometersChanged;
import co.com.sofka.horseapp.domain.generic.AggregateRoot;
import co.com.sofka.horseapp.domain.generic.DomainEvent;

import java.util.List;
import java.util.Objects;
import java.util.Random;

public class Horse extends AggregateRoot implements EventChange {

    private Player player;
    private Integer distanceTraveled;
    private String gameId;

    public Horse(String id, String gameId) {
        super(id);
        appendChange(new HorseCreated(id, gameId)).apply();
    }

    private Horse(String horseId){
        super(horseId);
        subscribe(this);

        listener((HorseCreated event) -> {
            this.distanceTraveled = 0;
            this.gameId = event.getGameId();
        });

        listener((HorseDriverAssigned event) -> {
            this.player = new Player(event.getName(),event.getIdentificationCard());
        });

        listener((KilometersChanged event) -> {
            var advance = Objects.requireNonNull(event.getAdvance(), "La distancia no puede ser null");
            if (advance <= 0) {
                throw new IllegalArgumentException("No puede ser negativo o cero el valor de la distancia");
            }
            this.distanceTraveled = this.getDistance() + advance;
        });
    }

    public static Horse from(String horseId, List<DomainEvent> events){
        var horse = new Horse(horseId);
        events.forEach(horse::applyEvent);
        return horse;
    }

    public void assignHorse(String name, String identificationCard){
        appendChange(new HorseDriverAssigned(name, identificationCard)).apply();
    }

    public void advanceInLane(String laneId){
        var dado = this.throwDice() * 100;
        appendChange(new KilometersChanged(dado, laneId, gameId)).apply();
    }

    public Integer throwDice(){
        var rn = new Random();
        return 1 + rn.nextInt(6);
    }

    public Player getPlayer() {
        return player;
    }

    public Integer getDistance() {
        return distanceTraveled;
    }

    public String getGameId() {
        return gameId;
    }
}
