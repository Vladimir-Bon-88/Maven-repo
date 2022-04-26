package hw11.Calculator;

import hw11.Calculator.exceptions.DivisionOnZero;
import hw11.Calculator.exceptions.NegativeNumberException;

public class Calculator {

    public double sum(double a, double b) {
        return a + b;
    }

    public double difference(double a, double b) {
        return a - b;
    }

    public double division(double a, double b) {
        if (b == 0) {
            throw new DivisionOnZero("Division on zero is illegal");
        } else return a / b;
    }

    public double multiplication(double a, double b){
        return a * b;
    }

    public double ownSqrt(double a){
        if(a < 0){
            throw new NegativeNumberException("Negative number");
        }
        return Math.sqrt(a);
    }

    public double divisionWithRemainder(double a, double b){
        if(b == 0){
            throw new DivisionOnZero("Division by zero!");
        } else return a % b;
    }
}
