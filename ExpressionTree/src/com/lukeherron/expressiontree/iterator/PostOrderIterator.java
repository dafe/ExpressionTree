package com.lukeherron.expressiontree.iterator;

import com.lukeherron.expressiontree.ExpressionTree;

import java.util.Iterator;
import java.util.Stack;

public class PostOrderIterator implements Iterator<ExpressionTree> {

    private Stack<ExpressionTree> stack = new Stack<>();

    public PostOrderIterator(ExpressionTree tree) {
        if (!tree.isNull()) {
            stack.push(tree);
            while (!tree.isNull()) {
                if (!tree.right().isNull()) {
                    stack.push(tree.right());
                }
                if (!tree.left().isNull()) {
                    stack.push(tree.left());
                    tree = tree.left();
                }
                else {
                    tree = tree.right();
                }
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

        if (!stack.isEmpty()) {
            ExpressionTree temp = stack.pop();

            if (!stack.isEmpty() && stack.peek().left().getRoot() != temp.getRoot() && stack.peek().right().getRoot() != temp.getRoot()) {
                temp = stack.peek();

                while (!temp.isNull()) {
                    if (!temp.right().isNull()) {
                        stack.push(temp.right());
                    }
                    if (!temp.left().isNull()) {
                        stack.push(temp.left());
                        temp = temp.left();
                    }
                    else {
                        temp = temp.right();
                    }
                }
            }
        }

        return result;
    }

    @Override
    public void remove() {
        stack.pop();
    }
}
