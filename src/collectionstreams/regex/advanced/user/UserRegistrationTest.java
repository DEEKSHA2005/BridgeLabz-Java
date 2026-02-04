package collectionstreams.regex.advanced.user;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

public class UserRegistrationTest {


    UserRegistration registration = new UserRegistration();


    @Test
    void testValidUser() {
        assertTrue(registration.registerUser("varsha", "varsha@gmail.com", "secret1"));
    }


    @Test
    void testInvalidUser() {
        assertThrows(IllegalArgumentException.class, () -> {
            registration.registerUser("", "invalid", "123");
        });
    }
}