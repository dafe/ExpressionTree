package com.lukeherron.expressiontree.node;

import com.lukeherron.expressiontree.visitor.Visitor;

/**
 * Base class for all terminal nodes in the expression tree
 */
public abstract class LeafNode extends ComponentNode {

    public abstract void accept(Visitor visitor);
}
