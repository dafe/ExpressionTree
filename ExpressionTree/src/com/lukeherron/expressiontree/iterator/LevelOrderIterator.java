package com.lukeherron.expressiontree.iterator;

import com.lukeherron.expressiontree.ExpressionTree;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;

public class LevelOrderIterator implements Iterator<ExpressionTree> {

    private Queue<ExpressionTree> queue = new LinkedList<>();

    public LevelOrderIterator(ExpressionTree tree) {
        if (!tree.isNull()) {
            queue.add(tree);
        }
    }

    @Override
    public boolean hasNext() {
        return !queue.isEmpty();
    }

    @Override
    public ExpressionTree next() {
        ExpressionTree result = queue.peek();

        if (!queue.isEmpty()) {
            ExpressionTree temp = queue.remove();
            if (!temp.right().isNull()) {
                queue.add(temp.right());
            }
            if (!temp.left().isNull()) {
                queue.add(temp.left());
            }
        }

        return result;
    }

    @Override
    public void remove() {
        queue.remove();
    }
}
