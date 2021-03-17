public class DoConversion {
    public static void main(String[] args) {
        String romanNotation = "MMMXC";
        NotationConverter notationConverter = new NotationConverter(romanNotation);
        System.out.println(notationConverter.toArabic(romanNotation));
    }
}
