package com.lukeherron.expressiontree.node;

import com.lukeherron.expressiontree.visitor.Visitor;

/**
 * Base class for nodes that represent the algebraic division symbol
 */
public class CompositeDivideNode extends CompositeBinaryNode {

    public CompositeDivideNode(ComponentNode left, ComponentNode right) {
        super(left, right);
    }

    public int item() {
        return '/';
    }

    public void accept(Visitor visitor) {
        visitor.visit(this);
    }
}
