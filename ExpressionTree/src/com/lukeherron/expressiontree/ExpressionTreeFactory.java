package com.lukeherron.expressiontree;

import com.lukeherron.expressiontree.node.ComponentNode;
import com.lukeherron.expressiontree.visitor.TypeVisitor;

import java.util.HashMap;

/**
 * This class implements the Factory Method pattern to create ExpressionTree objects. If you want a different type of
 * ExpressionTree you can subclass from this class and override the makeExpressionTree() factory method.
 */
public class ExpressionTreeFactory {

    public static interface ExpressionTreeFactoryCommand {
        public ExpressionTree execute(ComponentNode root);
    }

    private HashMap<String, ExpressionTreeFactoryCommand> factoryMap = new HashMap<>();
    TypeVisitor visitor = new TypeVisitor();

    public ExpressionTreeFactory() {
        factoryMap.put("algebraic", AlgebraicExpressionTree::new);
        factoryMap.put("boolean", BooleanExpressionTree::new);
    }

    /**
     * Create a new ExpressionTree object that encapsulates the componentNodeRoot that's passed as a parameter
     * @param componentNodeRoot ComponentNode which represents the root node from which to construct an ExpressionTree
     * @return ExpressionTree
     */
    public ExpressionTree makeExpressionTree(ComponentNode componentNodeRoot) {
        // Use the ComponentNode to decide what type of tree to make
        componentNodeRoot.accept(this.visitor);
        ExpressionTreeFactoryCommand command = factoryMap.get(this.visitor.getType());

        return command.execute(componentNodeRoot);
    }
}
