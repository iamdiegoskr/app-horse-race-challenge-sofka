package co.com.sofka.horseapp.infrastructure.entrypoints;


import co.com.sofka.horseapp.domain.lane.command.CreateLaneCommand;
import co.com.sofka.horseapp.domain.lane.events.GoalAchieved;
import co.com.sofka.horseapp.domain.game.commands.AddPlayerCommand;
import co.com.sofka.horseapp.domain.game.commands.CreateGameCommand;
import co.com.sofka.horseapp.domain.game.commands.FinishGameCommand;
import co.com.sofka.horseapp.domain.game.commands.StartGameCommand;
import co.com.sofka.horseapp.infrastructure.service.MessageService;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("/api")
public class CommandController {

    private final MessageService messageService;

    public CommandController(MessageService messageService){
        this.messageService = messageService;
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Path("/createGame")
    public Response executor(CreateGameCommand command) {
        System.out.println("controller");
        messageService.send(command);
        return Response.ok().build();
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Path("/addPlayer")
    public Response executor(AddPlayerCommand command) {
        System.out.println("controller");
        messageService.send(command);
        return Response.ok().build();
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Path("/startGame")
    public Response executor(StartGameCommand command) {
        System.out.println("controller " + command.getGameId());
        messageService.send(command);
        return Response.ok().build();
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Path("/finishGame")
    public Response executor(FinishGameCommand command) {
        System.out.println("controller " + command.getGameId());
        messageService.send(command);
        return Response.ok().build();
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Path("/createLane")
    public Response executor(CreateLaneCommand command) {
        System.out.println("controller " + command.getGameId());
        messageService.send(command);
        return Response.ok().build();
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Path("/testevent")
    public Response executor(GoalAchieved event) {
        System.out.println("controller " + event.getGameId());
        messageService.send(event);
        return Response.ok().build();
    }

}
