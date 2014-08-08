package com.lukeherron.expressiontree;

import com.lukeherron.expressiontree.command.UserCommandFactory;
import com.lukeherron.expressiontree.state.TreeOps;

public class BooleanEvaluator {

    private TreeOps boolTreeOps;
    private UserCommandFactory commandFactory;

    private String expression;
    private String formatOrder;

    public BooleanEvaluator(String test, String truth) {
        this.boolTreeOps = new TreeOps(new BooleanExpressionTree(null));
        this.commandFactory = new UserCommandFactory(this.boolTreeOps);
        this.expression = test.equals(truth) ? "1" : "0";
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

    public boolean evalInOrder() throws Exception {
        return this.eval("in-order");
    }

    public boolean evalLevelOrder() throws Exception {
        return this.eval("level-order");
    }

    public boolean evalPostOrder() throws Exception {
        return this.eval("post-order");
    }

    public boolean evalPreOrder() throws Exception {
        return this.eval("pre-order");
    }

    public boolean eval() throws Exception {
        // Default implementation uses post order
        return this.evalPostOrder();
    }

    private boolean eval(String evalOrder) throws Exception  {
        commandFactory.makeUserCommand("format " + this.formatOrder).execute();
        commandFactory.makeUserCommand("boolean-expr " + this.expression).execute();
        commandFactory.makeUserCommand("eval " + evalOrder).execute();

        return boolTreeOps.evaluationResult().equals("true");
    }

    public BooleanEvaluator and(String test, String truth) {
        this.expression = this.stringEval("&", test, truth);

        return this;
    }

    public BooleanEvaluator or(String test, String truth) {
        this.expression = this.stringEval("|", test, truth);

        return this;
    }

    public BooleanEvaluator not(String test, String truth) {
        this.expression = this.stringEval("!", test, truth);

        return this;
    }

    public BooleanEvaluator openParens() {
        this.expression = this.expression.concat("(");

        return this;
    }

    public BooleanEvaluator closeParens() {
        this.expression = this.expression.concat(")");

        return this;
    }

    private String stringEval(String operator, String test, String truth) {
        return this.expression.concat(operator.concat(test.equals(truth) ? "1" : "0"));
    }
}
