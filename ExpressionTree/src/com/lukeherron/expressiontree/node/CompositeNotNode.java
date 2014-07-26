package com.lukeherron.expressiontree.node;

import com.lukeherron.expressiontree.visitor.Visitor;

/**
 * Base class for nodes that represent the boolean logic NOT operator
 */
public class CompositeNotNode extends CompositeUnaryNode {

    public CompositeNotNode(ComponentNode right) {
        super(right);
    }

    public int item() {
        return '!';
    }

    public void accept(Visitor visitor) {
        visitor.visit(this);
    }
}
