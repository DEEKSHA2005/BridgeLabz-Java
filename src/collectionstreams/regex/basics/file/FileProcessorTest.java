package collectionstreams.regex.basics.file;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

public class FileProcessorTest {


    FileProcessor processor = new FileProcessor();


    @Test
    void testFileWriteRead() throws Exception {
        processor.writeToFile("test.txt", "Hello");
        assertEquals("Hello", processor.readFromFile("test.txt"));
    }
}
