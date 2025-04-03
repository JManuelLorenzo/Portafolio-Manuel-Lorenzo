package ejercicio6;

public class TestMetodos {
    static String text = "Hola Mundo";
    public static void testSubstring() {
        System.out.println(text.substring(5));
        System.out.println(text.substring(0, 4));
    }
    public static void testSplit() {
        String[] split = text.split("a");
        for (String a : split) {
            System.out.println(a);
        }
    }

    public static void testSubSequence() {
        System.out.println(text.subSequence(0, 4));
    }
    public static void testTrim() {
        System.out.println(text.trim());
    }
    public static void testToLowerCase() {
        System.out.println(text.toLowerCase());
    }
    public static void testToUpperCase() {
        System.out.println(text.toUpperCase());
    }
    public static void testIndexOf() {
        System.out.println(text.indexOf('M'));
        System.out.println(text.indexOf("Mun"));
        System.out.println(text.indexOf('o', 5));
    }

    public static void testLastIndexOf() {
        System.out.println(text.lastIndexOf('o'));
        System.out.println(text.lastIndexOf("Hola"));
        System.out.println(text.lastIndexOf('o', 10));
    }

    public static void testContains() {
        System.out.println(text.contains("Mun"));
        System.out.println(text.contains("java"));
    }

    public static void testReplace() {
        System.out.println(text.replace('o', 'x'));
        System.out.println(text.replace("Mundo", "Java"));
    }

    public static void testReplaceAll() {
        System.out.println(text.replaceAll("\\d", "*"));
    }

    public static void testReplaceFirst() {
        System.out.println(text.replaceFirst("Hola", "Hey"));
    }

    public static void main(String[] args) {
        testSubstring();
        testSplit();
        testSubSequence();
        testTrim();
        testToLowerCase();
        testToUpperCase();
        testIndexOf();
        testLastIndexOf();
        testContains();
        testReplace();
        testReplaceAll();
        testReplaceFirst();
    }
}
