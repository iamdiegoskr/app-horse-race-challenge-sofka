package co.com.sofka.horseapp.infrastructure.handle;

import co.com.sofka.horseapp.usecase.StartGameUseCase;
import co.com.sofka.horseapp.domain.game.commands.StartGameCommand;
import co.com.sofka.horseapp.infrastructure.generic.UseCaseHandle;
import io.quarkus.vertx.ConsumeEvent;

import javax.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class StartGameUseCaseHandle extends UseCaseHandle {

    private final StartGameUseCase startGameUseCase;

    public StartGameUseCaseHandle(StartGameUseCase startGameUseCase) {
        this.startGameUseCase = startGameUseCase;
    }

    @ConsumeEvent(value = "sofkau.juego.iniciarjuego")
    void consume(StartGameCommand command){
        System.out.println(command.getGameId());
        var events = startGameUseCase.apply(command);
        saveGame(command.getGameId(), events);
    }
}
