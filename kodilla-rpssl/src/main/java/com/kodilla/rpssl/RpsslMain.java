package com.kodilla.rpssl;

public class RpsslMain {
    public static void main(String[] args) {

        WhichGame whichGame = new WhichGame();
        whichGame.indicateGame();

        WhoArePlayers whoArePlayers = new WhoArePlayers();
        whoArePlayers.indicatePlayers(whichGame.getGameRule());

        whichGame.getGameRule().setPlayers(whoArePlayers.getPlayer1(), whoArePlayers.getPlayer2());

        GameController gameController = new GameController(whoArePlayers.getPlayer1(), whoArePlayers.getPlayer2());
        gameController.startGame(whichGame.getGameRule());

    }
}
