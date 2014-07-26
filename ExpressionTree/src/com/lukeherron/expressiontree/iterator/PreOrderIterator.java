package com.lukeherron.expressiontree.iterator;

import com.lukeherron.expressiontree.ExpressionTree;

import java.util.Iterator;
import java.util.Stack;

public class PreOrderIterator implements Iterator<ExpressionTree> {

    // Stack of expression trees
    private Stack<ExpressionTree> stack = new Stack<>();

    public PreOrderIterator(ExpressionTree tree) {
        if (!tree.isNull()) {
            stack.push(tree);
        }
    }


    @Override
    public boolean hasNext() {
        return !stack.empty();
    }

    @Override
    public ExpressionTree next() {
        ExpressionTree result = stack.peek();

        if (!stack.isEmpty()) {
            ExpressionTree temp = stack.pop();
            if (!temp.right().isNull()) {
                stack.push(temp.right());
            }
            if (!temp.left().isNull()) {
                stack.push(temp.left());
            }
        }

        return result;
    }

    @Override
    public void remove() {
        stack.pop();
    }
}
