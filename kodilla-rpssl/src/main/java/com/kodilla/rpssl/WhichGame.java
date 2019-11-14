package com.kodilla.rpssl;

import static com.kodilla.rpssl.io.InputOutput.*;

class WhichGame {
    private GameRule gameRule;
    private boolean exit = false;

    WhichGame() {
    }

    void indicateGame() {
        printKindsOfGames();
        int choose = intInput(0, 1);
        do {
            switch (choose) {
                case 0:
                    gameRule = new RpsGameRule();
                    exit = true;
                    break;
                case 1:
                    gameRule = new RpsslGameRule();
                    exit = true;
                    break;
                default:
                    printSomethingWrong();
                    break;
            }
        } while (!exit);
    }

    public GameRule getGameRule() {
        return gameRule;
    }
}
