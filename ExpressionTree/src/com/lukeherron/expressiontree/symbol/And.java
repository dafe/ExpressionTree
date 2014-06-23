package com.lukeherron.expressiontree.symbol;

import com.lukeherron.expressiontree.node.ComponentNode;
import com.lukeherron.expressiontree.node.CompositeAndNode;

/**
 * Defines a node in the parse tree for the binary AND operator non-terminal expression
 */
public class And extends Operator {

    public And() {
        super(null, null, logicalAndPrecedence);
    }

    @Override
    public ComponentNode build() {
        return new CompositeAndNode(left.build(), right.build());
    }
}
