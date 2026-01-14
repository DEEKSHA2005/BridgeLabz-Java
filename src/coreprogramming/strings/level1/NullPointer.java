package coreprogramming.strings.level1;

public class NullPointer {

    public static void generateNullPointerException() {

        String text = null;
        System.out.println(text.length());
    }

    public static void handleNullPointerException() {

        String text = null;

        try {
            System.out.println(text.length());
        } catch (NullPointerException e) {
            System.out.println("NullPointerException handled successfully");
        }
    }

    public static void main(String[] args) {

        try {
            generateNullPointerException();
        } catch (Exception e) {
            System.out.println("Exception occurred: " + e);
        }

        handleNullPointerException();
    }
}

