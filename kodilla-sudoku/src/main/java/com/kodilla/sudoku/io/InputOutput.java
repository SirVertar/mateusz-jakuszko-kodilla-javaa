package com.kodilla.sudoku.io;

import com.kodilla.sudoku.SelectionMenu;

import java.util.InputMismatchException;
import java.util.Scanner;

public class InputOutput {
    public static Scanner scanner = new Scanner(System.in);

    static public void printOption() {
        System.out.println("\nChoose on of the option below :\n");
        for (SelectionMenu option : SelectionMenu.values()) {
            System.out.println(option.getOption() + " - " + option.getOptionExplanation());
        }
    }

    static public int intInput(int start, int end) {
        boolean error = true;
        int choose = -1;
        do {
            try {
                choose = scanner.nextInt();
                if (choose > end || choose < start) {
                    System.out.println("You didn't give right int -> [ " + start + "-" + end + " ] :). Try again");
                } else {
                    error = false;
                }
            } catch (InputMismatchException exception) {
                scanner.nextLine();
                System.out.println("You didn't give right int -> [ " + start + "-" + end + " ] :). Try again");
            }
        } while (error);
        return choose;
    }

    static public int[] setElementField() {
        System.out.println("Which row?");
        int row = intInput(1, 9);
        System.out.println("Which column?");
        int column = intInput(1, 9);
        System.out.println("Which number for element?");
        int elementField = intInput(1, 9);
        return new int[]{row, column, elementField};
    }

}
