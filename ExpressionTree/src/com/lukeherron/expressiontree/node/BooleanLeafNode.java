package com.lukeherron.expressiontree.node;

import com.lukeherron.expressiontree.visitor.Visitor;

/**
 * Extends LeafNode base class to provide boolean leaf nodes i.e. leaf nodes that store boolean true/false values
 */
public class BooleanLeafNode extends LeafNode {

    private String item;

    /**
     * Constructor for LeafNode. Accepts a String which will be parsed to a boolean to be stored in this node
     * @param item The item to be added as the leaf node
     */
    public BooleanLeafNode(String item) {
        this.item = item;
    }

    /**
     * Return the item stored in the node
     * @return boolean contained in this node
     */
    public int item() {
        return Integer.parseInt(this.item);
    }

    public void accept(Visitor visitor) {
        visitor.visit(this);
    }
}
