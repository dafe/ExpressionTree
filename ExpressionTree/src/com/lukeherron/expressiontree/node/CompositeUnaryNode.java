package com.lukeherron.expressiontree.node;

/**
 * Defines a right child (but not a left one) and thus is useful for unary operations. It plays the role of a
 * "Composite" in the Composite pattern
 */
public class CompositeUnaryNode extends ComponentNode {

    private ComponentNode right;

    public CompositeUnaryNode(ComponentNode right) {
        this.right = right;
    }

    public ComponentNode right() {
        return this.right;
    }
}
