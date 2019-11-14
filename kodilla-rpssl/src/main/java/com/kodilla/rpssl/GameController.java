package com.kodilla.rpssl;

import static com.kodilla.rpssl.io.InputOutput.*;


class GameController {
    private Player player1;
    private Player player2;
    private boolean exit = false;
    private int firstPlayerChoice;
    private int secondPlayerChoice;

    GameController(Player player1, Player player2) {
        this.player1 = player1;
        this.player2 = player2;
    }

    void startGame(GameRule gameRule) {
        if (gameRule instanceof RpsslGameRule) {
            do {
                printOption(gameRule);
                playersChoices();
                switch (firstPlayerChoice) {
                    case 0:
                    case 1:
                    case 2:
                    case 3:
                    case 4:
                        RpsslCheckSecondPlayerChoice(secondPlayerChoice, gameRule);
                        break;
                    case 5:
                        printGoodbye();
                        exit = true;
                        break;
                    case 6:
                        printStartNewGame();
                        player1.setScore(0);
                        player2.setScore(0);
                        break;
                }
                printResult(player1.getScore(), player1.getName(), player2.getScore(), player2.getName());
            } while (!exit);

        } else if (gameRule instanceof RpsGameRule) {
            do {
                printOption(gameRule);
                playersChoices();
                switch (firstPlayerChoice) {
                    case 0:
                    case 1:
                    case 2:
                        RpsCheckSecondPlayerChoice(secondPlayerChoice, gameRule);
                        break;
                    case 3:
                        printGoodbye();
                        exit = true;
                        break;
                    case 4:
                        printStartNewGame();
                        player1.setScore(0);
                        player2.setScore(0);
                        break;
                }
                printResult(player1.getScore(), player1.getName(), player2.getScore(), player2.getName());
            } while (!exit);
        }
    }

    private void RpsslCheckSecondPlayerChoice(int choice, GameRule gameRule) {
        if (choice != 5 && choice != 6) {
            gameRule.whoWin(firstPlayerChoice, secondPlayerChoice);
        } else if (choice == 5) {
            exit = true;
        } else {
            printStartNewGame();
            player1.setScore(0);
            player2.setScore(0);
        }
    }

    private void RpsCheckSecondPlayerChoice(int choice, GameRule gameRule) {
        if (choice != 3 && choice != 4) {
            gameRule.whoWin(firstPlayerChoice, secondPlayerChoice);
        } else if (choice == 3) {
            exit = true;
        } else {
            printStartNewGame();
            player1.setScore(0);
            player2.setScore(0);
        }
    }

    private void playersChoices() {
        if (player1 instanceof CheatingComputerPlayer) {
            printPlayerMoveInformation(player2.getName());
            secondPlayerChoice = player2.makeMove();
            printPlayerMoveInformation(player1.getName());
            firstPlayerChoice = player1.makeMove(secondPlayerChoice);
        } else if (player2 instanceof CheatingComputerPlayer) {
            printPlayerMoveInformation(player1.getName());
            firstPlayerChoice = player1.makeMove();
            printPlayerMoveInformation(player2.getName());
            secondPlayerChoice = player2.makeMove(secondPlayerChoice);
        } else {
            printPlayerMoveInformation(player1.getName());
            firstPlayerChoice = player1.makeMove();
            printPlayerMoveInformation(player2.getName());
            secondPlayerChoice = player2.makeMove();
        }
    }
}
