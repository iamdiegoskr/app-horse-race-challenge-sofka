package co.com.sofka.horseapp.infrastructure.handle;

import co.com.sofka.horseapp.infrastructure.generic.UseCaseHandle;
import co.com.sofka.horseapp.domain.lane.command.CreateLaneCommand;
import co.com.sofka.horseapp.usecase.CreateLaneUseCase;
import io.quarkus.vertx.ConsumeEvent;

import javax.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class CreateLaneUseCaseHandle extends UseCaseHandle {

    private final CreateLaneUseCase createLaneUseCase;

    public CreateLaneUseCaseHandle(CreateLaneUseCase createLaneUseCase) {
        this.createLaneUseCase = createLaneUseCase;
    }

    @ConsumeEvent(value="sofkau.lane.createlane")
    void consume(CreateLaneCommand command){
        System.out.println("handle command" + command.getGameId());
        var events = createLaneUseCase.apply(command);
        System.out.println(events.size());
        saveLane(command.getId(), events);
    }

}
