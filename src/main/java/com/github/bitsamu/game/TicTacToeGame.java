package com.github.bitsamu.game;

public class TicTacToeGame implements Game{
    private final int GRID_SIZE = 3;
    private Symbol[][] board;

    private Symbol currentSymbol = Symbol.CROSS;

    public TicTacToeGame() {
        this.board = new Symbol[GRID_SIZE][GRID_SIZE];
        initBoard();
    }

    private void initBoard(){
        for(int row = 0; row < GRID_SIZE; row++){
            for(int col = 0; col < GRID_SIZE; col++){
                this.board[row][col] = Symbol.EMPTY;
            }
        }
    }

    @Override
    public boolean checkWinner() {
        return checkRows() || checkColumns() || checkDiagonals();
    }

    private boolean checkRows(){
        for(int row = 0; row < GRID_SIZE; row++){
            if((board[row][0] == Symbol.CROSS && board[row][1] == Symbol.CROSS && board[row][2] == Symbol.CROSS) ||
                    (board[row][0] == Symbol.NOUGHT && board[row][1] == Symbol.NOUGHT && board[row][2] == Symbol.NOUGHT)){
                return true;
            }
        }
        return false;
    }
    private boolean checkColumns(){
        for(int col = 0; col < GRID_SIZE; col++){
            if((board[0][col] == Symbol.CROSS && board[1][col] == Symbol.CROSS && board[2][col] == Symbol.CROSS) ||
                    (board[0][col] == Symbol.NOUGHT && board[1][col] == Symbol.NOUGHT && board[2][col] == Symbol.NOUGHT)){
                return true;
            }
        }
        return false;
    }
    private boolean checkDiagonals() {
        return (checkDiagonal(Symbol.CROSS) || checkDiagonal(Symbol.NOUGHT));
    }

    private boolean checkDiagonal(Symbol symbol) {
        return (board[0][0] == symbol && board[1][1] == symbol && board[2][2] == symbol) ||
                (board[0][2] == symbol && board[1][1] == symbol && board[2][0] == symbol);
    }

    @Override
    public boolean checkDraw() {
        for(int row = 0; row < GRID_SIZE; row++){
            for(int col = 0; col < GRID_SIZE; col++){
                if(board[row][col].equals(Symbol.EMPTY)){
                    return false;
                }
            }
        }
        return true;
    }

    @Override
    public void playMove(int row, int col) {
        if(isValidMove(row, col)){
            this.board[row][col] = currentSymbol;
        }
    }

    private boolean isValidMove(int row, int col){
        if(row >= 0 && row < GRID_SIZE || col >= 0 && col < GRID_SIZE){
            return this.board[row][col].equals(Symbol.EMPTY);
        }
        else {
            return false;
        }
    }

    public void switchPlayer(){
        currentSymbol = currentSymbol.equals(Symbol.CROSS) ? Symbol.NOUGHT : Symbol.CROSS;
    }

    public void resetGame(){
        initBoard();
    }

    public int getGRID_SIZE() {
        return GRID_SIZE;
    }

    public Symbol[][] getBoard() {
        return board;
    }

    public Symbol getCurrentSymbol() {
        return currentSymbol;
    }
}
