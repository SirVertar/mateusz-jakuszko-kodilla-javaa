package com.kodilla.rpssl;

public abstract class GameRule {

    private int numberOfRounds = 0;

    abstract int whoWin(String firstChoose, String secondChoose);

    abstract public int[][] getRules();

    void addNumberOfRounds () {
        numberOfRounds++;
    }

    public int getNumberOfRounds() {
        return numberOfRounds;
    }
}
