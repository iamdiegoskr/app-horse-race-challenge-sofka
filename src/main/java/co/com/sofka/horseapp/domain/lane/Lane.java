package co.com.sofka.horseapp.domain.lane;

import co.com.sofka.horseapp.domain.lane.events.LaneCreated;
import co.com.sofka.horseapp.domain.generic.DomainEvent;
import co.com.sofka.horseapp.domain.generic.EventChange;
import co.com.sofka.horseapp.domain.generic.AggregateRoot;

import java.util.List;

public class Lane extends AggregateRoot implements EventChange {

    private String carroId;
    private String juegoId;
    private Integer posicionActual;
    private Integer meta;
    private Boolean desplazamientoFinal;

    public Lane(String id, String juegoId, Integer meta) {
        super(id);
        appendChange(new LaneCreated(meta, juegoId)).apply();
    }

    private Lane(String entityId) {
        super(entityId);
        subscribe(this);

        listener((LaneCreated event) -> {
            this.meta = event.getGoal();
            this.juegoId = event.getGameId();
            this.desplazamientoFinal = false;
            this.posicionActual = 0;
        });
    }

    public static Lane from(String entityId, List<DomainEvent> eventList) {
        var carril = new Lane(entityId);
        eventList.forEach(carril::applyEvent);
        return carril;
    }



    public String getCarroId() {
        return carroId;
    }

    public String getJuegoId() {
        return juegoId;
    }

    public Integer getPosicionActual() {
        return posicionActual;
    }

    public Integer getMeta() {
        return meta;
    }

    public Boolean getDesplazamientoFinal() {
        return desplazamientoFinal;
    }
}
