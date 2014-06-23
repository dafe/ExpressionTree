package com.lukeherron.expressiontree.node;

import com.lukeherron.expressiontree.visitor.Visitor;

/**
 * Base class for nodes that represent the boolean logic OR operator
 */
public class CompositeOrNode extends CompositeBinaryNode {

    public CompositeOrNode(ComponentNode left, ComponentNode right) {
        super(left, right);
    }

    public Object item() {
        return '|';
    }

    public void accept(Visitor visitor) {
        visitor.visit(this);
    }
}
