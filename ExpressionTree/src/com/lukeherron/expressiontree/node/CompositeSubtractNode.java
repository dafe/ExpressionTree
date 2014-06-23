package com.lukeherron.expressiontree.node;

import com.lukeherron.expressiontree.visitor.Visitor;

/**
 * Base class for nodes that represent the algebraic subtraction symbol
 */
public class CompositeSubtractNode extends CompositeBinaryNode {

    public CompositeSubtractNode(ComponentNode left, ComponentNode right) {
        super(left, right);
    }

    public Object item() {
        return '-';
    }

    public void accept(Visitor visitor) {
        visitor.visit(this);
    }
}
