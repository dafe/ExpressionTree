package com.lukeherron.expressiontree.state;

public class PostOrderInitialisedState extends PostOrderUninitialisedState {

    public PostOrderInitialisedState() {}

    void print(TreeOps context, String format) {
        State.printTree(context.tree(), format);
    }

    void evaluate(TreeOps context, String param) {
        throw new IllegalArgumentException("PostOrderInitialisedState.evaluate() not yet implemented");
    }
}
