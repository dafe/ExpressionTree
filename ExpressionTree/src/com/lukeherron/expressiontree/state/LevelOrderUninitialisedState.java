package com.lukeherron.expressiontree.state;

public class LevelOrderUninitialisedState extends UninitialisedState {

    public LevelOrderUninitialisedState() {}

    /**
     * A state formatted level-order without an expression tree
     * @param context TreeOps object which represents the context in the state pattern
     * @param expression String containing the expression to create our ExpressionTree from
     */
    void makeTree(TreeOps context, String expression) {
        throw new IllegalStateException("LevelOrderUninitialisedState.makeTree() not yet implemented");
    }


}
