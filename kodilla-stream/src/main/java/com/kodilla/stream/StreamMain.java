package com.kodilla.stream;

import com.kodilla.stream.beautifier.PoemBeautifier;
import com.kodilla.stream.lambda.ExpressionExecutor;
import com.kodilla.stream.reference.FunctionalCalculator;

public class StreamMain {
    public static void main(String[] args) {

        PoemBeautifier poemBeautifier = new PoemBeautifier();

        System.out.println(poemBeautifier.beautify("to LoWer Case Test", String::toLowerCase));
        System.out.println(poemBeautifier.beautify("to upper case test", text -> text.toUpperCase()));
        System.out.println(poemBeautifier.beautify("text cut", text -> text.substring(1,5)));
        System.out.println(poemBeautifier
                .beautify("Replace all a wit b hahaha", text -> text.replace("a","b")));


    }
}