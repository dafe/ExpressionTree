package com.lukeherron.expressiontree.state;

/**
 * A state formatted in-order and containing an expression tree
 */
public class InOrderInitialisedState extends InOrderUninitialisedState {

    public InOrderInitialisedState() {}

    /**
     * Print the current expression tree in the context using the designated format
     * @param context TreeOps object which holds the expression tree to print
     * @param format String indicating the format to print the tree in
     */
    void print(TreeOps context, String format) {
        State.printTree(context.tree(), format);
    }

    /**
     * Evaluate the current expression in the context using the designated format
     * @param context TreeOps object which holds the expression tree to evaluate
     * @param format String indicating the format to evaluate the tree in
     */
    void evaluate(TreeOps context, String format) {
        State.evaluateTree(context.tree(), format);
    }
}
