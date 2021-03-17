import java.util.Scanner;

public class basic {
    public static void main(String[] args) {
        char[] romanKeysArray = {'I', 'V', 'X', 'L', 'C', 'D', 'M'};
        int[] arabicKeysArray = {1, 5, 10, 50, 100, 500, 1000};
        int result;

        char[] inputCharArray = InputConvertor(AskInputRoanNumber());
        int[] inputArabicArray = new int[inputCharArray.length];


        for (int i = 0; i < inputCharArray.length; i++) {
            for (int j = 0; j < romanKeysArray.length; j++) {
                if (inputCharArray[i] == romanKeysArray[j]) {
                    inputArabicArray[i] = arabicKeysArray[j];
                }
            }
        }

        result = ResultCalculator(inputArabicArray);


        System.out.println("Result: " + result);

    }


    public static char[] InputConvertor(String inputRomanNumber) {
        char[] inputRomanCharArray = inputRomanNumber.toCharArray();
        return inputRomanCharArray;
    }

    public static String AskInputRoanNumber() {
        System.out.println("Input Roman number:");
        Scanner scanner = new Scanner(System.in);
        String inputRomanNumber = scanner.next();
        return inputRomanNumber;

    }



    public static int ResultCalculator(int[] inputArray) {
        int result = 0;
        if (inputArray.length == 1) return inputArray[0];

        if (inputArray.length == 2) {
            return TwoLengthNumberCalculator(inputArray);
        }
        result = ThreeAndMoreNumberCalculator(inputArray);


        return result;

    }



    public static int TwoLengthNumberCalculator(int[] inputArray) {
        int result = 0;
        System.out.println("TwoLength method running..");
        if (inputArray[0] < inputArray[1]) {
            result = (inputArray[1] - inputArray[0]);

        } else {
            result = (inputArray[1] + inputArray[0]);
        }
        return result;

    }
    public static int ThreeAndMoreNumberCalculator(int[] inputArray){
        int result = inputArray[0] + inputArray[inputArray.length-1];

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
