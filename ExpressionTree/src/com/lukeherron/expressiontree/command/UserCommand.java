package com.lukeherron.expressiontree.command;

import com.lukeherron.expressiontree.state.TreeOps;

/**
 * UserCommand plays the role of the "Command" in the Command pattern to define an API for "ConcreteCommand"
 * implementations that perform an operation on the expression tree when it's executed
 */
public abstract class UserCommand {

    protected TreeOps treeOps;

    /**
     * Runs the command
     * @throws Exception
     */
    public abstract void execute() throws Exception;
}
