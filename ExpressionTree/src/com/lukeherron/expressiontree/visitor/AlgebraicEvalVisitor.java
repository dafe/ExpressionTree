package com.lukeherron.expressiontree.visitor;

import com.lukeherron.expressiontree.node.*;

import java.util.Stack;

/**
 * This plays the role of a visitor for evaluating nodes in an expression tree that is being iterated in post-order
 * fashion (and does not work correctly with any other iterator). This class plays the role of the "ConcreteVisitor" in
 * the Visitor pattern
 */
public class AlgebraicEvalVisitor implements Visitor {

    // Stack containing the integral total of the expression tree that's being visited
    private Stack<Double> stack = new Stack<>();

    public AlgebraicEvalVisitor() {}

    @Override
    public void visit(CompositeAddNode node) {
        if(stack.size() >= 2) {
            stack.push(stack.pop() + stack.pop());
        }
    }

    @Override
    public void visit(CompositeAndNode node) {
        // No-op
    }

    @Override
    public void visit(CompositeDivideNode node) {
        if (stack.size() >= 2 && stack.peek() != null) {
            double rhs = stack.pop();
            stack.push(stack.pop() / rhs);
        }
        else {
            reset();
            throw new ArithmeticException("Division by zero is not allowed");
        }
    }

    @Override
    public void visit(CompositeMultiplyNode node) {
        if (stack.size() >= 2) {
            stack.push(stack.pop() * stack.pop());
        }
    }

    @Override
    public void visit(CompositeNegateNode node) {
        if (stack.size() >= 1) {
            stack.push(-stack.pop());
        }
    }

    @Override
    public void visit(CompositeNotNode node) {
        // No-op
    }

    @Override
    public void visit(CompositeOrNode node) {
        // No-op
    }

    @Override
    public void visit(CompositeSubtractNode node) {
        if (stack.size() >= 2) {
            double rhs = stack.pop();
            stack.push(stack.pop() - rhs);
        }
    }

    @Override
    public void visit(AlgebraicLeafNode node) {
        stack.push(node.item());
    }

    @Override
    public void visit(BooleanLeafNode node) {
        // No-op
    }

    /**
     * Print the total of the evaluation
     * @return int containing the total of the evaluation
     */
    public double result() {
        if (!stack.isEmpty()) {
            return stack.peek();
        }
        else {
            return 0;
        }
    }

    /**
     * Resets the evaluation so it can be reused.
     */
    public void reset() {
        stack.clear();
    }
}
