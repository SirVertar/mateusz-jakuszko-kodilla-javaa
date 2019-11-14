package com.kodilla.rpssl;

public interface GameRule {

    void whoWin(int firstChoose, int secondChoose);

    void setPlayers(Player player1, Player player2);
}
