package ArraysExceptions.MyExceptions;

public class MyArrayDataException extends MyException {
    public MyArrayDataException(String message, int numberRows, int numberColumns, int i, int j) {
        super(message, numberRows, numberColumns, i, j);
    }
}
