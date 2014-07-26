package com.lukeherron.expressiontree.node;

import com.lukeherron.expressiontree.visitor.Visitor;

/**
 * Base class for nodes that represent the algebraic multiplication symbol
 */
public class CompositeMultiplyNode extends CompositeBinaryNode {

    public CompositeMultiplyNode(ComponentNode left, ComponentNode right) {
        super(left, right);
    }

    public int item() {
        return '*';
    }

    public void accept(Visitor visitor) {
        visitor.visit(this);
    }
}
