package com.lukeherron.expressiontree.symbol;

import com.lukeherron.expressiontree.node.ComponentNode;
import com.lukeherron.expressiontree.node.CompositeOrNode;

/**
 * Defines a node in the parse tree for the binary OR operator non-terminal expression
 */
public class Or extends Operator {

    public Or() {
        super(null, null, logicalOrPrecedence);
    }

    @Override
    public ComponentNode build() {
        return new CompositeOrNode(left.build(), right.build());
    }
}
