package com.kodilla.rpssl;

import java.util.Random;

public class ComputerPlayer extends Player {

    public ComputerPlayer(String name, GameRule gameRule) {
        super(name, gameRule);
    }

    @Override
    public int makeMove() {
        if (getGameRule() instanceof RpsslGameRule) {
            Random random = new Random();
            playerChoose = random.nextInt(5);
            return playerChoose;
        } else if (getGameRule() instanceof RpsGameRule) {
            Random random = new Random();
            playerChoose = random.nextInt(3);
            return playerChoose;
        } else {
            return 99;
        }
    }
}
