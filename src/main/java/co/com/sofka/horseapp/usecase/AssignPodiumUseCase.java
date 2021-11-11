package co.com.sofka.horseapp.usecase;

import co.com.sofka.horseapp.domain.lane.events.GoalAchieved;
import co.com.sofka.horseapp.domain.generic.DomainEvent;
import co.com.sofka.horseapp.domain.generic.EventStoreRepository;
import co.com.sofka.horseapp.domain.game.Game;

import javax.enterprise.context.Dependent;
import java.util.List;
import java.util.function.Function;

@Dependent
public class AssignPodiumUseCase implements Function<GoalAchieved, List<DomainEvent>> {

    private final EventStoreRepository repository;

    public AssignPodiumUseCase(EventStoreRepository repository) {
        this.repository = repository;
    }

    @Override
    public List<DomainEvent> apply(GoalAchieved event) {
        Game game = Game.from(event.getGameId(), repository.getEventsBy("game", event.getGameId()));
        game.setCurrentFinalPosition(game.getCurrentFinalPosition() + 1);
        game.assignPodium(event.getPlayerId(), game.getCurrentFinalPosition());
        return game.getUncommittedChanges();
    }
}
