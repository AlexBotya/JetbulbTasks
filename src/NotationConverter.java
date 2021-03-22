public class NotationConverter {


    public int toArabic(String romanNotation) throws InvalidValueException{

        checkNullAndEmptyInputString(romanNotation);

        inputCharArray = romanNotation.toCharArray();

        int[] inputArabicArray = new int[inputCharArray.length];

        ConvertCharToIntArray(inputCharArray, inputArabicArray);

        checkIncorrectRomanSymbols(inputArabicArray);

        return ResultCalculator(inputArabicArray);
    }

    private final char[] romanKeysArray = {'I', 'V', 'X', 'L', 'C', 'D', 'M'};
    private final int[] arabicKeysArray = {1, 5, 10, 50, 100, 500, 1000};
    char[] inputCharArray;
    String errorMessage = "String must contain only valid roman numerals [I, V, X, L, C, D, M]";





    public int ResultCalculator(int[] inputArray) {
        int result;
        if (inputArray.length == 1) return inputArray[0];

        if (inputArray.length == 2) {
            return TwoLengthNumberCalculator(inputArray);
        }
        result = ThreeAndMoreNumberCalculator(inputArray);


        return result;

    }


    private int TwoLengthNumberCalculator(int[] inputArray) {
        int result;
        if (inputArray[0] < inputArray[1]) {
            result = (inputArray[1] - inputArray[0]);

        } else {
            result = (inputArray[1] + inputArray[0]);
        }
        return result;

    }

    private int ThreeAndMoreNumberCalculator(int[] inputArray) {
        int result;
        if (inputArray[0] < inputArray[1]) {
            result = -inputArray[0] + inputArray[inputArray.length - 1];
        } else {
            result = inputArray[0] + inputArray[inputArray.length - 1];
        }

        for (int i = 1; i < inputArray.length - 1; i++) {
            if (inputArray[i] >= inputArray[i + 1]) {
                result += inputArray[i];
            } else if (inputArray[i] < inputArray[i - 1] && inputArray[i] < inputArray[i + 1]) {
                result -= inputArray[i];
            }

        }
        return result;
    }

    private void checkNullAndEmptyInputString(String inputString) {
        try {
            if (inputString.equals("") ) throw new InvalidValueException(errorMessage);
        }catch (NullPointerException e) {
            throw new InvalidValueException(errorMessage, e);
        }


    }

    private void checkIncorrectRomanSymbols(int[] inputArabicArray) {
        for (int i = 0; i < inputArabicArray.length; i++) {
            if (inputArabicArray[i] == 0) {
                throw new InvalidValueException(errorMessage);
            }


        }
    }

    private void ConvertCharToIntArray(char[] inputCharArray, int[] inputArabicArray) {

        for (int i = 0; i < inputCharArray.length; i++) {
            for (int j = 0; j < romanKeysArray.length; j++) {
                if (inputCharArray[i] == romanKeysArray[j]) {
                    inputArabicArray[i] = arabicKeysArray[j];

                }

            }
        }

    }
}
