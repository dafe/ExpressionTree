package com.lukeherron.expressiontree.node;

/**
 * Defines a left child, to be coupled with a unary nodes right child, and thus is useful for binary operations. It
 * plays the role of a "Composite" in the Composite pattern
 */
public class CompositeBinaryNode extends CompositeUnaryNode {

    private ComponentNode left;

    public CompositeBinaryNode(ComponentNode left, ComponentNode right) {
        super(right);
        this.left = left;
    }

    public ComponentNode left() {
        return this.left;
    }
}
