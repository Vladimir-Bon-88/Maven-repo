package hw11.Calculator.exceptions;

public class NegativeNumberException extends RuntimeException{
    public NegativeNumberException(String message){
        super(message);
    }
}
