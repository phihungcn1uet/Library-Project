package Model;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import java.util.Arrays;

public class BookTest {

    @Test
    public void testGetSetId() {
        Book book = new Book();
        book.setId("B001");
        assertEquals("B001", book.getId());
    }

    @Test
    public void testGetSetName() {
        Book book = new Book();
        book.setName("Effective Java");
        assertEquals("Effective Java", book.getName());
    }

    @Test
    public void testGetSetAuthor() {
        Book book = new Book();
        book.setAuthor("Joshua Bloch");
        assertEquals("Joshua Bloch", book.getAuthor());
    }

    @Test
    public void testGetSetCategory() {
        Book book = new Book();
        book.setCategory("Programming");
        assertEquals("Programming", book.getCategory());
    }

    @Test
    public void testGetSetQuantity() {
        Book book = new Book();
        book.setQuantity(10);
        assertEquals(10, book.getQuantity());
    }

    @Test
    public void testGetSetImage() {
        Book book = new Book();
        byte[] image = {1, 2, 3, 4};
        book.setImage(image);
        assertArrayEquals(image, book.getImage());
    }

    @Test
    public void testGetSetStars() {
        Book book = new Book();
        book.setStars(4.5f);
        assertEquals(4.5f, book.getStars());
    }

    @Test
    public void testGetInfo() {
        Book book = new Book();
        book.setId("B001");
        book.setName("Clean Code");
        book.setAuthor("Robert C. Martin");
        book.setCategory("Programming");
        book.setQuantity(5);
        book.setStars(4.8f);
        String expectedInfo = ""; // Điều chỉnh giá trị trả về của getInfo() nếu cần
        assertEquals(expectedInfo, book.getInfo());
    }

    @Test
    public void testDefaultConstructor() {
        Book book = new Book();
        assertNull(book.getId());
        assertNull(book.getName());
        assertNull(book.getAuthor());
        assertNull(book.getCategory());
        assertEquals(0, book.getQuantity());
        assertNull(book.getImage());
        assertEquals(0.0f, book.getStars());
    }
}
