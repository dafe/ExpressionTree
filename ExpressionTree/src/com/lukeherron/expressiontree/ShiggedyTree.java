package com.lukeherron.expressiontree;

import com.lukeherron.expressiontree.command.UserCommandFactory;
import com.lukeherron.expressiontree.state.TreeOps;

public class ShiggedyTree {

    private BooleanEvaluator boolEval;

    public BooleanEvaluator booleanTest(String test, String truth) {
        return new BooleanEvaluator(test, truth);
    }

    public static class BooleanTest {

        private TreeOps boolTreeOps;
        private UserCommandFactory commandFactory;

        private String expression;
        private String formatOrder;

        public BooleanTest(String test, String truth) {
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

        private void setFormatOrder() {

        }

        public boolean eval() {
            return this.evalPostOrder();
        }

        public boolean evalInOrder() {
            try {
                commandFactory.makeUserCommand("format " + this.formatOrder).execute();
                commandFactory.makeUserCommand("boolean-expr " + this.expression).execute();
                commandFactory.makeUserCommand("eval in-order").execute();
            } catch (Exception e) {
                e.printStackTrace();
            }

            return boolTreeOps.evaluationResult().equals("true");
        }

        public boolean evalPostOrder() {
            try {
                commandFactory.makeUserCommand("format " + this.formatOrder).execute();
                commandFactory.makeUserCommand("boolean-expr " + this.expression).execute();
                commandFactory.makeUserCommand("eval post-order").execute();
            } catch (Exception e) {
                e.printStackTrace();
            }

            return boolTreeOps.evaluationResult().equals("true");
        }

        public boolean evalPreOrder() {
            return false;
        }

        public boolean evalLevelOrder() {
            return false;
        }

        public BooleanTest and(String test, String truth) {
            return this;
        }

        public BooleanTest or(String test, String truth) {
            return this;
        }

        public BooleanTest not(String test, String truth) {
            return this;
        }
    }
}
