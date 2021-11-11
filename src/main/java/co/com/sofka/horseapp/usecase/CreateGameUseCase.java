package co.com.sofka.horseapp.usecase;

import co.com.sofka.horseapp.domain.generic.DomainEvent;
import co.com.sofka.horseapp.domain.game.Game;
import co.com.sofka.horseapp.domain.game.commands.CreateGameCommand;

import javax.enterprise.context.Dependent;
import java.util.List;
import java.util.function.Function;

@Dependent
public class CreateGameUseCase implements Function<CreateGameCommand, List<DomainEvent>> {
    @Override
    public List<DomainEvent> apply(CreateGameCommand command) {
        Game game = new Game(command.getGameId(), command.getKilometers(),command.getNumberOfLanes());
        return game.getUncommittedChanges();
    }
}
