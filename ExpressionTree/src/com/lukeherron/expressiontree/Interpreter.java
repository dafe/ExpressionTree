package com.lukeherron.expressiontree;

import com.lukeherron.expressiontree.symbol.*;
import com.lukeherron.expressiontree.symbol.Number;
import com.lukeherron.expressiontree.symbol.Symbol;

import java.util.Stack;

/**
 * Interpreter parses incoming expression strings into a parse tree and builds an expression tree from the parse tree.
 * This class plays the role of the "Interpreter" in the Interpreter pattern, tweaked to use the precedence of
 * operators/operands to guide the creation of the parse tree. It also uses the Builder pattern to build the component
 * nodes in the Composite-based expression tree.
 */
public class Interpreter {

    private int multiDigitNumbers;
    private Symbol lastValidInput;
    private int accumulatedPrecedence;

    private ExpressionTreeFactory expressionTreeFactory;

    // Stores variables and their values for use by the Interpreter
    private SymbolTable symbolTable = new SymbolTable();

    public Interpreter() {
        this.expressionTreeFactory = new ExpressionTreeFactory();
    }

    public Interpreter(ExpressionTreeFactory expressionTreeFactory) {
        this.expressionTreeFactory = expressionTreeFactory;
    }

    /**
     * This method first converts a string into a parse tree and then builds an expression tree out of the parse tree.
     * This method is implemented using the Template Method pattern
     * @param inputExpression String to be converted into a parse tree
     * @param expressionType String indicating the type of tree to build from the inputExpression
     * @return Expression tree containing the converted parse tree
     */
    public ExpressionTree interpret(String inputExpression, String expressionType) {
        // The parse tree is implemented as a stack
        Stack<Symbol> parseTree = buildParseTree(inputExpression, expressionType);

        // We include a method here for performing any further optimisations on our parse tree before we convert it
        optimiseParseTree(parseTree);

        // Empty parse trees are perfectly fine, just make sure we don't try and build from an empty tree. An empty
        // expression tree should be returned instead.
        return parseTree.empty() ? expressionTreeFactory.makeExpressionTree(null) : buildExpressionTree(parseTree);
    }

    public ExpressionTree interpret(String inputExpression, ExpressionTree tree) {
        return interpret(inputExpression, tree.type());
    }

    /**
     * This method builds the actual parse tree from our input expression
     * @param inputExpression String input to be parsed and inserted into the ParseTree
     * @return ParseTree containing all of the parsed and inserted input expressions
     */
    public Stack<Symbol> buildParseTree(String inputExpression, String expressionType) {
        Stack<Symbol> parseTree = new Stack<>();
        lastValidInput = null;
        accumulatedPrecedence = 0;
        multiDigitNumbers = 0;

        switch (expressionType) {
            case "algebraic":
                parseTree = buildAlgebraicParseTree(inputExpression, parseTree);
                break;
            case "boolean":
                parseTree = buildBooleanParseTree(inputExpression, parseTree);
                break;
            default:
                break;
        }

        return parseTree;
    }

    public Stack<Symbol> buildAlgebraicParseTree(String inputExpression, Stack<Symbol> parseTree) {
        for (int i = 0; i < inputExpression.length(); ++i) {
            // Locate the next symbol in the input and place it into the parse tree according to its precedence
            parseTree = parseNextAlgebraicSymbol(inputExpression, i, parseTree);
            if (multiDigitNumbers > i) {
                i = multiDigitNumbers;
            }
        }

        return parseTree;
    }

    public Stack<Symbol> buildBooleanParseTree(String inputExpression, Stack<Symbol> parseTree) {
        for (int i = 0; i < inputExpression.length(); ++i) {
            // Locate the next symbol in the input and place it into the parse tree according to its precedence
            parseTree = parseNextBooleanSymbol(inputExpression, i, parseTree);
            if (multiDigitNumbers > i) {
                i = multiDigitNumbers;
            }
        }

        return parseTree;
    }

    /**
     * This hook method can be overridden to conduct optimisation on the parseTree prior to generating the
     * ExpressionTree. By default it's a no-op
     *
     * @param parseTree The parseTree which is to be optimised
     */
    protected void optimiseParseTree(Stack<Symbol> parseTree) {
    }

    protected ExpressionTree buildExpressionTree(Stack<Symbol> parseTree) {
        assert (parseTree.size() == 1);
        return expressionTreeFactory.makeExpressionTree(parseTree.peek().build());
    }

    /**
     * Parse terminal expressions
     * @param inputExpression String containing expressions to be parse
     * @param index int indicating the current position in the input expression
     * @param parseTree Stack of parseTree Symbols to be processed
     * @return ParseTree that has been constructed based on the inputExpression string
     */
    private Stack<Symbol> parseNextAlgebraicSymbol(String inputExpression, int index, Stack<Symbol> parseTree) {
        char symbol = inputExpression.charAt(index);
        if (Character.isLetterOrDigit(symbol)) {
            parseTree = insertNumberOrVariable(inputExpression, index, parseTree, Character.isLetter(symbol));
        }
        else if (symbol == '+') {
            Add operator = new Add();
            operator.addPrecedence(accumulatedPrecedence);
            lastValidInput = null;
            parseTree = insertSymbolByPrecedence(operator, parseTree);
        }
        else if (symbol == '-') {
            Symbol operator = lastValidInput == null ? new Negate() : new Subtract();
            operator.addPrecedence(accumulatedPrecedence);
            lastValidInput = null;
            parseTree = insertSymbolByPrecedence(operator, parseTree);
        }
        else if (symbol == '*') {
            Multiply operator = new Multiply();
            operator.addPrecedence(accumulatedPrecedence);
            lastValidInput = null;
            parseTree = insertSymbolByPrecedence(operator, parseTree);
        }
        else if (symbol == '/') {
            Divide operator = new Divide();
            operator.addPrecedence(accumulatedPrecedence);
            lastValidInput = null;
            parseTree = insertSymbolByPrecedence(operator, parseTree);
        }
        else if (symbol == '(') {
            parseTree = handleParentheses(inputExpression, index, parseTree, "algebraic");
        }
        else if (inputExpression.charAt(index) == ' ' || inputExpression.charAt(index) == '\n') {
            // Skip whitespace
        }

        return parseTree;
    }

    /**
     * Parse boolean terminal expressions
     * @param inputExpression String containing expressions to be parse
     * @param index int indicating the current position in the input expression
     * @param parseTree Stack of parseTree Symbols to be processed
     * @return ParseTree that has been constructed based on the inputExpression string
     */
    private Stack<Symbol> parseNextBooleanSymbol(String inputExpression, int index, Stack<Symbol> parseTree) {
        char symbol = inputExpression.charAt(index);
        if (Character.isLetterOrDigit(symbol)) {
            parseTree = insertString(inputExpression, index, parseTree);
        }
        else if (symbol == '&') {
            And operator = new And();
            operator.addPrecedence(accumulatedPrecedence);
            lastValidInput = null;
            parseTree = insertSymbolByPrecedence(operator, parseTree);
        }
        else if (symbol == '|') {
            Or operator = new Or();
            operator.addPrecedence(accumulatedPrecedence);
            lastValidInput = null;
            parseTree = insertSymbolByPrecedence(operator, parseTree);
        }
        else if (symbol == '!') {
            Not operator = new Not();
            operator.addPrecedence(accumulatedPrecedence);
            lastValidInput = null;
            parseTree = insertSymbolByPrecedence(operator, parseTree);
        }
        else if (symbol == '(') {
            parseTree = handleParentheses(inputExpression, index, parseTree, "boolean");
        }
        else if (inputExpression.charAt(index) == ' ' || inputExpression.charAt(index) == '\n') {
            // Skip whitespace
        }

        return parseTree;
    }

    private Stack<Symbol> insertNumberOrVariable(String input, int startIndex, Stack<Symbol> parseTree, boolean isVar) {
        int endIndex = 1;

        /* Merge all consecutive number chars int a single Number symbol. Eg. '123' = int (123). We do this by locating
         * the end of the number, adjusting endIndex accordingly */
        //if (input.length() > startIndex + endIndex) {
        //    while (startIndex + endIndex < input.length() && Character.isDigit(input.charAt(startIndex + endIndex))) {
        //        ++endIndex;
        //    }
        //}

        if (input.length() > startIndex + endIndex) {
            // Locate the end of the number
            for (; startIndex + endIndex < input.length() && Character.isDigit(input.charAt(startIndex + endIndex)); ++endIndex) {
                continue;
            }
        }

        /* If we have received a variable as the input, then look up that variables value in the Symbol Table and assign
         * it as our number, otherwise we can just parse the string as it should represent a number */
        String parseString = input.substring(startIndex, startIndex + endIndex);
        Number number = isVar ? new Number(symbolTable.get(parseString)) : new Number(parseString);
        number.addPrecedence(accumulatedPrecedence);
        lastValidInput = number;

        /* Update startIndex to the last character that was a number. The ++startIndex will update the startIndex at the
         * end of the loop to the next check */
        startIndex += endIndex - 1;
        multiDigitNumbers = startIndex;

        return insertSymbolByPrecedence(number, parseTree);
    }

    private Stack<Symbol> insertString(String input, int startIndex, Stack<Symbol> parseTree) {
        int endIndex = 1;

        /* Merge all consecutive number chars int a single Number symbol. Eg. '123' = int (123). We do this by locating
         * the end of the number, adjusting endIndex accordingly */
        if (input.length() > startIndex + endIndex) {
            while (startIndex + endIndex < input.length() && Character.isDigit(input.charAt(startIndex + endIndex))) {
                ++endIndex;
            }
        }

        /* If we have received a variable as the input, then look up that variables value in the Symbol Table and assign
         * it as our number, otherwise we can just parse the string as it should represent a number */
        String parseString = input.substring(startIndex, startIndex + endIndex);

        Bool bool = new Bool(parseString);
        bool.addPrecedence(accumulatedPrecedence);
        lastValidInput = bool;

        /* Update startIndex to the last character that was the string. The ++startIndex will update the startIndex at
         * the end of the loop to the next check */
        startIndex += endIndex - 1;
        multiDigitNumbers = startIndex;

        return insertSymbolByPrecedence(bool, parseTree);
    }

    private Stack<Symbol> insertSymbolByPrecedence(Symbol symbol, Stack<Symbol> parseTree) {
        if (!parseTree.empty()) {
            // If last element was a number, then make that our left
            Symbol parent = parseTree.peek();
            Symbol child = parent.right;

            if (child != null) {
                // While there is a child of parent, keep going down the right side
                while (child != null && child.precedence() < symbol.precedence()) {
                    parent = child;
                    child = child.right;
                }
            }

            if (parent.precedence() < symbol.precedence()) {
                /* Symbol left will be the old child. New parent child will be the Symbol. To allow infinite negations,
                 * we have to check for unary operator */
                if (symbol.left == null) {
                    symbol.left = child;
                }

                parent.right = symbol;
            }
            else {
                /* This can be one of two things, either we are the same precedence or we are less precedence than the
                 * parent. This also means different things for unary ops. The most recent unary op (negate) has a
                 * higher precedence */
                UnaryOperator operator = new Negate();

                if (symbol.getClass() == operator.getClass()) {
                    while (child != null && child.precedence() == symbol.precedence()) {
                        parent.right = symbol;
                        child = child.right;
                    }
                }
                else {
                    /* Everything else is evaluated the same. For instance, if this is 5 * 4 / 2, and we currently have
                     * Multi(5, 4) in the parseTree, we need to make parent our left child */
                    symbol.left = parent;
                    parseTree.pop();
                    parseTree.push(symbol);
                    parent = child;
                }
            }
        }
        else {
            parseTree.push(symbol);
        }

        return parseTree;
    }

    /**
     * Parse terminal expressions that contains parentheses
     * @param inputExpression String that indicates the input expression to be parsed
     * @param index int indicating the current position in the input expression
     * @param masterParseTree Stack that holds parseTree processed from input expression
     * @return ParseTree that has been constructed based on the input expression
     */
    private Stack<Symbol> handleParentheses(String inputExpression, int index, Stack<Symbol> masterParseTree,
                                            String parseTreeType) {
        accumulatedPrecedence += Symbol.parenPrecedence;
        Stack<Symbol> localParseTree = new Stack<>();

        // Process the input expression between the parentheses.
        for (++index; index < inputExpression.length(); ++index) {
            localParseTree = parseTreeType.equals("algebraic") ?
                    parseNextAlgebraicSymbol(inputExpression, index, localParseTree) :
                    parseNextBooleanSymbol(inputExpression, index, localParseTree);

            if (multiDigitNumbers > index) {
                index = multiDigitNumbers;
            }

            // Reduce the accumulated precedence and break from loop once we leave the parentheses
            if (inputExpression.charAt(index) == ')') {
                accumulatedPrecedence -= Symbol.parenPrecedence;
                break;
            }
        }

        if (masterParseTree.size() > 0 && localParseTree.size() > 0) {
            masterParseTree = insertSymbolByPrecedence(localParseTree.peek(), masterParseTree);
        }
        else if (localParseTree.size() > 0) {
            masterParseTree = localParseTree;
        }

        return masterParseTree;
    }

    public SymbolTable symbolTable() {
        return symbolTable;
    }
}
