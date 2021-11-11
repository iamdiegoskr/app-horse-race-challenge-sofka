package co.com.sofka.horseapp.domain.game.commands;

import co.com.sofka.horseapp.domain.generic.Command;

public class AddPlayerCommand extends Command {

    private String gameId;
    private String identificationCard;
    private String name;

    public AddPlayerCommand(String gameId, String identificationCard, String name) {
        this.gameId = gameId;
        this.identificationCard = identificationCard;
        this.name = name;
    }

    public AddPlayerCommand() {
    }

    public String getGameId() {
        return gameId;
    }

    public void setGameId(String gameId) {
        this.gameId = gameId;
    }

    public String getIdentificationCard() {
        return identificationCard;
    }

    public void setIdentificationCard(String identificationCard) {
        this.identificationCard = identificationCard;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
