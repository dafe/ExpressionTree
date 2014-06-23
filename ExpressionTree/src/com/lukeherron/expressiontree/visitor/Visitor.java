package com.lukeherron.expressiontree.visitor;

import com.lukeherron.expressiontree.node.*;
import com.lukeherron.expressiontree.node.CompositeAndNode;
import com.lukeherron.expressiontree.node.CompositeNotNode;
import com.lukeherron.expressiontree.node.CompositeOrNode;

/**
 * Base interface for all visitors to all classes that derive from ComponentNode. This class plays the role of the
 * "Visitor" in the Visitor pattern
 */
public interface Visitor {

    /**
     * Visit a CompositeAddNode.
     * @param node The CompositeAddNode to be visited
     */
    void visit(CompositeAddNode node);

    /**
     * Visit a CompositeAndNode
     * @param node The CompositeAndNode to be visited
     */
    void visit(CompositeAndNode node);

    /**
     * Visit a CompositeDivideNode.
     * @param node The CompositeDivideNode to be visited
     */
    void visit(CompositeDivideNode node);

    /**
     * Visit a CompositeMultiplyNode.
     * @param node The CompositeMultiplyNode to be visited
     */
    void visit(CompositeMultiplyNode node);

    /**
     * Visit a CompositeNegateNode.
     * @param node The CompositeNegateNode to be visited
     */
    void visit(CompositeNegateNode node);

    /**
     * Vist a CompositeNotNode
     * @param node The CompositeNotNode to be visited
     */
    void visit(CompositeNotNode node);

    /**
     * Visit a CompositeOrNode
     * @param node The CompositeOrNode to be visited
     */
    void visit(CompositeOrNode node);

    /**
     * Visit a CompositeSubtractNode.
     */
    void visit(CompositeSubtractNode node);

    /**
     * Visit a LeafNode.
     * @param node The LeafNode to be visited
     */
    void visit(AlgebraicLeafNode node);

    /**
     * Visit a LeafNode.
     * @param node The LeafNode to be visited
     */
    void visit(BooleanLeafNode node);
}

