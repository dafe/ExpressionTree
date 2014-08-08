package com.lukeherron.expressiontree.node;

import com.lukeherron.expressiontree.visitor.Visitor;

/**
 * Extends LeafNode base class to provide algebraic leaf nodes i.e. leaf nodes that store numbers
 */
public class AlgebraicLeafNode extends LeafNode {

    private double item;

    /**
     * Constructor for LeafNode. Accepts an int to be stored in this node
     * @param item The item to be added as the leaf node
     */
    public AlgebraicLeafNode(double item) {
        this.item = item;
    }

    /**
     * Constructor for LeafNode. Accepts a String which will be parsed to an int to be stored in this node
     * @param item The item to be added as the leaf node
     */
    public AlgebraicLeafNode(String item) {
        this.item = Double.parseDouble(item);
    }

    /**
     * Return the item stored in the node
     * @return int contained in this node
     */
    public double item() {
        return this.item;
    }

    @Override
    public void accept(Visitor visitor) {
        visitor.visit(this);
    }
}
