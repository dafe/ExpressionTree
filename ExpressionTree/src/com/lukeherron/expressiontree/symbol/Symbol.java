package com.lukeherron.expressiontree.symbol;

import com.lukeherron.expressiontree.node.ComponentNode;

/**
 * Base class for the various parse tree subclasses that parse an algebraic expression tree
 */
public abstract class Symbol {

    protected int precedence = 0;

    // Define the precedence for algebraic symbols. Higher number equals higher precedence
    final static int addSubPrecedence = 1;
    final static int mulDivPrecedence = 2;
    final static int negatePrecedence = 3;
    final static int numberPrecedence = 4;

    // Define the precedence for boolean symbols. Higher number equals higher precedence
    final static int logicalOrPrecedence = 1;
    final static int logicalAndPrecedence = 2;
    final static int logicalNotPrecedence = 3;
    final static int boolPrecedence = 4;

    // Ensure parens always have highest precedence
    public final static int parenPrecedence = 5;

    public Symbol left;
    public Symbol right;

    public Symbol(Symbol left, Symbol right, int precedence) {
        this.precedence = precedence;
        this.left = left;
        this.right = right;
    }

    /**
     * Method for returning precedence level (higher value means higher precedence)
     * @return int indicating the precedence level of the Symbol object
     */
    public int precedence() {
        return precedence;
    }

    /**
     * Abstract method for adding precedence
     * @param accumulatedPrecedence the current accumulated precedence value
     * @return int representing the new precedence value
     */
    public abstract int addPrecedence(int accumulatedPrecedence);

    /**
     * Abstract method for building a ComponentNode
     * @return ComponentNode
     */
    public abstract ComponentNode build();

    public Symbol left() {
        return this.left;
    }

    public Symbol right() {
        return this.right;
    }
}
