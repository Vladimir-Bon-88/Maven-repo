package hw11.Calculator.exceptions;

public class DivisionOnZero extends RuntimeException{
    public DivisionOnZero(String message){
        super(message);
    }
}
