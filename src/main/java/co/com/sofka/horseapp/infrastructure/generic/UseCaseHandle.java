package co.com.sofka.horseapp.infrastructure.generic;

import co.com.sofka.horseapp.domain.generic.StoredEvent;
import co.com.sofka.horseapp.domain.generic.DomainEvent;
import co.com.sofka.horseapp.domain.generic.EventStoreRepository;
import co.com.sofka.horseapp.infrastructure.service.MessageService;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import java.util.Date;
import java.util.List;

@ApplicationScoped
public abstract class UseCaseHandle {

    @Inject
    private EventStoreRepository repository;

    @Inject
    private MessageService messageService;

    public void saveGame(String gameId, List<DomainEvent> events) {
        System.out.println("saveJuego");
        events.stream().map(event -> {
            String eventBody = EventSerializer.instance().serialize(event);
            return new StoredEvent(event.getClass().getTypeName(), new Date(), eventBody);
        }).forEach(storedEvent -> repository.saveEvent("game", gameId, storedEvent));
        events.forEach(messageService::send);
    }

    public void saveLane(String id, List<DomainEvent> events) {
        System.out.println("saveCarril");
        events.stream().map(event -> {
            String eventBody = EventSerializer.instance().serialize(event);
            return new StoredEvent(event.getClass().getTypeName(), new Date(), eventBody);
        }).forEach(storedEvent -> repository.saveEvent("lane", id, storedEvent));
        events.forEach(messageService::send);
    }
}
