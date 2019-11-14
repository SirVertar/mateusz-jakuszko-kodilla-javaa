package com.kodilla.rpssl;

public class RpsGameRule implements GameRule {
    private Player player1;
    private Player player2;

    public RpsGameRule() {
    }

    @Override
    public void setPlayers(Player player1, Player player2) {
        this.player1 = player1;
        this.player2 = player2;
    }

    private final static int[][] RULES = {
            {0, -1, 1},
            {1, 0, -1},
            {-1, 1, 0},
    };

    @Override
    public void whoWin(int firstChoose, int secondChoose) {
        int temporaryResult = RULES[secondChoose][firstChoose];
        if (temporaryResult == 1) {
            player1.addPoint();
        } else if (temporaryResult == -1) {
            player2.addPoint();
        }
    }
}
