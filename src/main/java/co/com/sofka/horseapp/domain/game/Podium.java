package co.com.sofka.horseapp.domain.game;

import java.util.Objects;

public class Podium {

    private final Player firstPosition;
    private final Player secondPosition;
    private final Player thirdPosition;

    private Podium(Player firstPosition, Player secondPosition, Player thirdPosition){
        this.firstPosition = firstPosition;
        this.secondPosition = secondPosition;
        this.thirdPosition = thirdPosition;
    }

    public Podium(){
        firstPosition = null;
        secondPosition = null;
        thirdPosition = null;
    }

    public Podium assignFirstPosition(Player player){
        return new Podium(player, secondPosition, thirdPosition);
    }

    public Podium assignSecondPosition(Player player){
        return new Podium(firstPosition, player, thirdPosition);
    }

    public Podium assignThirdPosition(Player player){
        return new Podium(firstPosition, secondPosition, player);
    }

    public Player getFirstPosition() {
        return firstPosition;
    }

    public Player getSecondPosition() {
        return secondPosition;
    }

    public Player getThirdPosition() {
        return thirdPosition;
    }

    public Boolean isFull(){
        return Objects.nonNull(firstPosition) && Objects.nonNull(secondPosition) && Objects.nonNull(thirdPosition);
    }

    public Boolean firstPositionAvailable(){
        return Objects.isNull(firstPosition);
    }

    public Boolean secondPositionAvailable(){
        return Objects.isNull(secondPosition);
    }

    public Boolean thirdPositionAvailable(){
        return Objects.isNull(thirdPosition);
    }
}

