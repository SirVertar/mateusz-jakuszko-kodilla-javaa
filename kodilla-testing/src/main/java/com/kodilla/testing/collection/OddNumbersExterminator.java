package com.kodilla.testing.collection;

import java.util.*;

public class OddNumbersExterminator {

    public ArrayList<Integer> exterminate (ArrayList<Integer> arrayList) {

        ArrayList<Integer> arrayWithoutOdds = new ArrayList<Integer>();
        for (Integer number: arrayList) {
            if(number%2 == 0) {
                arrayWithoutOdds.add(number);
            }
        }
        return arrayWithoutOdds;
    }
}
