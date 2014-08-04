package com.lukeherron.expressiontree.state;

import com.lukeherron.expressiontree.AlgebraicExpressionTree;
import com.lukeherron.expressiontree.BooleanExpressionTree;
import com.lukeherron.expressiontree.ExpressionTree;
import com.lukeherron.expressiontree.Interpreter;

/**
 * Plays the role of the "Context" in the State pattern that ensures user operations on an expression tree are invoked
 * according to the correct protocol. Most of its methods delegate to the corresponding methods in the subclasses of the
 * State base calls, which then perform the requested operations
 */
public class TreeOps {

    private boolean formatted;
    private ExpressionTree tree;
    private Interpreter interpreter;
    private State state;

    public TreeOps(ExpressionTree tree) {
        this.formatted = false;
        this.tree = tree;
        this.interpreter = new Interpreter();
        this.state = new UninitialisedState();
    }

    public TreeOps(String treeType) {
        this.formatted = false;
        this.tree = getNewTree(treeType);
        this.interpreter = new Interpreter();
        this.state = new UninitialisedState();
    }

    private ExpressionTree getNewTree(String treeType) {
        if (treeType.equals("algebraic")) {
            return new AlgebraicExpressionTree(null);
        }
        else if (treeType.equals("boolean")) {
            return new BooleanExpressionTree(null);
        }

        throw new IllegalArgumentException(treeType + " is not a supported expression tree type");
    }

    public void makeTree(String expression) {
        state.makeTree(this, expression);
    }

    public void evaluate() {
        this.evaluate("");
    }

    public void evaluate(String format) {
        state.evaluate(this, format);
    }

    public void format() {
        this.format("");
    }

    public void format(String newFormat) {
        state.format(this, newFormat);
        this.formatted = true;
    }

    public void print() {
        this.print("");
    }

    public void print(String format) {
        state.print(this, format);
    }

    /**
     * Sets the variable to its corresponding value
     * @param keyValuePair String containing the key/value pair to set
     * @throws Exception
     */
    public void set(String keyValuePair) throws Exception {
        String inputString = keyValuePair.replaceAll(" ", "");
        int pos;

        if ((pos = inputString.indexOf('=')) != inputString.length() - 1) {
            if (pos != 0 && pos < inputString.length() -1) {
                String key = inputString.substring(0, pos);
                String value = inputString.substring(pos + 1);
                interpreter.symbolTable().set(key, Integer.parseInt(value));
            }
            else {
                throw new Exception("Must be in the form key=value");
            }
        }
        else {
            throw new Exception("Must have = sign present");
        }
    }


    /**
     * Return a pointer to the current State
     * @return State object
     */
    State state() {
        return state;
    }

    /**
     * Return the current ExpressionTree that's owned by this object
     * @return ExpressionTree
     */
    ExpressionTree tree() {
        return tree;
    }

    /**
     * The interpreter used to parse and process user expression input
     * @return Interpreter object
     */
    Interpreter interpreter() {
        return interpreter;
    }

    /**
     * Set the current ExpressionTree to a newTree=
     * @param newTree ExpressionTree to set
     */
    void tree(ExpressionTree newTree) {
        tree = newTree;
    }

    /**
     * Set the current @a State to the designated @a new state pointer.
     */
    void state(State newState) {
        this.state = newState;
    }

    /**
     * Returns whether or not a successful format call has been called
     * @return Boolean
     */
    public final boolean formatted() {
        return formatted;
    }
}
