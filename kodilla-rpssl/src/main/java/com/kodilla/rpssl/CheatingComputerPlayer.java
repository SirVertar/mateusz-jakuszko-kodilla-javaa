package com.kodilla.rpssl;

import java.util.Random;

import static com.kodilla.rpssl.io.InputOutput.printSomethingWrong;

public class CheatingComputerPlayer extends Player {

    CheatingComputerPlayer(String name, GameRule gameRule) {
        super(name, gameRule);
    }

    @Override
    public int makeMove(int playerMove) {
        Random random = new Random();
        int temporaryNumber = random.nextInt(100);
        if (getGameRule() instanceof RpsslGameRule) {
            if (temporaryNumber > 30) {
                if (playerMove == 0) return 2;
                else if (playerMove == 1) return 0;
                else if (playerMove == 2) return 1;
                else if (playerMove == 3) return 1;
                else return 0;
            } else {
                return random.nextInt(5);
            }
        } else if (getGameRule() instanceof RpsGameRule) {
            if (temporaryNumber > 30) {
                if (playerMove == 0) return 2;
                else if (playerMove == 1) return 0;
                else return 1;
            } else {
                return random.nextInt(3);
            }
        } else {
            printSomethingWrong();
            return 99;
        }
    }

    @Override
    public int makeMove() {
        return 0;
    }
}

