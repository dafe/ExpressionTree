package com.lukeherron.expressiontree.symbol;

import com.lukeherron.expressiontree.node.ComponentNode;
import com.lukeherron.expressiontree.node.CompositeDivideNode;

/**
 * Defines a node in the parse tree for the binary divide operator non-terminal expression
 */
public class Divide extends Operator {

    public Divide() {
        super(null, null, mulDivPrecedence);
    }

    @Override
    public ComponentNode build() {
        return new CompositeDivideNode(left.build(), right.build());
    }
}
