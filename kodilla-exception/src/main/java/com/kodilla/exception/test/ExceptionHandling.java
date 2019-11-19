package com.kodilla.exception.test;

public class ExceptionHandling {
    public static void main(String[] args) {
        SecondChallenge secondChallenge = new SecondChallenge();

        try {
            secondChallenge.probablyIWillThrowException(4, 4);
        } catch (Exception e) {
            System.out.println("This method have occurred an exception: " + e);
        } finally {
            System.out.println("Finally block of code...");
        }
    }
}
