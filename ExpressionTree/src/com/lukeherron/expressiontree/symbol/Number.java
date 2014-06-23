package com.lukeherron.expressiontree.symbol;

import com.lukeherron.expressiontree.node.ComponentNode;
import com.lukeherron.expressiontree.node.AlgebraicLeafNode;

/**
 * Defines a node in the parse tree for number terminal expressions
 */
public class Number extends Symbol {

    public int item;

    public Number(String input) {
        super(null, null, numberPrecedence);
        item = Integer.parseInt(input);
    }

    public Number(int input) {
        super(null, null, numberPrecedence);
        item = input;
    }

    @Override
    public int addPrecedence(int accumulatedPrecedence) {
        return precedence = numberPrecedence + accumulatedPrecedence;
    }

    @Override
    public ComponentNode build() {
        return new AlgebraicLeafNode(item);
    }
}
