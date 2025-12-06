package Model;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import java.time.LocalDateTime;

class LoanTest {

    @Test
    void testGettersAndSetters() {
        // Khởi tạo dữ liệu mẫu
        Loan loan = new Loan();
        loan.setLoanID(1);
        loan.setUserId("U123");
        loan.setBookId("B456");
        loan.setBorrowDate(LocalDateTime.of(2024, 12, 1, 14, 30));
        loan.setReturnDate(LocalDateTime.of(2024, 12, 15, 14, 30));
        loan.setQuantity(2);
        loan.setLoanPeriod(14);
        loan.setStatus("Pending");

        // Kiểm tra giá trị qua getter
        assertEquals(1, loan.getLoanID());
        assertEquals("U123", loan.getUserId());
        assertEquals("B456", loan.getBookId());
        assertEquals(LocalDateTime.of(2024, 12, 1, 14, 30), loan.getBorrowDate());
        assertEquals(LocalDateTime.of(2024, 12, 15, 14, 30), loan.getReturnDate());
        assertEquals(2, loan.getQuantity());
        assertEquals(14, loan.getLoanPeriod());
        assertEquals("Pending", loan.getStatus());
    }

    @Test
    void testFormatDateTime() {
        // Tạo đối tượng Loan và thiết lập giá trị ngày giờ
        Loan loan = new Loan();
        LocalDateTime dateTime = LocalDateTime.of(2024, 12, 1, 14, 30);
        String formattedDateTime = loan.formatDateTime(dateTime);

        // Kiểm tra định dạng chuỗi
        assertEquals("2024-12-01 14:30:00", formattedDateTime);
    }

    @Test
    void testFormatDate() {
        // Tạo đối tượng Loan và thiết lập giá trị ngày giờ
        Loan loan = new Loan();
        LocalDateTime dateTime = LocalDateTime.of(2024, 12, 1, 14, 30);
        String formattedDate = loan.formatDate(dateTime);

        // Kiểm tra định dạng chuỗi
        assertEquals("01/12/2024", formattedDate);
    }

    @Test
    void testConstructor() {
        // Khởi tạo Loan bằng constructor có tham số
        Loan loan = new Loan(
                1, 
                "U123", 
                "B456", 
                LocalDateTime.of(2024, 12, 1, 14, 30), 
                LocalDateTime.of(2024, 12, 15, 14, 30), 
                2, 
                14
        );

        // Kiểm tra giá trị được khởi tạo
        assertEquals(1, loan.getLoanID());
        assertEquals("U123", loan.getUserId());
        assertEquals("B456", loan.getBookId());
        assertEquals(LocalDateTime.of(2024, 12, 1, 14, 30), loan.getBorrowDate());
        assertEquals(LocalDateTime.of(2024, 12, 15, 14, 30), loan.getReturnDate());
        assertEquals(2, loan.getQuantity());
        assertEquals(14, loan.getLoanPeriod());
    }
}