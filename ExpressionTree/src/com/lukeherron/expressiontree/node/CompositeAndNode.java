package com.lukeherron.expressiontree.node;

import com.lukeherron.expressiontree.visitor.Visitor;

/**
 * Base class for nodes that represent the boolean logic AND operator
 */
public class CompositeAndNode extends CompositeBinaryNode {

    public CompositeAndNode(ComponentNode left, ComponentNode right) {
        super(left, right);
    }

    public double item() {
        return '&';
    }

    public void accept(Visitor visitor) {
        visitor.visit(this);
    }
}
