package co.com.sofka.horseapp.infrastructure.handle;

import co.com.sofka.horseapp.usecase.FinishGameUseCase;
import co.com.sofka.horseapp.domain.game.commands.FinishGameCommand;
import co.com.sofka.horseapp.infrastructure.generic.UseCaseHandle;
import io.quarkus.vertx.ConsumeEvent;

import javax.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class FinishGameUseCaseHandle extends UseCaseHandle {

    private final FinishGameUseCase finishGameUseCase;

    public FinishGameUseCaseHandle(FinishGameUseCase finishGameUseCase) {
        this.finishGameUseCase = finishGameUseCase;
    }

    @ConsumeEvent(value = "sofkau.game.finishgame")
    void consume(FinishGameCommand command){
        System.out.println(command.getGameId());
        var events = finishGameUseCase.apply(command);
        saveGame(command.getGameId(), events);
    }
}
