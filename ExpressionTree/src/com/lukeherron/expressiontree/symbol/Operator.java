package com.lukeherron.expressiontree.symbol;

/**
 * Defines a base class in the parse tree for operator non-terminal expressions
 */
public abstract class Operator extends Symbol {

    public Operator(Symbol left, Symbol right, int precedence) {
        super(left, right, precedence);
    }

    @Override
    public int addPrecedence(int accumulatedPrecedence) {
        return precedence = precedence + accumulatedPrecedence;
    }
}
