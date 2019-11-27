package com.kodilla.rpssl;

import java.util.Random;

import static com.kodilla.rpssl.KindsOfPlayers.*;

public class CheatingComputerPlayer extends Player {

    private int anotherPlayerChoice;
    private Random random = new Random();
    private KindsOfPlayers kindOfPlayer = CHEATINGCOMUPTER;

    CheatingComputerPlayer(String name) {
        super(name);
    }

    public void setAnotherPlayerChoice(String anotherPlayerChoice) {
        this.anotherPlayerChoice = Integer.parseInt(anotherPlayerChoice);
    }

    @Override
    public String makeRpsslMove() {
        int temporaryNumber = random.nextInt(100);
        if (temporaryNumber > 50) {
            if (anotherPlayerChoice == 0) {
                return "2";
            } else if (anotherPlayerChoice == 1) {
                return "0";
            } else if (anotherPlayerChoice == 2) {
                return "1";
            } else if (anotherPlayerChoice == 3) {
                return "1";
            } else return "0";
        } else {
            return String.valueOf(random.nextInt(5));
        }
    }

    @Override
    public String makeRpsMove() {
        int temporaryNumber = random.nextInt(100);
        if (temporaryNumber > 50) {
            if (anotherPlayerChoice == 0) {
                return "2";
            } else if (anotherPlayerChoice == 1) {
                return "0";
            } else {
                return "1";
            }
        } else {
            return String.valueOf(random.nextInt(3));
        }
    }

    @Override
    KindsOfPlayers getKindOfPlayer() {
        return kindOfPlayer;
    }
}

