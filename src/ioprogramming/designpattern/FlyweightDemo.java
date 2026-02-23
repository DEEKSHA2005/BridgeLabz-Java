package ioprogramming.designpattern;
import java.util.*;

/*
 Flyweight Pattern
 Reuses objects to save memory
*/

// shared object
class Font {

    String type;

    Font(String type) {
        this.type = type;
    }
}

// factory
class FontFactory {

    static Map<String, Font> fonts = new HashMap<>();

    public static Font getFont(String type) {

        if (!fonts.containsKey(type)) {
            fonts.put(type, new Font(type));
            System.out.println("Creating new font: " + type);
        }

        return fonts.get(type);
    }
}

// character class
class CharacterLetter {

    char letter;
    Font font;

    CharacterLetter(char letter, Font font) {
        this.letter = letter;
        this.font = font;
    }

    void display() {
        System.out.println(letter + " with font " + font.type);
    }
}

public class FlyweightDemo {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.println("Enter word:");
        String word = sc.nextLine();

        System.out.println("Enter font type:");
        String fontType = sc.nextLine();

        Font font = FontFactory.getFont(fontType);

        for (char c : word.toCharArray()) {
            CharacterLetter ch = new CharacterLetter(c, font);
            ch.display();
        }
    }
}