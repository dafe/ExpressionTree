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

    public boolean item() throws Exception {
        boolean temp;
        synchronized (this) {
            temp = (boolean)root.item();
        }
        return temp;
    }
}
