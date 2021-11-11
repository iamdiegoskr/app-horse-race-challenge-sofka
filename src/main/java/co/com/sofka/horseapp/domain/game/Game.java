package co.com.sofka.horseapp.domain.game;

import co.com.sofka.horseapp.domain.generic.EventChange;
import co.com.sofka.horseapp.domain.generic.AggregateRoot;
import co.com.sofka.horseapp.domain.generic.DomainEvent;
import co.com.sofka.horseapp.domain.game.events.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Game extends AggregateRoot implements EventChange {

    private Map<String, Player> players;
    private Integer kilometers;
    private Integer numberOfLanes;
    private Integer currentFinalPosition;
    private Boolean isPlaying;
    private Podium podium;

    public Game(String id, Integer kilometers, Integer numberOfLanes) {
        super(id);
        appendChange(new GameCreated(id, kilometers, numberOfLanes)).apply();
        System.out.println(this.getKilometers());
    }

    private Game(String id) {
        super(id);
        subscribe(this);

        listener((GameCreated event) -> {
            this.kilometers = event.getKilometers();
            this.numberOfLanes = event.getNumberOfLanes();
            this.isPlaying = false;
            this.players = new HashMap<>();
            this.podium = new Podium();
        });

        listener((PlayerAssigned event) -> {
            players.put(event.getIdentificationCard(), new Player(event.getName(), event.getIdentificationCard()));
        });

        listener((FirstPositionAssigned event) -> {
            if (this.isPlaying) {
                Player playerGanador = this.players.get(event.getPlayerId());
                this.podium = this.podium.assignFirstPosition(playerGanador);
            } else {
                throw new IllegalArgumentException("No puede asignar al podio no esta en marcha el juego");
            }
        });

        /*listener((SegundoLugarAsignado event) -> {
            if (this.jugando) {
                Jugador jugadorGanador = this.jugadores.get(event.getJugadorId());
                this.podio = this.podio.asignarSegundoLugar(jugadorGanador);
            } else {
                throw new IllegalArgumentException("No puede asignar al podio no esta en marcha el juego");
            }
        });*/

        /*listener((TercerLugarAsignado event) -> {
            if (this.jugando) {
                Jugador jugadorGanador = this.jugadores.get(event.getJugadorId());
                this.podio = this.podio.asignarTercerLugar(jugadorGanador);
            } else {
                throw new IllegalArgumentException("No puede asignar al podio no esta en marcha el juego");
            }
        });*/

        listener((GameStarted event) -> {
            this.isPlaying = true;
        });

        listener((GameFinished event) -> {
            this.isPlaying = false;
        });
    }

    public static Game from(String gameId, List<DomainEvent> events){
        var game = new Game(gameId);
        events.forEach(game::applyEvent);
        System.out.println("evento juego " + game.kilometers);
        return game;
    }

    public void addPlayer(String identificationCard, String name){
        System.out.println("anadir jugador metodo");
        appendChange(new PlayerAssigned(identificationCard, name)).apply();
        System.out.println(this.getKilometers() + " " + this.isPlaying);
    }

    public void setCurrentFinalPosition(Integer currentFinalPosition) {
        this.currentFinalPosition = currentFinalPosition;
    }

    public void startGame() {
        System.out.println("iniciar juego metodo");
        appendChange(new GameStarted()).apply();
    }

    public void finishGame(){
        System.out.println("finalizar juego metodo");
        appendChange(new GameFinished()).apply();
    }

    public void assignPodium(String playerId, Integer position){
        if (position == 1)
            appendChange(new FirstPositionAssigned(playerId)).apply();
        /*if (posicion == 2)
            appendChange(new SegundoLugarAsignado(jugadorId)).apply();
        if (posicion == 3)
            appendChange(new TercerLugarAsignado(jugadorId)).apply();*/
    }

    public Integer getCurrentFinalPosition() {
        return currentFinalPosition;
    }

    public Integer getKilometers() {
        return kilometers;
    }

    public Map<String, Player> getPlayers() {
        return players;
    }
}
