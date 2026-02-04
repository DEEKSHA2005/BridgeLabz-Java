package collectionstreams.regex.basics.string;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

public class StringUtilsTest {


    StringUtils utils = new StringUtils();


    @Test
    void testReverse() {
        assertEquals("olleh", utils.reverse("hello"));
    }


    @Test
    void testPalindrome() {
        assertTrue(utils.isPalindrome("madam"));
    }


    @Test
    void testToUpperCase() {
        assertEquals("JAVA", utils.toUpperCase("java"));
    }
}
