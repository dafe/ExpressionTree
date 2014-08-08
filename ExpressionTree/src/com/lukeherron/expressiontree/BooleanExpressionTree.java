package com.lukeherron.expressiontree;

import com.lukeherron.expressiontree.node.ComponentNode;

public class BooleanExpressionTree extends ExpressionTree {

    /**
     * ExpressionTree constructor takes a Node pointer that contains all the nodes in the expression tree
     * @param root The root component node
     */
    public BooleanExpressionTree(ComponentNode root) {
        super(root);
    }

    @Override
    public ExpressionTree left() {
        ExpressionTree temp;
        synchronized (this) {
            temp = new BooleanExpressionTree(root.left());
        }

        return temp;
    }

    @Override
    public ExpressionTree right() {
        ExpressionTree temp;
        synchronized (this) {
            temp = new BooleanExpressionTree(root.right());
        }

        return temp;
    }

    @Override
    public String type() {
        return "boolean";
    }

    public double item() throws Exception {
        double temp;
        synchronized (this) {
            temp = root.item();
        }
        return temp;
    }
}
