package com.lukeherron.expressiontree.symbol;

import com.lukeherron.expressiontree.node.ComponentNode;
import com.lukeherron.expressiontree.node.CompositeSubtractNode;

/**
 * Defines a node in the parse tree for the binary subtract operator non-terminal expression
 */
public class Subtract extends Operator {

    public Subtract() {
        super(null, null, addSubPrecedence);
    }

    @Override
    public ComponentNode build() {
        return new CompositeSubtractNode(left.build(), right.build());
    }
}

