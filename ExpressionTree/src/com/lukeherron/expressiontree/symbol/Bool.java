package com.lukeherron.expressiontree.symbol;

import com.lukeherron.expressiontree.node.ComponentNode;
import com.lukeherron.expressiontree.node.BooleanLeafNode;

/**
 * Defines a node in the parse tree for boolean terminal expressions
 */
public class Bool extends Symbol {

    public Boolean item;

    public Bool(String input) {
        super(null, null, boolPrecedence);
        item = Boolean.parseBoolean(input);
    }

    public Bool(Boolean input) {
        super(null, null, boolPrecedence);
        item = input;
    }

    @Override
    public int addPrecedence(int accumulatedPrecedence) {
        return precedence = boolPrecedence + accumulatedPrecedence;
    }

    @Override
    public ComponentNode build() {
        return new BooleanLeafNode(item);
    }
}
