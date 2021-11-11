package co.com.sofka.horseapp.domain.game.commands;

import co.com.sofka.horseapp.domain.generic.Command;


public class StartGameCommand extends Command {

    private String gameId;

    public StartGameCommand(String gameId) {
        this.gameId = gameId;
    }

    public StartGameCommand() {
    }

    public String getGameId() {
        return gameId;
    }

    public void setGameId(String gameId) {
        this.gameId = gameId;
    }

}
