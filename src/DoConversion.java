//import javax.management.InvalidAttributeValueException;

public class DoConversion {
    public static void main(String[] args) {
        String romanNotation = "LIX";
        NotationConverter notationConverter = new NotationConverter(romanNotation);
        System.out.println(notationConverter.toArabic(romanNotation));
    }
}
