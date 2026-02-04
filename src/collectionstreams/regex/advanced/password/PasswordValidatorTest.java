package collectionstreams.regex.advanced.password;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

public class PasswordValidatorTest {


    PasswordValidator validator = new PasswordValidator();


    @Test
    void testValidPassword() {
        assertTrue(validator.isValid("Password1"));
    }


    @Test
    void testInvalidPassword() {
        assertFalse(validator.isValid("pass"));
    }
}
