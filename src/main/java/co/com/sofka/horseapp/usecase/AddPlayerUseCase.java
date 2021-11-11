package co.com.sofka.horseapp.usecase;

import co.com.sofka.horseapp.domain.generic.DomainEvent;
import co.com.sofka.horseapp.domain.generic.EventStoreRepository;
import co.com.sofka.horseapp.domain.game.Game;
import co.com.sofka.horseapp.domain.game.commands.AddPlayerCommand;

import javax.enterprise.context.Dependent;
import java.util.List;
import java.util.function.Function;

@Dependent
public class AddPlayerUseCase implements Function<AddPlayerCommand, List<DomainEvent>> {

    private final EventStoreRepository repository;

    public AddPlayerUseCase(EventStoreRepository repository) {
        this.repository = repository;
    }

    @Override
    public List<DomainEvent> apply(AddPlayerCommand command) {
        Game game = Game.from(command.getGameId(), repository.getEventsBy("game", command.getGameId()));
        game.addPlayer(command.getIdentificationCard(), command.getName());
        return game.getUncommittedChanges();
    }
}
