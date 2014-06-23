package com.lukeherron.expressiontree.symbol;

import com.lukeherron.expressiontree.node.ComponentNode;
import com.lukeherron.expressiontree.node.CompositeNegateNode;

/**
 * Defines a node in the parse tree for unary not operator non-terminal expression
 */
public class Not extends UnaryOperator {

    public Not() {
        super(null, logicalNotPrecedence);
    }

    @Override
    public ComponentNode build() {
        return new CompositeNegateNode(right.build());
    }
}
