package com.kodilla.rpssl;

import java.util.Random;

public class ComputerPlayer extends Player {

    public ComputerPlayer(String name) {
        super(name);
    }

    @Override
    public String makeRpsMove() {
        Random random = new Random();
        return String.valueOf(random.nextInt(3));
    }

    @Override
    public String makeRpsslMove() {
        Random random = new Random();
        return String.valueOf(random.nextInt(5));
    }

}
