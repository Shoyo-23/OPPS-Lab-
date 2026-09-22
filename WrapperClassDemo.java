public class WrapperClassDemo {
    public static void main(String[] args) {

        int primitiveInt = 100;
        float primitiveFloat = 25.75f;
        char primitiveChar = 'A';
        boolean primitiveBoolean = true;

        // Autoboxing
        Integer wrapperInt = primitiveInt;
        Float wrapperFloat = primitiveFloat;
        Character wrapperChar = primitiveChar;
        Boolean wrapperBoolean = primitiveBoolean;

        System.out.println("Autoboxed Integer: " + wrapperInt);
        System.out.println("Autoboxed Float: " + wrapperFloat);
        System.out.println("Autoboxed Character: " + wrapperChar);
        System.out.println("Autoboxed Boolean: " + wrapperBoolean);

        // Unboxing
        int unboxedInt = wrapperInt;
        float unboxedFloat = wrapperFloat;
        char unboxedChar = wrapperChar;
        boolean unboxedBoolean = wrapperBoolean;

        System.out.println("Unboxed int: " + unboxedInt);
        System.out.println("Unboxed float: " + unboxedFloat);
        System.out.println("Unboxed char: " + unboxedChar);
        System.out.println("Unboxed boolean: " + unboxedBoolean);

        // Parsing String into wrapper objects
        String intString = "300";
        Integer parsedInt = Integer.parseInt(intString);

        String floatString = "75.25";
        Float parsedFloat = Float.parseFloat(floatString);

        String charString = "c";
        Character parsedChar = charString.charAt(0);

        String booleanString = "true";
        Boolean parsedBoolean = Boolean.parseBoolean(booleanString);

        System.out.println("Parsed Integer: " + parsedInt);
        System.out.println("Parsed Float: " + parsedFloat);
        System.out.println("Parsed Character: " + parsedChar);
        System.out.println("Parsed Boolean: " + parsedBoolean);
    }
}
