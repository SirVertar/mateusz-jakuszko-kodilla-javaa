package com.kodilla.rpssl;

public class RpsslMain {
    public static void main(String[] args) {

        WhatIsTypeOfGame whatIsTypeOfGame = new WhatIsTypeOfGame();
        whatIsTypeOfGame.indicateGame();

        WhoArePlayers whoArePlayers = new WhoArePlayers();
        whoArePlayers.indicatePlayers(whatIsTypeOfGame.getGameRule());

        GameController gameController = new GameController(
                whoArePlayers.getPlayer1(),
                whoArePlayers.getPlayer2(),
                whatIsTypeOfGame.getGameRule());

        gameController.startGame();
    }
}
