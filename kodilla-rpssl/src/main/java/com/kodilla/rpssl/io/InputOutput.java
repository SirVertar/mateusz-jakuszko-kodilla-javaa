package com.kodilla.rpssl.io;

import com.kodilla.rpssl.GameRule;
import com.kodilla.rpssl.RpsslMain;


import java.util.Arrays;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class InputOutput {

    private static Scanner input = new Scanner(System.in);
    private static List<String> correctRpsslInput = Arrays.asList("0", "1", "2", "3", "4", "x", "r");
    private static List<String> correctRpsInput = Arrays.asList("0", "1", "2", "x", "r");

    static public int getPlayerRpsslMove() {
        boolean isCorrect = false;
        String temporaryInput = null;
        do {
            temporaryInput = input.nextLine();
            if (correctRpsslInput.contains(temporaryInput)) {
                isCorrect = true;
            } else {
                System.out.println("You didn't give correct symbol. Try again...");
                isCorrect = false;
            }

        } while (!isCorrect);

        switch (temporaryInput) {
            case "0":
            case "1":
            case "2":
            case "3":
            case "4":
                return Integer.parseInt(temporaryInput);
            case "x":
                System.exit(0);
            case "r":
                RpsslMain.main(null);
        }
        return -1;
    }

    static public int getPlayerRpsMove() {
        boolean isCorrect = false;
        String temporaryInput = null;
        do {
            temporaryInput = input.nextLine();
            if (correctRpsInput.contains(temporaryInput)) {
                isCorrect = true;
            } else {
                System.out.println("You didn't give correct symbol. Try again...");
                isCorrect = false;
            }

        } while (!isCorrect);

        switch (temporaryInput) {
            case "0":
            case "1":
            case "2":
                return Integer.parseInt(temporaryInput);
            case "x":
                System.exit(0);
            case "r":
                RpsslMain.main(null);
        }
        return -1;
    }


    static public int intInput(int start, int end) {
        boolean error = true;
        int choose = 99;
        do {
            try {
                choose = input.nextInt();
                input.nextLine();
                if (choose > end || choose < start) {
                    System.out.println("You didn't give int from given choices above");
                } else {
                    error = false;
                }
            } catch (InputMismatchException exception) {
                System.out.println("You didn't give an int...Try Again");
            }
        } while (error);
        return choose;
    }

    static public int intInputPlayer() {
        boolean error = true;
        int choose = 99;
        do {
            try {
                choose = input.nextInt();
                input.nextLine();
                if (choose > 2 || choose < 0) {
                    System.out.println("You didn't give integer from given choices above");
                } else {
                    error = false;
                }
            } catch (InputMismatchException exception) {
                System.out.println("You didn't give an int...Try Again");
            }
        } while (error);
        return choose;
    }

    static public String stringInput() {
        Scanner input = new Scanner(System.in);
        return input.nextLine();
    }

    static public void printOption(GameRule gameRule) {
        System.out.println("Choose one of the option below: ");
        if (gameRule.getRULES().length == 3) {
            for (OptionsOfRPS option : OptionsOfRPS.values()) {
                System.out.println(option.getOption() + " - " + option.getOptionExplanation());
            }
        } else if (gameRule.getRULES().length == 5) {
            for (OptionsOfRPSLS option : OptionsOfRPSLS.values()) {
                System.out.println(option.getOption() + " - " + option.getOptionExplanation());
            }
        }
    }

    static public void printKindsOfPlayers() {
        System.out.println("Choose the I player from kinds of players below...");
        for (KindsOfPlayers option : KindsOfPlayers.values()) {
            System.out.println(option.getOption() + " - " + option.getOptionExplanation());
        }
    }

    static public void printKindsOfGames() {
        System.out.println("Choose one of the kinds of games below...");
        for (KindsOfGames option : KindsOfGames.values()) {
            System.out.println(option.getOption() + " - " + option.getOptionExplanation());
        }
    }

    static public void printSecondPlayerRequest() {
        System.out.println("Choose the second kind of player...");
    }

    static public void printPlayerChoose(int choose, String name) {
        if (choose == 0) {
            System.out.println(name + " picks a paper");
        } else if (choose == 1) {
            System.out.println(name + " picks a rock");
        } else if (choose == 2) {
            System.out.println(name + " picks a scissors");
        } else if (choose == 3) {
            System.out.println(name + " picks a lizard");
        } else if (choose == 4) {
            System.out.println(name + " picks a Spock");
        }
    }

    public static void printResult(int gamersReuslult, String firstName, int computerResult, String secondName) {
        if (firstName == null) firstName = "Player I";
        if (secondName == null) secondName = "Player II";
        System.out.println("\n" + "RESULT: " + firstName + " - " + gamersReuslult + "  vs  " + secondName + " - " + computerResult + "\n");
    }

    static public void printGoodbye() {
        System.out.println("Bye, and see You later:)");
    }

    static public void printSomethingWrong() {
        System.out.println("There is sth wrong... probably u gave a wrong number, try again or u've chosen a " +
                "computer vs computer... Try again by run app again");
    }

    static public void printStartNewGame() {
        System.out.println("Ok, so... Let's start a new GAME!! :)");
    }

    static public void printPlayerMoveInformation(String name) {
        System.out.println(name + " move...");
    }


    static public void printChooseTheIPlayerName() {
        System.out.println("Please choose the I player name...");
    }

    static public void printChooseTheIIPlayerName() {
        System.out.println("Please choose the II player name...");
    }


    public enum OptionsOfRPSLS {

        PAPER("0", "Choose paper"), ROCK("1", "Choose rock"),
        SCISSORS("2", "Choose scissors"), LIZARD("3", "Choose Lizard"),
        SPOCK("4", "Choose Spock"), EXIT("X", "Exit game"),
        STARTNEWGAME("r", "Start next game");

        private String option;
        private String optionExplanation;

        OptionsOfRPSLS(String option, String optionExplanation) {
            this.option = option;
            this.optionExplanation = optionExplanation;
        }

        public String getOption() {
            return option;
        }

        public String getOptionExplanation() {
            return optionExplanation;
        }
    }

    public enum OptionsOfRPS {

        PAPER("0", "Choose paper"), ROCK("1", "Choose rock"),
        SCISSORS("2", "Choose scissors"), EXIT("x", "Exit game"),
        STARTNEWGAME("r", "Start next game");

        private String option;
        private String optionExplanation;

        OptionsOfRPS(String option, String optionExplanation) {
            this.option = option;
            this.optionExplanation = optionExplanation;
        }

        public String getOption() {
            return option;
        }

        public String getOptionExplanation() {
            return optionExplanation;
        }

    }

    public enum KindsOfPlayers {
        RANDOMCOMPUTER(0, "Computer with random choose"),
        CHEATINGCOMUPTER(1, "Choose which can cheat a little "),
        PLAYER(2, "Human player");
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

    public enum KindsOfGames {
        PRS(0, "Paper, rock and scissors "),
        PRSLS(1, "Paper, rock, scissors, lizard and spock ");
        private int option;
        private String optionExplanation;

        KindsOfGames(int option, String optionExplanation) {
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
}
