package com.kodilla.rpssl;

public abstract class Player {

    private String name;
    private int score = 0;

    Player(String name) {
        this.name = name;
    }

    public abstract String makeRpsMove();

    public abstract String makeRpsslMove();

    void addPoint() {
        score += 1;
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
