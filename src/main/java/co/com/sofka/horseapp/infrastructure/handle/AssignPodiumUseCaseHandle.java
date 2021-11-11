package co.com.sofka.horseapp.infrastructure.handle;

import co.com.sofka.horseapp.usecase.AssignPodiumUseCase;
import co.com.sofka.horseapp.domain.lane.events.GoalAchieved;
import co.com.sofka.horseapp.infrastructure.generic.UseCaseHandle;
import io.quarkus.vertx.ConsumeEvent;

import javax.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class AssignPodiumUseCaseHandle extends UseCaseHandle {

    private final AssignPodiumUseCase assignPodiumUseCase;

    public AssignPodiumUseCaseHandle(AssignPodiumUseCase assignPodiumUseCase) {
        this.assignPodiumUseCase = assignPodiumUseCase;
    }

    @ConsumeEvent(value="sofkau.lane.goalachieved")
    void consume(GoalAchieved event){
        var events = assignPodiumUseCase.apply(event);
        saveGame(event.getGameId(), events);
    }
}
