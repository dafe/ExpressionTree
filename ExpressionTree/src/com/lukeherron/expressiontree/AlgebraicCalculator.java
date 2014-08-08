package com.lukeherron.expressiontree;

import com.lukeherron.expressiontree.command.UserCommandFactory;
import com.lukeherron.expressiontree.state.TreeOps;

public class AlgebraicCalculator {

    private TreeOps algebraicTreeOps;
    private UserCommandFactory commandFactory;

    private String expression;
    private String formatOrder;

    public AlgebraicCalculator(String expression) {
        this.algebraicTreeOps = new TreeOps(new AlgebraicExpressionTree(null));
        this.commandFactory = new UserCommandFactory(this.algebraicTreeOps);
        this.expression = expression;
        this.formatOrder = "in-order";
    }

    public void formatInOrder() {
        this.formatOrder = "in-order";
    }

    public void formatPostOrder() {
        this.formatOrder = "post-order";
    }

    public void formatPreOrder() {
        this.formatOrder = "pre-order";
    }

    public void formatLevelOrder() {
        this.formatOrder = "level-order";
    }

    private void setFormatOrder() {

    }

    public boolean eval() {
        return this.evalPostOrder();
    }

    public int evalInOrder() {
        try {
            commandFactory.makeUserCommand("format " + this.formatOrder).execute();
            commandFactory.makeUserCommand("boolean-expr " + this.expression).execute();
            commandFactory.makeUserCommand("eval in-order").execute();
        } catch (Exception e) {
            e.printStackTrace();
        }

        return algebraicTreeOps.evaluationResult()
    }
}
