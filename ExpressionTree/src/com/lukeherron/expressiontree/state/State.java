package com.lukeherron.expressiontree.state;

import com.lukeherron.expressiontree.ExpressionTree;
import com.lukeherron.expressiontree.visitor.AlgebraicEvalVisitor;
import com.lukeherron.expressiontree.visitor.BooleanEvalVisitor;
import com.lukeherron.expressiontree.visitor.Visitor;
import com.lukeherron.expressiontree.visitor.VisitorFactory;

import java.util.Iterator;

/**
 * Implementation of the State pattern that is used to define the various states that affect how users operations are
 * processed.  Plays the role of the "State" base class in the State pattern that is used as the basis for the
 * subclasses that actually define the various states.
 */
public class State {

    private static VisitorFactory visitorFactory = new VisitorFactory();

    /**
     *
     * @param context
     * @param newFormat
     */
    void format(TreeOps context, String newFormat) {
        throw new IllegalStateException("State.format() called in invalid state");
    }

    /**
     *
     * @param context
     * @param expression
     */
    void makeTree(TreeOps context, String expression) {
        throw new IllegalStateException("State.makeTree() called in invalid state");
    }

    /**
     *
     * @param context
     * @param format
     */
    void print(TreeOps context, String format) {
        throw new IllegalStateException("State.print() called in invalid state");
    }

    /**
     *
     * @param context
     * @param format
     */
    void evaluate(TreeOps context, String format) {
        throw new IllegalStateException("State.evaluate() called in invalid state");
    }

    /**
     *
     * @param tree
     * @param traversalOrder
     */
    static void printTree(ExpressionTree tree, String traversalOrder) {
        if (traversalOrder.equals("")) {
            traversalOrder = "in-order";
        }

        Visitor printVisitor = visitorFactory.makeVisitor("print");

        for (Iterator<ExpressionTree> it = tree.makeIterator(traversalOrder); it.hasNext();) {
            it.next().accept(printVisitor);
        }
    }

    /**
     *
     * @param tree
     * @param traversalOrder
     */
    static void evaluateTree(ExpressionTree tree, String traversalOrder) {
        if (traversalOrder.equals("")) {
            traversalOrder = "post-order";
        }
        else if (!traversalOrder.equals("post-order")) {
            throw new IllegalArgumentException(traversalOrder + " evaluation is not supported yet");
        }

        // Let the visitor factory decide on what type of eval visitor to create based upon the root node in the tree
        Visitor evalVisitor = visitorFactory.makeVisitor(tree.type() + "-eval");

        for (Iterator<ExpressionTree> it = tree.makeIterator(traversalOrder); it.hasNext();) {
            it.next().accept(evalVisitor);
        }

        if (tree.type().equals("algebraic")) {
            //System.out.println(((AlgebraicEvalVisitor) evalVisitor).result());
            tree.setTreeEvaluationResult(String.valueOf(((AlgebraicEvalVisitor) evalVisitor).result()));
        }
        else if (tree.type().equals("boolean")) {
            //System.out.println(((BooleanEvalVisitor) evalVisitor).result());
            tree.setTreeEvaluationResult(String.valueOf(((BooleanEvalVisitor) evalVisitor).result()));
        }
    }
}
