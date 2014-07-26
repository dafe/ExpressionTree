package com.lukeherron.expressiontree.symbol;

import com.lukeherron.expressiontree.node.ComponentNode;
import com.lukeherron.expressiontree.node.CompositeNotNode;

/**
 * Defines a node in the parse tree for unary not operator non-terminal expression
 */
public class Not extends UnaryOperator {

    public Not() {
        super(null, logicalNotPrecedence);
    }

    @Override
    public ComponentNode build() {
        return new CompositeNotNode(right.build());
    }
}
