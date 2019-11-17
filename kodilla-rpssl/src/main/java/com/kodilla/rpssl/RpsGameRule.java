package com.kodilla.rpssl;

public class RpsGameRule extends GameRule {

    private final static int[][] RULES = {
            {0, -1, 1},
            {1, 0, -1},
            {-1, 1, 0},
    };

    @Override
    int whoWin(String firstChoose, String secondChoose) {
        int temporaryResult = RULES[Integer.parseInt(secondChoose)][Integer.parseInt(firstChoose)];
        if (temporaryResult == 1) {
            return 1;
        } else if (temporaryResult == -1) {
            return 2;
        } else {
            return 0;
        }
    }

    @Override
    public int[][] getRULES() {
        return RULES;
    }
}
