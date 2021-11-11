package co.com.sofka.horseapp.domain.game;

public class Player {

    private final String name;
    private final String identificationCard;

    public Player(String name, String identificationCard) {
        this.name = name;
        this.identificationCard = identificationCard;
    }

    public String name() {
        return name;
    }

    public String identificationCard() {
        return identificationCard;
    }
}
