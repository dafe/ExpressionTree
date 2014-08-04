package com.lukeherron.expressiontree.visitor;

import java.util.HashMap;

/**
 * Implementation of the Factory Method pattern that dynamically allocates the appropriate Visitor object requested by
 * a caller. This variant of the pattern doesn't use inheritance, so it plays the role of the ConcreteCreator in the
 * Factory Method pattern
 */
public class VisitorFactory {

    private static interface IVisitorFactoryCommand {
        public Visitor execute();
    }

    private HashMap<String, IVisitorFactoryCommand> visitorMap = new HashMap<>();

    /**
     * The VisitorFactory maps strings to an interface capable of building the appropriate Visitor implementation at
     * runtime
     */
    public VisitorFactory() {
        visitorMap.put("algebraic-eval", AlgebraicEvalVisitor::new);
        visitorMap.put("boolean-eval", BooleanEvalVisitor::new);
        visitorMap.put("print", PrintVisitor::new);
        visitorMap.put("type", TypeVisitor::new);
    }

    public Visitor makeVisitor(String visitorRequest) {
        IVisitorFactoryCommand command = visitorMap.get(visitorRequest);

        if (command != null) {
            return command.execute();
        } else {
            throw new IllegalArgumentException(visitorRequest + " is not a supported visitor");
        }
    }
}
