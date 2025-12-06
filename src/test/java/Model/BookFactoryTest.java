package Model;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class BookFactoryTest {

    @Test
    public void testGetBookWithTextBookCategory() {
        Book book = BookFactory.getBook("Sách giáo trình");
        assertTrue(book instanceof TextBook, "The book should be of type TextBook");
    }

    @Test
    public void testGetBookWithHistoryBookCategory() {
        Book book = BookFactory.getBook("Sách Lịch Sử");
        assertTrue(book instanceof HistoryBook, "The book should be of type HistoryBook");
    }

    @Test
    public void testGetBookWithReferenceBookCategory() {
        Book book = BookFactory.getBook("Sách tham khảo");
        assertTrue(book instanceof ReferenceBook, "The book should be of type ReferenceBook");
    }

    @Test
    public void testGetBookWithStoryBookCategory() {
        Book book = BookFactory.getBook("Truyện");
        assertTrue(book instanceof StoryBook, "The book should be of type StoryBook");
    }

    @Test
    public void testGetBookWithLiteratureCategory() {
        Book book = BookFactory.getBook("Văn học");
        assertTrue(book instanceof Literature, "The book should be of type Literature");
    }

    @Test
    public void testGetBookWithInvalidCategory() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            BookFactory.getBook("Invalid Category");
        });
        assertEquals("Invalid book category: Invalid Category", exception.getMessage());
    }
}
