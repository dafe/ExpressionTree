package com.lukeherron.expressiontree.symbol;

import com.lukeherron.expressiontree.node.ComponentNode;
import com.lukeherron.expressiontree.node.CompositeMultiplyNode;

/**
 * Defines a node in the parse tree for the binary multiply operator non-terminal expression
 */
public class Multiply extends Operator {

    public Multiply() {
        super(null, null, mulDivPrecedence);
    }

    @Override
    public ComponentNode build() {
        return new CompositeMultiplyNode(left.build(), right.build());
    }
}
