package coreprogramming.strings.level3;

import java.util.Scanner;

public class CharFrequencyNestedLoop {

    public static String[] findCharacterFrequency(String text) {

        char[] chars = text.toCharArray();
        int length = chars.length;

        String[] result = new String[length];
        int index = 0;

        for (int i = 0; i < length; i++) {

            if (chars[i] == '0') {
                continue;
            }

            int frequency = 1;

            for (int j = i + 1; j < length; j++) {
                if (chars[i] == chars[j]) {
                    frequency++;
                    chars[j] = '0'; // mark duplicate
                }
            }

            result[index++] = chars[i] + " : " + frequency;
        }

        String[] finalResult = new String[index];
        for (int i = 0; i < index; i++) {
            finalResult[i] = result[i];
        }

        return finalResult;
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter text: ");
        String text = sc.nextLine();

        String[] frequencies = findCharacterFrequency(text);

        System.out.println("\nCharacter : Frequency");
        System.out.println("----------------------");

        for (String entry : frequencies) {
            System.out.println(entry);
        }
    }
}

