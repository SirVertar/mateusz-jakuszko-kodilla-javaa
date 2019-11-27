package com.kodilla.rpssl;

public abstract class Player {

    private String name;
    private int score;

    Player(String name) {
        this.name = name;
    }

    abstract String makeRpsMove();

    abstract String makeRpsslMove();

    abstract KindsOfPlayers getKindOfPlayer();

    void addPoint() {
        score++;
    }

    void setName(String name) {
        this.name = name;
    }

    String getName() {
        return name;
    }

    int getScore() {
        return score;
    }


}
