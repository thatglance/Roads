package main.java.com.epam.exception;

public class WrongFileFormatException extends Exception {

    public WrongFileFormatException(final String message){
        super(message);
    }

}
