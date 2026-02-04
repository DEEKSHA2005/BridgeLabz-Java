package collectionstreams.regex.basics.database;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class DatabaseConnectionTest {

    DatabaseConnection db;


    @BeforeEach
    void setUp() {
        db = new DatabaseConnection();
        db.connect();
    }


    @AfterEach
    void tearDown() {
        db.disconnect();
    }


    @Test
    void testConnection() {
    }
}
