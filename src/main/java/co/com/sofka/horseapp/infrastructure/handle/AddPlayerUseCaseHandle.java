package co.com.sofka.horseapp.infrastructure.handle;

import co.com.sofka.horseapp.infrastructure.generic.UseCaseHandle;
import co.com.sofka.horseapp.usecase.AddPlayerUseCase;
import co.com.sofka.horseapp.domain.game.commands.AddPlayerCommand;
import io.quarkus.vertx.ConsumeEvent;

import javax.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class AddPlayerUseCaseHandle extends UseCaseHandle {

    private final AddPlayerUseCase addPlayerUseCase;

    public AddPlayerUseCaseHandle(AddPlayerUseCase addPlayerUseCase) {
        this.addPlayerUseCase = addPlayerUseCase;
    }

    @ConsumeEvent(value="sofkau.game.addplayer")
    void consume(AddPlayerCommand command){
        var events = addPlayerUseCase.apply(command);
        saveGame(command.getGameId(), events);
    }
}
