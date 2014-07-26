package com.lukeherron.expressiontree.iterator;

import com.lukeherron.expressiontree.ExpressionTree;

import java.util.Iterator;
import java.util.Stack;

/**
 * Iterates an expression tree in the standard in-order
 */
public class InOrderIterator implements Iterator<ExpressionTree> {

    private Stack<ExpressionTree> stack = new Stack<>();

    public InOrderIterator(ExpressionTree tree) {
        if (!tree.isNull()) {
            stack.push(tree);

            while (!stack.peek().left().isNull()) {
                stack.push(stack.peek().left());
            }
        }
    }

    @Override
    public boolean hasNext() {
        return !stack.empty();
    }

    @Override
    public ExpressionTree next() {
        ExpressionTree result = stack.peek();

        // If we have nodes greater than ourselves
        if (!stack.empty()) {
            // Push the right child node onto the stack and pop the older parent (it's been visited now)
            if (!stack.peek().right().isNull()) {
                stack.push(stack.pop().right());

                // Keep pushing until we get to the left most child
                while (!stack.peek().left().isNull()) {
                    stack.push(stack.peek().left());
                }
            }
            else {
                stack.pop();
            }
        }

        return result;
    }

    @Override
    public void remove() {
        stack.pop();
    }
}
