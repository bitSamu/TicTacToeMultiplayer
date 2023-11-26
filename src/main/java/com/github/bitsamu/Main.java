package com.github.bitsamu;

import com.github.bitsamu.ui.TicTacToeGameUi;

import javax.swing.*;

public class Main {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            TicTacToeGameUi game = new TicTacToeGameUi();
            game.setVisible(true);
        });
    }
}