package co.com.sofka.horseapp.usecase;

import co.com.sofka.horseapp.domain.game.Game;
import co.com.sofka.horseapp.domain.lane.Lane;
import co.com.sofka.horseapp.domain.lane.command.CreateLaneCommand;
import co.com.sofka.horseapp.domain.generic.DomainEvent;
import co.com.sofka.horseapp.domain.generic.EventStoreRepository;

import javax.enterprise.context.Dependent;
import java.util.List;
import java.util.function.Function;

@Dependent
public class CreateLaneUseCase implements Function<CreateLaneCommand, List<DomainEvent>> {

    private final EventStoreRepository repository;

    public CreateLaneUseCase(EventStoreRepository repository) {
        this.repository = repository;
    }

    @Override
    public List<DomainEvent> apply(CreateLaneCommand createLaneCommand) {
        var events = repository.getEventsBy("game", createLaneCommand.getGameId());
        Game game = Game.from(createLaneCommand.getGameId(), events);
        System.out.println(game.getPlayers());

        Lane lane = new Lane(createLaneCommand.getId(), createLaneCommand.getGameId(), 5*1000);
        return lane.getUncommittedChanges();
    }
}
