package com.lukeherron.expressiontree.node;

import com.lukeherron.expressiontree.visitor.Visitor;

/**
 * Base class for nodes that represent the algebraic negate symbol. Useful for representing negative numbers
 */
public class CompositeNegateNode extends CompositeUnaryNode {

    public CompositeNegateNode(ComponentNode right) {
        super(right);
    }

    public int item() {
        return '-';
    }

    public void accept(Visitor visitor) {
        visitor.visit(this);
    }
}
