package com.lukeherron.expressiontree;

public class ShiggedyTree {

    private BooleanEvaluator boolEval;
    private AlgebraicCalculator algebraicEval;

    public BooleanEvaluator booleanTest(String test, String truth) {
        return new BooleanEvaluator(test, truth);
    }

    public AlgebraicCalculator calculate(int number) {
        return new AlgebraicCalculator(String.valueOf(number));
    }

    public AlgebraicCalculator calculate(String expression) {
        return new AlgebraicCalculator(expression);
    }
}
