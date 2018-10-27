package ArraysExceptions.MyExceptions;

public class MyArraySizeException extends MyException {
    public MyArraySizeException(String message, int numberRows, int numberColumns) {
        super(message, numberRows, numberColumns);
    }
}
