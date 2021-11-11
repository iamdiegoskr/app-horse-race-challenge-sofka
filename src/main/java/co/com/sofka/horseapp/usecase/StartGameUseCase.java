package co.com.sofka.horseapp.usecase;


import co.com.sofka.horseapp.domain.generic.DomainEvent;
import co.com.sofka.horseapp.domain.generic.EventStoreRepository;
import co.com.sofka.horseapp.domain.game.Game;
import co.com.sofka.horseapp.domain.game.commands.StartGameCommand;

import javax.enterprise.context.Dependent;
import java.util.List;
import java.util.function.Function;

@Dependent
public class StartGameUseCase implements Function<StartGameCommand, List<DomainEvent>> {

    private final EventStoreRepository repository;

    public StartGameUseCase(EventStoreRepository repository) {
        this.repository = repository;
    }

    @Override
    public List<DomainEvent> apply(StartGameCommand startGameCommand) {
        System.out.println("apply");
        Game game = Game.from(startGameCommand.getGameId(), repository.getEventsBy("game", startGameCommand.getGameId()));
        game.startGame();
        return game.getUncommittedChanges();
    }
}
