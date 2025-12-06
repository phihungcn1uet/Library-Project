package Model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class TextBookTest {

    private TextBook textBook;

    @BeforeEach
    public void setUp() {
        // Initialize a TextBook object for testing
        textBook = new TextBook("T01", "Java Programming", "John Doe", 10);
    }

    @Test
    public void testConstructor() {
        assertNotNull(textBook, "TextBook object should be instantiated.");
        assertEquals("T01", textBook.getId(), "The ID should be 'T01'.");
        assertEquals("Java Programming", textBook.getName(), "The name should be 'Java Programming'.");
        assertEquals("John Doe", textBook.getAuthor(), "The author should be 'John Doe'.");
        assertEquals(10, textBook.getQuantity(), "The quantity should be 10.");
        assertEquals("Sách giáo trình", textBook.getCategory(), "The category should be 'Sách giáo trình'.");
    }

    @Test
    public void testSettersAndGetters() {
        textBook.setId("T02");
        textBook.setName("Advanced Java");
        textBook.setAuthor("Jane Doe");
        textBook.setQuantity(15);

        assertEquals("T02", textBook.getId(), "The ID should be 'T02'.");
        assertEquals("Advanced Java", textBook.getName(), "The name should be 'Advanced Java'.");
        assertEquals("Jane Doe", textBook.getAuthor(), "The author should be 'Jane Doe'.");
        assertEquals(15, textBook.getQuantity(), "The quantity should be 15.");
    }

    @Test
    public void testGetInfo() {
        String expectedInfo = "Text Book [Name : Java Programming Author: John Doe ID:T01";
        assertEquals(expectedInfo, textBook.getInfo(), "The info should match the expected string.");
    }

    @Test
    public void testCategory() {
        assertEquals("Sách giáo trình", textBook.getCategory(), "The category should be 'Sách giáo trình'.");
    }
}
