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

    public double evalInOrder() throws Exception {
        return this.eval("in-order");
    }

    public double evalLevelOrder() throws Exception {
        return this.eval("level-order");
    }

    public double evalPostOrder() throws Exception {
        return this.eval("post-order");
    }

    public double evalPreOrder() throws Exception {
        return this.eval("pre-order");
    }

    public double eval() throws Exception {
        // Default implementation uses post order
        return this.evalPostOrder();
    }

    private double eval(String evalOrder) throws Exception  {
        commandFactory.makeUserCommand("format " + this.formatOrder).execute();
        commandFactory.makeUserCommand("algebraic-expr " + this.expression).execute();
        commandFactory.makeUserCommand("eval " + evalOrder).execute();

        return Double.parseDouble(algebraicTreeOps.evaluationResult());
    }

    public AlgebraicCalculator add(int number) {
        this.expression = this.stringEval("+", number);

        return this;
    }

    public AlgebraicCalculator subtract(int number) {
        this.expression = this.stringEval("-", number);

        return this;
    }

    public AlgebraicCalculator multiply() {
        this.expression = this.expression.concat("*");

        return this;
    }

    public AlgebraicCalculator multiply(int number) {
        this.expression = this.stringEval("*", number);

        return this;
    }

    public AlgebraicCalculator divide(int number) {
        this.expression = this.stringEval("/", number);

        return this;
    }

    public AlgebraicCalculator openParens(int number) {
        this.expression = this.stringEval("(", number);

        return this;
    }

    public AlgebraicCalculator closeParens() {
        this.expression = this.expression.concat(")");

        return this;
    }

    private String stringEval(String operator, int number) {
        return this.expression.concat(operator).concat(String.valueOf(number));
    }
}
