package ArraysExceptions;

import ArraysExceptions.MyExceptions.MyArrayDataException;
import ArraysExceptions.MyExceptions.MyArraySizeException;

public class ArraysExceptions {
    private static int ROWS = 4;
    private static int COLUMNS = 4;

    private static int getSumOfArray(String[][] incArray) throws MyArraySizeException, MyArrayDataException {
        int sum = 0;
        if (incArray == null) {
            throw new MyArraySizeException("Объект массива равен Null", ROWS, COLUMNS);
        }
        if (incArray.length != ROWS) {
            throw new MyArraySizeException("Количество строк = " + incArray.length, ROWS, COLUMNS);
        }
        for (int i = 0; i < ROWS; i++) {
            if (incArray[i].length != COLUMNS) {
                throw new MyArraySizeException("Количество столбцов в " + (i + 1) + "-строке = " + incArray[i].length, ROWS, COLUMNS);
            }
            for (int j = 0; j < COLUMNS; j++) {
                if (incArray[i][j] == null) {
                    throw new MyArrayDataException("Элемент = null", ROWS, COLUMNS, i, j);
                }
                try {
                    sum += Integer.parseInt(incArray[i][j]);
                } catch (NumberFormatException ex) {
                    throw new MyArrayDataException("Элемент " + incArray[i][j] + " не число", ROWS, COLUMNS, i, j);
                }
            }
        }
        return sum;
    }

    public static void main(String[] args) {
        tryRun(null);
        String[][] wrongSizeColumnsArray = new String[ROWS][COLUMNS - 1];
        tryRun(wrongSizeColumnsArray);
        String[][] wrongSizeColumnsArray2 = {
                {"1", "2", "3", "4"},
                {"5", "6", "7", "8"},
                {"9", "10", "11"},
                {"12", "13", "14", "15"}
        };
        tryRun(wrongSizeColumnsArray2);
        String[][] wrongSizeRowsArray = new String[ROWS + 1][COLUMNS];
        tryRun(wrongSizeRowsArray);
        String[][] wrongSizeRowsArray2 = {
                {"1", "2", "3", "4"},
                {"5", "6", "7", "8"},
                {"12", "13", "14", "15"}
        };
        tryRun(wrongSizeRowsArray2);
        String[][] arrayWithNullElement = {
                {"1", null, "3", "4"},
                {"5", "6", "7", "8"},
                {"9", "10", "11", "12"},
                {"13", "14", "15", "16"}
        };
        tryRun(arrayWithNullElement);
        String[][] arrayWithNotNumberElement = {
                {"1", "2", "3", "4"},
                {"5", "6", "7", "8"},
                {"9", "10", "11", "12"},
                {"13", "14", "test", "16"}
        };
        tryRun(arrayWithNotNumberElement);
        String[][] goodArray = {
                {"1", "2", "3", "4"},
                {"5", "6", "7", "8"},
                {"9", "10", "11", "12"},
                {"13", "14", "15", "16"}
        };
        tryRun(goodArray);
    }

    private static void tryRun(String[][] array) {
        try {
            System.out.println("Сумма элементов массива = " + getSumOfArray(array));
        } catch (MyArraySizeException e) {
            e.printStackTrace();
        } catch (MyArrayDataException e) {
            e.printStackTrace();
        }
    }
}
