package com.lukeherron.expressiontree.node;

import com.lukeherron.expressiontree.visitor.Visitable;
import com.lukeherron.expressiontree.visitor.Visitor;

/**
 * Base class that represents all nodes found in an expression tree. This class represents the 'Component' class in the
 * Composite pattern
 */
public abstract class ComponentNode implements Visitable {

    /**
     * Retrieves the node found on the left of a binary node. No-op as default implementation
     * @return ComponentNode
     */
    public ComponentNode left() {
        return null;
    }

    /**
     * Retrieves the node found on the right of a binary node. No-op as default implementation
     * @return ComponentNode
     */
    public ComponentNode right() {
        return null;
    }

    /**
     * Returns the value stored in the node. No-op in the base class
     * @return object representing the symbol held by the node
     */
    public Object item() {
        throw new UnsupportedOperationException("ComponentNode::item() called improperly");
    }

    public void accept(Visitor visitor) {
        throw new UnsupportedOperationException("ComponentNode::accept() called improperly");
    }
}
