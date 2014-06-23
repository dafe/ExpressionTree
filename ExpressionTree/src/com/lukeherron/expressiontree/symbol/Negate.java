package com.lukeherron.expressiontree.symbol;

import com.lukeherron.expressiontree.node.ComponentNode;
import com.lukeherron.expressiontree.node.CompositeNegateNode;

/**
 * Defines a node in the parse tree for unary minus operator non-terminal expression
 */
public class Negate extends UnaryOperator {

    public Negate() {
        super(null, negatePrecedence);
    }

    @Override
    public ComponentNode build() {
        return new CompositeNegateNode(right.build());
    }
}
