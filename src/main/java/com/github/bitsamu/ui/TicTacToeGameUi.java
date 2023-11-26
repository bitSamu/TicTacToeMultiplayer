package com.github.bitsamu.ui;

import com.github.bitsamu.game.Symbol;
import com.github.bitsamu.game.TicTacToeGame;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TicTacToeGameUi extends JFrame {
    private JButton[][] buttons;
    private TicTacToeGame game;
    private final String TITLE = "Tic Tac Toe";

    public TicTacToeGameUi() {
        this.game = new TicTacToeGame();
        setTitle("Tic Tac Toe");
        setSize(300, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setResizable(false);

        buttons = new JButton[3][3];

        initializeButtons();
    }

    private void initializeButtons() {
        setLayout(new GridLayout(3, 3));

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                buttons[i][j] = new JButton(Symbol.EMPTY.toString());
                buttons[i][j].setFont(new Font("Arial", Font.PLAIN, 40));
                buttons[i][j].setFocusPainted(false);
                buttons[i][j].addActionListener(new ButtonClickListener(i, j));
                add(buttons[i][j]);
            }
        }
    }

    private class ButtonClickListener implements ActionListener {
        private int row, col;

        public ButtonClickListener(int row, int col) {
            this.row = row;
            this.col = col;
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            if (buttons[row][col].getText().equals(Symbol.EMPTY.toString())) {
                buttons[row][col].setText(game.getCurrentSymbol().toString());
                game.playMove(row, col);

                if(game.checkWinner()){
                    JOptionPane.showMessageDialog(null, "Player " + game.getCurrentSymbol().toString() + " won.");
                    resetGame();
                }
                else if(game.checkDraw()){
                    JOptionPane.showMessageDialog(null, "Draw!");
                    resetGame();
                }
                else {
                    game.switchPlayer();
                    setTitle("Player " + game.getCurrentSymbol());
                }
            } else {
                JOptionPane.showMessageDialog(null, "Invalid move. Cell already occupied.");
            }
        }
    }

    private void resetGame() {
        game.resetGame();
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                buttons[i][j].setText(Symbol.EMPTY.toString());
            }
        }
    }
}
