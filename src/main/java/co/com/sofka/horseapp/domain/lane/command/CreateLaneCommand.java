package co.com.sofka.horseapp.domain.lane.command;

import co.com.sofka.horseapp.domain.generic.Command;

public class CreateLaneCommand extends Command {

    private String id;
    private String gameId;

    public CreateLaneCommand() {
    }

    public CreateLaneCommand(String id, String gameId) {
        this.id = id;
        this.gameId = gameId;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getGameId() {
        return gameId;
    }

    public void setGameId(String gameId) {
        this.gameId = gameId;
    }

}
