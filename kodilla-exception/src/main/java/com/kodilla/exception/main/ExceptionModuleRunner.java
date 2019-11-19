package com.kodilla.exception.main;

import com.kodilla.exception.io.FileReader;
import com.kodilla.exception.test.FirstChallenge;

public class ExceptionModuleRunner {

    public static void main(String[] args) {

        FirstChallenge firstChallenge = new FirstChallenge();
        firstChallenge.divide(3,0);
    }
}
