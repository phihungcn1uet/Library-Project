package Model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class LiteratureTest {

    private Literature literature;

    @BeforeEach
    public void setUp() {
        // Initialize a Literature object for testing
        literature = new Literature("L01", "The Great Novel", "John Doe", 5);
    }

    @Test
    public void testConstructor() {
        assertNotNull(literature, "Literature object should be instantiated.");
        assertEquals("L01", literature.getId(), "The ID should be 'L01'.");
        assertEquals("The Great Novel", literature.getName(), "The name should be 'The Great Novel'.");
        assertEquals("John Doe", literature.getAuthor(), "The author should be 'John Doe'.");
        assertEquals(5, literature.getQuantity(), "The quantity should be 5.");
        assertEquals("Văn học", literature.getCategory(), "The category should be 'Văn học'.");
    }

    @Test
    public void testSettersAndGetters() {
        literature.setId("L02");
        literature.setName("Another Novel");
        literature.setAuthor("Jane Smith");
        literature.setQuantity(10);

        assertEquals("L02", literature.getId(), "The ID should be 'L02'.");
        assertEquals("Another Novel", literature.getName(), "The name should be 'Another Novel'.");
        assertEquals("Jane Smith", literature.getAuthor(), "The author should be 'Jane Smith'.");
        assertEquals(10, literature.getQuantity(), "The quantity should be 10.");
    }

    @Test
    public void testGetInfo() {
        String expectedInfo = "Literature [Name : The Great Novel Author: John Doe ID:L01";
        assertEquals(expectedInfo, literature.getInfo(), "The info should match the expected string.");
    }

    @Test
    public void testCategory() {
        assertEquals("Văn học", literature.getCategory(), "The category should be 'Văn học'.");
    }
}
