package com.kodilla.rpssl;

public abstract class Player {

    private String name;
    private int score = 0;
    int playerChoose;
    private GameRule gameRule;


    Player(String name, GameRule gameRule) {
        this.name = name;
        this.gameRule = gameRule;
    }

    public abstract int makeMove();

    public int makeMove(int choice) {
        return 0;
    }

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

    void setScore(int score) {
        this.score = score;
    }

    GameRule getGameRule() {
        return gameRule;
    }

    int getPlayerChoose() {
        return playerChoose;
    }
}
