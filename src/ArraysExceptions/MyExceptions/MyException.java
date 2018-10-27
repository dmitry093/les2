package ArraysExceptions.MyExceptions;

class MyException extends Exception {
    private String message;

    MyException(String message, int numberRows, int numberColumns) {
        this.message = message + "\n" + "Подсказка: массив должен быть String[" + numberRows + "][" + numberColumns + "] и состоять из чисел";
    }

    MyException(String message, int numberRows, int numberColumns, int i, int j) {
        this.message = message + "\n" + "Ошибка в элементе [" + i + "][" + j +"]" + "\n" + "Подсказка: массив должен быть String[" + numberRows + "][" + numberColumns + "] и состоять из чисел";
    }

    @Override
    public String getMessage(){
        return message;
    }
}
