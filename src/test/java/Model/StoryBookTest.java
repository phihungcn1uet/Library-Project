package Model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class StoryBookTest {

    private StoryBook storyBook;

    @BeforeEach
    public void setUp() {
        // Initialize a StoryBook object for testing
        storyBook = new StoryBook("S01", "The Adventure of Sherlock Holmes", "Arthur Conan Doyle", 20);
    }

    @Test
    public void testConstructor() {
        assertNotNull(storyBook, "StoryBook object should be instantiated.");
        assertEquals("S01", storyBook.getId(), "The ID should be 'S01'.");
        assertEquals("The Adventure of Sherlock Holmes", storyBook.getName(), "The name should be 'The Adventure of Sherlock Holmes'.");
        assertEquals("Arthur Conan Doyle", storyBook.getAuthor(), "The author should be 'Arthur Conan Doyle'.");
        assertEquals(20, storyBook.getQuantity(), "The quantity should be 20.");
        assertEquals("Truyện", storyBook.getCategory(), "The category should be 'Truyện'.");
    }

    @Test
    public void testSettersAndGetters() {
        storyBook.setId("S02");
        storyBook.setName("The Great Gatsby");
        storyBook.setAuthor("F. Scott Fitzgerald");
        storyBook.setQuantity(15);

        assertEquals("S02", storyBook.getId(), "The ID should be 'S02'.");
        assertEquals("The Great Gatsby", storyBook.getName(), "The name should be 'The Great Gatsby'.");
        assertEquals("F. Scott Fitzgerald", storyBook.getAuthor(), "The author should be 'F. Scott Fitzgerald'.");
        assertEquals(15, storyBook.getQuantity(), "The quantity should be 15.");
    }

    @Test
    public void testGetInfo() {
        String expectedInfo = "Story Book [Name : The Adventure of Sherlock Holmes Author: Arthur Conan Doyle ID:S01";
        assertEquals(expectedInfo, storyBook.getInfo(), "The info should match the expected string.");
    }

    @Test
    public void testCategory() {
        assertEquals("Truyện", storyBook.getCategory(), "The category should be 'Truyện'.");
    }
}
