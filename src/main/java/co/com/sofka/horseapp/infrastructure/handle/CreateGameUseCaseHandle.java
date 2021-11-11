package co.com.sofka.horseapp.infrastructure.handle;

import co.com.sofka.horseapp.usecase.CreateGameUseCase;
import co.com.sofka.horseapp.domain.game.commands.CreateGameCommand;
import co.com.sofka.horseapp.infrastructure.generic.UseCaseHandle;
import io.quarkus.vertx.ConsumeEvent;

import javax.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class CreateGameUseCaseHandle extends UseCaseHandle {

    private final CreateGameUseCase createGameUseCase;

    public CreateGameUseCaseHandle(CreateGameUseCase crarJuegoUseCase) {
        this.createGameUseCase = crarJuegoUseCase;
    }

    @ConsumeEvent(value="sofkau.game.creategame")
    void consume(CreateGameCommand command){
        var events = createGameUseCase.apply(command);
        saveGame(command.getGameId(), events);
    }
}
