package com.lukeherron.expressiontree.visitor;

/**
 * Defines the interface to be used by the element in the visitor pattern.
 */
public interface Visitable {

    /**
     * Define the operation used for the Visitor pattern
     * @param visitor Visitor object which contains the visit method to be called
     */
    public void accept(Visitor visitor);
}
