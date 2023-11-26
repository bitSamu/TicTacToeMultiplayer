package com.github.bitsamu.game;

public interface Game {
    boolean checkWinner();
    boolean checkDraw();
    void playMove(int row, int col);
}
