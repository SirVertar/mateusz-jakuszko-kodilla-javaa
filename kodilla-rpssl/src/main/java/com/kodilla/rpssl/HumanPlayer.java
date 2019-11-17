package com.kodilla.rpssl;

import static com.kodilla.rpssl.io.InputOutput.*;

public class HumanPlayer extends Player {

    HumanPlayer(String name) {
        super(name);
    }

    @Override
    public String makeRpsslMove() {
        return String.valueOf(getPlayerRpsslMove());
    }

    @Override
    public String makeRpsMove() {
        return String.valueOf(getPlayerRpsMove());
    }
}
