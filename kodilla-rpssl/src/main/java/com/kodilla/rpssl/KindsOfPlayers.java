package com.kodilla.rpssl;

public enum KindsOfPlayers {
    RANDOMCOMPUTER(0, "Computer with random choose"),
    CHEATINGCOMUPTER(1, "Choose which can cheat a little "),
    HUMANPLAYER(2, "Human player");
    private int option;
    private String optionExplanation;

    KindsOfPlayers(int option, String optionExplanation) {
        this.option = option;
        this.optionExplanation = optionExplanation;
    }

    public int getOption() {
        return option;
    }

    public String getOptionExplanation() {
        return optionExplanation;
    }
}
