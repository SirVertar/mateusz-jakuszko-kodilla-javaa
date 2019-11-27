package com.kodilla.rpssl;

import static com.kodilla.rpssl.io.InputOutput.OptionsOfRPSLS.PAPER;
import static com.kodilla.rpssl.io.InputOutput.getChoiceFromInt;

public class RpsslMain {
    public static void main(String[] args) {

        TypeOfGameCreator typeOfGameCreator = new TypeOfGameCreator();
        typeOfGameCreator.indicateGame();

        PlayersCreator playersCreator = new PlayersCreator();
        playersCreator.indicatePlayers();

        GameController gameController = new GameController(
                playersCreator.getPlayer1(),
                playersCreator.getPlayer2(),
                typeOfGameCreator.getGameRule());

        gameController.startGame();


    }
}
