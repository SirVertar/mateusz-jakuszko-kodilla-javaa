package com.kodilla.rpssl;

public abstract class GameRule {

    private final static int[][] RULES = {};

    abstract int whoWin(String firstChoose, String secondChoose);

    abstract public int[][] getRULES();

}
