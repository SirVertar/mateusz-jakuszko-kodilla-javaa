package com.kodilla.rpssl;

import static com.kodilla.rpssl.io.InputOutput.*;

class GameController {
    private final Player player1;
    private final Player player2;
    private final GameRule gameRule;

    GameController(Player player1, Player player2, GameRule gameRule) {
        this.player1 = player1;
        this.player2 = player2;
        this.gameRule = gameRule;
    }

    void startGame() {
        boolean exit = false;
        do {
            int result;
            printOption(gameRule);
//            if(player1.getClass() == CheatingComputerPlayer.class) {
//                String player2Choice = getPlayerChoice(player2, gameRule);
//                ((CheatingComputerPlayer) player1).setAnotherPlayerChoice(player2Choice);
//                String player1Choice = getPlayerChoice(player1, gameRule);
//                 result = gameRule.whoWin(player1Choice, player2Choice);
//            } else if (player2 instanceof CheatingComputerPlayer) {
//                String player1Choice = getPlayerChoice(player1, gameRule);
//                ((CheatingComputerPlayer) player2).setAnotherPlayerChoice(player1Choice);
//                String player2Choice = getPlayerChoice(player2, gameRule);
//                result = gameRule.whoWin(player1Choice, player2Choice);
//            } else {
//                String player1Choice = getPlayerChoice(player1, gameRule);
//                String player2Choice = getPlayerChoice(player2, gameRule);
//                result = gameRule.whoWin(player1Choice, player2Choice);
//            }
            String player1Choice = getPlayerChoice(player1, gameRule);
            String player2Choice = getPlayerChoice(player2, gameRule);
            result = gameRule.whoWin(player1Choice, player2Choice);
            if (result == 1) {
                player1.addPoint();
            } else if (result == 2) {
                player2.addPoint();
            }
            printResult(player1.getScore(), player1.getName(), player2.getScore(), player2.getName());
        } while (!exit);
    }

    private String getPlayerChoice(Player player, GameRule gameRule) {
        printPlayerMoveInformation(player.getName());

        if (gameRule.getRULES().length == 3) {
            return player.makeRpsMove();
        } else if (gameRule.getRULES().length == 5) {
            return player.makeRpsslMove();
        }
        return "-1";
    }
}
