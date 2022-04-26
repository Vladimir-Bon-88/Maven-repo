package hw11.Calculator;

import hw11.Calculator.exceptions.DivisionOnZero;
import hw11.Calculator.exceptions.NegativeNumberException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CalculatorTest {

    @Test
    void sum() {
        Calculator calculator = new Calculator();
        Assertions.assertEquals(0, calculator.sum(0, 0));
        Assertions.assertEquals(14, calculator.sum(10, 4));
        Assertions.assertEquals(-1, calculator.sum(2, -3));
        Assertions.assertEquals(-15, calculator.sum(-15, 0));
        Assertions.assertEquals(-15.4, calculator.sum(-15, -0.4));
        Assertions.assertEquals(40.5, calculator.sum(24, 16.5));
    }

    @Test
    void difference() {
        Calculator calculator = new Calculator();
        Assertions.assertEquals(2, calculator.difference(4, 2));
        Assertions.assertEquals(-4, calculator.difference(-2, 2));
        Assertions.assertEquals(120, calculator.difference(160, 40));
        Assertions.assertEquals(120, calculator.difference(160, 40));
        Assertions.assertEquals(36, calculator.difference(12, -24));
        Assertions.assertEquals(-11.5, calculator.difference(-11, 0.5));
        Assertions.assertEquals(24.75, calculator.difference(12.5, -12.25));
    }

    @Test
    void division() {
        Calculator calculator = new Calculator();
        DivisionOnZero divisionOnZero = Assertions.assertThrows(DivisionOnZero.class, () -> {
            calculator.division(10, 0);
            }, "Division on zero is illegal");
        Assertions.assertEquals("Division on zero is illegal",divisionOnZero.getMessage());
        Assertions.assertEquals(5, calculator.division(20, 4));
        Assertions.assertEquals(18.5, calculator.division(37, 2));
        Assertions.assertEquals(-18, calculator.division(36, -2));
        Assertions.assertEquals(-0.5, calculator.division(-1, 2));
        Assertions.assertEquals(0, calculator.division(0, 500));
    }

    @Test
    void multiplication() {
        Calculator calculator = new Calculator();
        Assertions.assertEquals(4, calculator.multiplication(2, 2));
        Assertions.assertEquals(12, calculator.multiplication(2, 6));
        Assertions.assertEquals(-15, calculator.multiplication(3, -5));
        Assertions.assertEquals(3.5, calculator.multiplication(7, 0.5));
        Assertions.assertEquals(0, calculator.multiplication(7, 0));
        Assertions.assertEquals(256, calculator.multiplication(16, 16));
    }

    @Test
    void ownSqrt() {
        Calculator calculator = new Calculator();
        NegativeNumberException negativeNumberException = Assertions.assertThrows(NegativeNumberException.class, () ->{
            calculator.ownSqrt(-5);
        }, "Negative number");
        Assertions.assertEquals("Negative number", negativeNumberException.getMessage());
        Assertions.assertEquals(16, calculator.ownSqrt(256));
        Assertions.assertEquals(20, calculator.ownSqrt(400));
        Assertions.assertEquals(20, calculator.ownSqrt(400));
        Assertions.assertEquals(1, calculator.ownSqrt(1));
        Assertions.assertEquals(0, calculator.ownSqrt(0));
    }

    @Test
    void divisionWithRemainder() {
        Calculator calculator = new Calculator();
        DivisionOnZero divisionOnZero = Assertions.assertThrows(DivisionOnZero.class, () -> {
            calculator.divisionWithRemainder(78, 0);
        }, "Division by zero!");
        Assertions.assertEquals("Division by zero!", divisionOnZero.getMessage());
        Assertions.assertEquals(3, calculator.divisionWithRemainder(9, 6));
        Assertions.assertEquals(0, calculator.divisionWithRemainder(10, 1));
        Assertions.assertEquals(1, calculator.divisionWithRemainder(10, 3));
        Assertions.assertEquals(4, calculator.divisionWithRemainder(24, 10));
        Assertions.assertEquals(7, calculator.divisionWithRemainder(7, 95));
    }
}