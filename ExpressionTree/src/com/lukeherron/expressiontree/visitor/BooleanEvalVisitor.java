package com.lukeherron.expressiontree.visitor;

import com.lukeherron.expressiontree.node.*;

import java.util.Stack;

public class BooleanEvalVisitor implements Visitor {

    private Stack<Boolean> stack = new Stack<>();

    public BooleanEvalVisitor() {}

    @Override
    public void visit(CompositeAddNode node) {
        // No-op
    }

    @Override
    public void visit(CompositeAndNode node) {
        if(stack.size() >= 2) {
            Boolean expression1 = stack.pop();
            Boolean expression2 = stack.pop();
            stack.push(expression1 && expression2);
            //stack.push(stack.pop() && stack.pop());
        }
    }

    @Override
    public void visit(CompositeDivideNode node) {
        // No-op
    }

    @Override
    public void visit(CompositeMultiplyNode node) {
        // No-op
    }

    @Override
    public void visit(CompositeNegateNode node) {
        // No-op
    }

    @Override
    public void visit(CompositeNotNode node) {
        if (stack.size() >= 1) {
            Boolean expression = stack.pop();
            stack.push(!expression);
            //stack.push(!stack.pop());
        }
    }

    @Override
    public void visit(CompositeOrNode node) {
        if(stack.size() >= 2) {
            Boolean expression1 = stack.pop();
            Boolean expression2 = stack.pop();
            stack.push(expression1 || expression2);
            //stack.push(stack.pop() || stack.pop());
        }
    }

    @Override
    public void visit(CompositeSubtractNode node) {
        // No-op
    }

    @Override
    public void visit(AlgebraicLeafNode node) {
        // No-op
    }

    @Override
    public void visit(BooleanLeafNode node) {
        stack.push(node.item() == 1);
    }

    /**
     * Print the total of the evaluation
     * @return bool containing the result of the evaluated expression
     */
    public Boolean result() {
        if (!stack.isEmpty()) {
            return stack.peek();
        }
        else {
            return null;
        }
    }

    /**
     * Resets the evaluation so it can be reused.
     */
    public void reset() {
        stack.clear();
    }
}
