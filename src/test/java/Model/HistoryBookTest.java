package Model;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class HistoryBookTest {

    @Test
    public void testConstructorWithoutParameters() {
        HistoryBook book = new HistoryBook();

        // Kiểm tra thuộc tính category mặc định
        assertEquals("Sách Lịch Sử", book.getCategory(), "Category should be 'Sách Lịch Sử' by default");

        // Kiểm tra các thuộc tính ban đầu
        assertNull(book.getId(), "ID should be null initially");
        assertNull(book.getName(), "Name should be null initially");
        assertNull(book.getAuthor(), "Author should be null initially");
        assertEquals(0, book.getQuantity(), "Quantity should be 0 initially");
    }

    @Test
    public void testConstructorWithParameters() {
        HistoryBook book = new HistoryBook("B001", "Lịch sử Việt Nam", "Nguyễn Văn A", 5);

        // Kiểm tra các thuộc tính đã được thiết lập đúng
        assertEquals("B001", book.getId(), "ID should be 'B001'");
        assertEquals("Lịch sử Việt Nam", book.getName(), "Name should be 'Lịch sử Việt Nam'");
        assertEquals("Nguyễn Văn A", book.getAuthor(), "Author should be 'Nguyễn Văn A'");
        assertEquals(5, book.getQuantity(), "Quantity should be 5");
        assertEquals("Sách Lịch Sử", book.getCategory(), "Category should be 'Sách Lịch Sử'");
    }

    @Test
    public void testGetInfo() {
        HistoryBook book = new HistoryBook("B001", "Lịch sử Việt Nam", "Nguyễn Văn A", 5);

        // Kiểm tra phương thức getInfo()
        String expectedInfo = "History Book [Name : Lịch sử Việt Nam Author: Nguyễn Văn A ID:B001";
        assertEquals(expectedInfo, book.getInfo(), "The information string should match the expected format");
    }
}
