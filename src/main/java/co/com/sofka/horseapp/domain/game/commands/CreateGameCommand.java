package co.com.sofka.horseapp.domain.game.commands;

import co.com.sofka.horseapp.domain.generic.Command;

public class CreateGameCommand extends Command {

    private String gameId;
    private Integer kilometers;
    private Integer numberOfLanes;

    public CreateGameCommand(String gameId, Integer kilometers, Integer numberOfLanes) {
        this.gameId = gameId;
        this.kilometers = kilometers;
        this.numberOfLanes = numberOfLanes;
    }

    public CreateGameCommand() {
    }

    public Integer getNumberOfLanes() {
        return numberOfLanes;
    }

    public void setNumberOfLanes(Integer numberOfLanes) {
        this.numberOfLanes = numberOfLanes;
    }

    public String getGameId() {
        return gameId;
    }

    public void setGameId(String gameId) {
        this.gameId = gameId;
    }

    public Integer getKilometers() {
        return kilometers;
    }

    public void setKilometers(Integer kilometers) {
        this.kilometers = kilometers;
    }

}
