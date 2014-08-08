package com.lukeherron.expressiontree.node;

import com.lukeherron.expressiontree.visitor.Visitor;

/**
 * Base class for nodes that represent the algebraic addition symbol
 */
public class CompositeAddNode extends CompositeBinaryNode {

    public CompositeAddNode(ComponentNode left, ComponentNode right) {
        super(left, right);
    }

    public double item() {
        return '+';
    }

    public void accept(Visitor visitor) {
        visitor.visit(this);
    }
}
