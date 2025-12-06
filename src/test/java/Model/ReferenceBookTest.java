package Model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class ReferenceBookTest {

    private ReferenceBook referenceBook;

    @BeforeEach
    public void setUp() {
        // Initialize a ReferenceBook object for testing
        referenceBook = new ReferenceBook("R01", "Java Programming", "James Smith", 10);
    }

    @Test
    public void testConstructor() {
        assertNotNull(referenceBook, "ReferenceBook object should be instantiated.");
        assertEquals("R01", referenceBook.getId(), "The ID should be 'R01'.");
        assertEquals("Java Programming", referenceBook.getName(), "The name should be 'Java Programming'.");
        assertEquals("James Smith", referenceBook.getAuthor(), "The author should be 'James Smith'.");
        assertEquals(10, referenceBook.getQuantity(), "The quantity should be 10.");
        assertEquals("Sách tham khảo", referenceBook.getCategory(), "The category should be 'Sách tham khảo'.");
    }

    @Test
    public void testSettersAndGetters() {
        referenceBook.setId("R02");
        referenceBook.setName("Advanced Java");
        referenceBook.setAuthor("John Doe");
        referenceBook.setQuantity(15);

        assertEquals("R02", referenceBook.getId(), "The ID should be 'R02'.");
        assertEquals("Advanced Java", referenceBook.getName(), "The name should be 'Advanced Java'.");
        assertEquals("John Doe", referenceBook.getAuthor(), "The author should be 'John Doe'.");
        assertEquals(15, referenceBook.getQuantity(), "The quantity should be 15.");
    }

    @Test
    public void testGetInfo() {
        String expectedInfo = "Reference Book [Name : Java Programming Author: James Smith ID:R01";
        assertEquals(expectedInfo, referenceBook.getInfo(), "The info should match the expected string.");
    }

    @Test
    public void testCategory() {
        assertEquals("Sách tham khảo", referenceBook.getCategory(), "The category should be 'Sách tham khảo'.");
    }
}
