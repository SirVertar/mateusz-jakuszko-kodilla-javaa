package com.kodilla.rpssl;


import static com.kodilla.rpssl.io.InputOutput.*;

class TypeOfGameCreator {
    private GameRule gameRule;
    private boolean exit = false;

    TypeOfGameCreator() {
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
                    intInput(0,1);
            }
        } while (!exit);
    }

    public GameRule getGameRule() {
        return gameRule;
    }
}
