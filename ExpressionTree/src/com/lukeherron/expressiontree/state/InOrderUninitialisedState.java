package com.lukeherron.expressiontree.state;


public class InOrderUninitialisedState extends UninitialisedState {

    public InOrderUninitialisedState() {
        super();
    }

    /**
     * Process the expression using an in-order interpreter and update the state of treeOps to the
     * InOrderInitialisedState
     * @param treeOps TreeOps object which represents the context in the state pattern
     * @param inputExpression String containing the expression to create our ExpressionTree from
     */
    void makeTree(TreeOps treeOps, String inputExpression) {
        treeOps.tree(treeOps.interpreter().interpret(inputExpression, treeOps.tree().type()));
        treeOps.state(new InOrderInitialisedState());
    }
}
