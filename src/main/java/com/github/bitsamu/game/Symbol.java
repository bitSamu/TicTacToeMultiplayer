package com.github.bitsamu.game;

public enum Symbol {
    NOUGHT("O"),
    CROSS("X"),
    EMPTY(""),
    ;

    private String symbol;

    Symbol(String symbol) {
        this.symbol = symbol;
    }

    @Override
    public String toString() {
        return symbol;
    }
}
