package ru.teamscore.java23.t1_05.strctr;

public class StringCreationMain {
    public static void main(String[] args) {
        String sJava = "Java";
        String sLiteral1 = "Hello, Java";
        String sLiteral2 =  "Hello, Java";
        String sLiteralConcat =  "Hello, " + "Java";
        String sVariables = "Hello, " + sJava;
        String sVariablesInterned = ("Hello, " + sJava).intern();
        String sConstructorString = new String("Hello, Java");
        String sConstructorChar = new String(new char[] {'H', 'e', 'l', 'l', 'o', ',', ' ', 'J', 'a', 'v', 'a'});
        String lineFormat = "%s %-20s == %b\tequals %b";
        System.out.println(String.format(lineFormat,
                "sLiteral1", "sJava", sLiteral1 == sJava, sLiteral1.equals(sJava)));
        System.out.println(String.format(lineFormat,
                "sLiteral1", "sLiteral2", sLiteral1 == sLiteral2, sLiteral1.equals(sLiteral2)));
        System.out.println(String.format(lineFormat,
                "sLiteral1", "sLiteralConcat", sLiteral1 == sLiteralConcat, sLiteral1.equals(sLiteralConcat)));
        System.out.println(String.format(lineFormat,
                "sLiteral1", "sVariables", sLiteral1 == sVariables, sLiteral1.equals(sVariables)));
        System.out.println(String.format(lineFormat,
                "sLiteral1", "sVariablesInterned", sLiteral1 == sVariablesInterned, sLiteral1.equals(sVariablesInterned)));
        System.out.println(String.format(lineFormat,
                "sLiteral1", "sConstructorString", sLiteral1 == sConstructorString, sLiteral1.equals(sConstructorString)));
        System.out.println(String.format(lineFormat,
                "sLiteral1", "sConstructorChar", sLiteral1 == sConstructorChar, sLiteral1.equals(sConstructorChar)));
    }
}
