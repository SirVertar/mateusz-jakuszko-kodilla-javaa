package com.kodilla.rpssl;

import java.util.Random;

import static com.kodilla.rpssl.KindsOfPlayers.*;

public class ComputerPlayer extends Player {

    private Random random = new Random();
    private KindsOfPlayers kindOfPlayer = RANDOMCOMPUTER;

    public ComputerPlayer(String name) {
        super(name);
    }

    @Override
    public String makeRpsMove() {
        return String.valueOf(random.nextInt(3));
    }

    @Override
    public String makeRpsslMove() {
        return String.valueOf(random.nextInt(5));
    }

    @Override
    KindsOfPlayers getKindOfPlayer() {
        return kindOfPlayer;
    }
}
