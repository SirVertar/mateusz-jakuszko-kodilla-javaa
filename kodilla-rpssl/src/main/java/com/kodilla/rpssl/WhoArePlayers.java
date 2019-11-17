package com.kodilla.rpssl;


import static com.kodilla.rpssl.io.InputOutput.*;

class WhoArePlayers {
    private Player player1;
    private Player player2;

    void indicatePlayers(GameRule gameRule) {
        printKindsOfPlayers();
        int firstChoice = intInputPlayer();
        printSecondPlayerRequest();
        int secondChoice = intInputPlayer();

        switch (firstChoice) {
            case 0:
                player1 = new ComputerPlayer("Computer");
                break;
            case 1:
                player1 = new CheatingComputerPlayer("Cheating computer");
                break;
            case 2:
                player1 = new HumanPlayer("Player");
                printChooseTheIPlayerName();
                String firstPlayerName = stringInput();
                player1.setName(firstPlayerName);
                break;
            default:
                printSomethingWrong();
                break;
        }

        switch (secondChoice) {
            case 0:
                player2 = new ComputerPlayer("Computer");
                break;
            case 1:
                player2 = new CheatingComputerPlayer("Cheating computer");
                break;
            case 2:
                player2 = new HumanPlayer("Player");
                printChooseTheIIPlayerName();
                String firstPlayerName = stringInput();
                player2.setName(firstPlayerName);
                break;
            default:
                printSomethingWrong();
                break;
        }
    }


    Player getPlayer1() {
        return player1;
    }

    Player getPlayer2() {
        return player2;
    }
}
