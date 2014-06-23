package com.lukeherron.expressiontree.symbol;

import com.lukeherron.expressiontree.node.ComponentNode;

/**
 * Defines a node in the parse tree for unary operator non-terminal expressions
 */
public abstract class UnaryOperator extends Symbol {

    public UnaryOperator(Symbol right, int precedence) {
        super(null, right, precedence);
    }

    @Override
    public int addPrecedence(int accumulatedPrecedence) {
        return precedence = precedence + accumulatedPrecedence;
    }

    /**
     * Abstract method for building a UnaryOperator node
     *
     * @return ComponentNode representing the UnaryOperator node
     */
    public abstract ComponentNode build();
}
