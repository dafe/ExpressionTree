package com.lukeherron.expressiontree.iterator;

import com.lukeherron.expressiontree.ExpressionTree;

import java.util.HashMap;
import java.util.Iterator;

/**
 * Implementation of the Factory Method pattern that dynamically allocates the appropriate Iterator strategy requested
 * by a caller. This variant of the pattern doesn't use inheritance, so it plays the role of the ConcreteCreator in the
 * Factory Method pattern.
 */
public class IteratorFactory {

    /**
     * This interface uses the Command pattern to create Iterator implementations at runtime
     */
    public static interface IteratorFactoryCommand {
        public Iterator<ExpressionTree> execute(ExpressionTree tree);
    }

    /* Map used to validate input requests for Iterator implementations and dispatch the execute() method of the
       requested iterator */
    private HashMap<String, IteratorFactoryCommand> traversalMap = new HashMap<>();

    /**
     * The IteratorFactory maps strings to an interface capable of building the appropriate Iterator implementation at
     * runtime
     */
    public IteratorFactory() {
        traversalMap.put("in-order", InOrderIterator::new);
        traversalMap.put("level-order", LevelOrderIterator::new);
        traversalMap.put("post-order", PostOrderIterator::new);
        traversalMap.put("pre-order", PostOrderIterator::new);
    }

    public Iterator<ExpressionTree> makeIterator(ExpressionTree tree, String traversalOrder) {
        // Default to in-order if user doesn't explicitly request a traversal order
        if (traversalOrder.equals("")) {
            traversalOrder = "in-order";
        }

        // Locate the pre-allocated factory command
        IteratorFactoryCommand command = traversalMap.get(traversalOrder);

        if (command != null) {
            return command.execute(tree);
        }

        throw new IllegalArgumentException(traversalOrder + " is not a supported traversal order");
    }
}
