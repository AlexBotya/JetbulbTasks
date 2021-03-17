


public class NotationConverter {
    private final char[] romanKeysArray = {'I', 'V', 'X', 'L', 'C', 'D', 'M'};
    private final int[] arabicKeysArray = {1, 5, 10, 50, 100, 500, 1000};
    String romanNotation;

    public NotationConverter(String romanNotation) throws InvalidValueException {
        this.romanNotation = romanNotation;
    }

    public int toArabic(String romanNotation) {
        char[] inputCharArray = InputConvertor(romanNotation);
        int[] inputArabicArray = new int[inputCharArray.length];

            for (int i = 0; i < inputCharArray.length; i++) {
                for (int j = 0; j < romanKeysArray.length; j++) {
                    //try{
                    if (inputCharArray[i] == romanKeysArray[j]) {
                        inputArabicArray[i] = arabicKeysArray[j];
                        //}else {throw new };
                    }
               // }catch (inputArabicArray[i] != arabicKeysArray[j]) new InvalidValueException("Incorrect symbol");
            }
        }
        return ResultCalculator(inputArabicArray);
    }

    private char[] InputConvertor(String inputRomanNumber) {
        char[] inputRomanCharArray = inputRomanNumber.toCharArray();
        return inputRomanCharArray;
    }

    public int ResultCalculator(int[] inputArray) {
        int result = 0;
        if (inputArray.length == 1) return inputArray[0];

        if (inputArray.length == 2) {
            return TwoLengthNumberCalculator(inputArray);
        }
        result = ThreeAndMoreNumberCalculator(inputArray);


        return result;

    }


    private int TwoLengthNumberCalculator(int[] inputArray) {
        int result = 0;
        System.out.println("TwoLength method running..");
        if (inputArray[0] < inputArray[1]) {
            result = (inputArray[1] - inputArray[0]);

        } else {
            result = (inputArray[1] + inputArray[0]);
        }
        return result;

    }

    private int ThreeAndMoreNumberCalculator(int[] inputArray) {
        int result = 0;
        if (inputArray[0] < inputArray[1]) {
            result = -inputArray[0] + inputArray[inputArray.length - 1];
        } else {
            result = inputArray[0] + inputArray[inputArray.length - 1];
        }
        ;
        for (int i = 1; i < inputArray.length - 1; i++) {
            if (inputArray[i] >= inputArray[i + 1]) {
                result += inputArray[i];
            } else if (inputArray[i] < inputArray[i - 1] && inputArray[i] < inputArray[i + 1]) {
                result -= inputArray[i];
            }

        }
        return result;
    }
}
