package co.com.sofka.horseapp.usecase;

import co.com.sofka.horseapp.domain.generic.DomainEvent;
import co.com.sofka.horseapp.domain.generic.EventStoreRepository;
import co.com.sofka.horseapp.domain.game.Game;
import co.com.sofka.horseapp.domain.game.commands.FinishGameCommand;


import javax.enterprise.context.Dependent;
import java.util.List;
import java.util.function.Function;

@Dependent
public class FinishGameUseCase implements Function<FinishGameCommand, List<DomainEvent>> {

    private final EventStoreRepository repository;

    public FinishGameUseCase(EventStoreRepository repository) {
        this.repository = repository;
    }

    @Override
    public List<DomainEvent> apply(FinishGameCommand finishGameCommand) {
        System.out.println("apply");
        Game game = Game.from(finishGameCommand.getGameId(), repository.getEventsBy("game", finishGameCommand.getGameId()));
        game.finishGame();
        return game.getUncommittedChanges();
    }
}
