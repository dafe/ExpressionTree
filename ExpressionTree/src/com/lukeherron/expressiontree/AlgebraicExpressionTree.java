package com.lukeherron.expressiontree;

import com.lukeherron.expressiontree.node.ComponentNode;

public class AlgebraicExpressionTree extends ExpressionTree {

    /**
     * ExpressionTree constructor takes a Node pointer that contains all the nodes in the expression tree
     * @param root The root component node
     */
    public AlgebraicExpressionTree(ComponentNode root) {
        super(root);
    }

    @Override
    public ExpressionTree left() {
        ExpressionTree temp;
        synchronized (this) {
            temp = new AlgebraicExpressionTree(root.left());
        }

        return temp;
    }

    @Override
    public ExpressionTree right() {
        ExpressionTree temp;
        synchronized (this) {
            temp = new AlgebraicExpressionTree(root.right());
        }

        return temp;
    }

    @Override
    public String type() {
        return "algebraic";
    }

    public double item() throws Exception {
        double temp;
        synchronized (this) {
            temp = (double)root.item();
        }

        return temp;
    }
}
