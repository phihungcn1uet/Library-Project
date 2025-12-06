package Model;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 *
 * @author admin
 */
public class Loan {
    private int loanID;
    private String userId;
    private String bookId;
    private LocalDateTime borrowDate;
    private LocalDateTime returnDate;
    private int quantity;
    private int loanPeriod;
    private String status;

    // Constructor không tham số (dùng khi tạo đối tượng Loan mà chưa có dữ liệu)

    /**
     *
     */
    public Loan() {
    }

    /**
     *
     * @param loanID
     * @param userId
     * @param bookId
     * @param borrowDate
     * @param returnDate
     * @param quantity
     * @param loanPeriod
     */
    public Loan(int loanID, String userId, String bookId, LocalDateTime borrowDate, LocalDateTime returnDate, int quantity, int loanPeriod) {
        this.userId = userId;
        this.bookId = bookId;
        this.borrowDate = borrowDate;
        this.returnDate = returnDate;
        this.quantity = quantity;
        this.loanPeriod = loanPeriod;
        this.loanID = loanID;
    }

    /**
     *
     * @return
     */
    public int getLoanID() {
        return loanID;
    }

    /**
     *
     * @param loanID
     */
    public void setLoanID(int loanID) {
        this.loanID = loanID;
    }

    /**
     *
     * @return
     */
    public String getUserId() {
        return userId;
    }

    /**
     *
     * @param userId
     */
    public void setUserId(String userId) {
        this.userId = userId;
    }

    /**
     *
     * @return
     */
    public String getBookId() {
        return bookId;
    }

    /**
     *
     * @param bookId
     */
    public void setBookId(String bookId) {
        this.bookId = bookId;
    }

    /**
     *
     * @return
     */
    public LocalDateTime getBorrowDate() {
        return borrowDate;
    }

    /**
     *
     * @param borrowDate
     */
    public void setBorrowDate(LocalDateTime borrowDate) {
        this.borrowDate = borrowDate;
    }

    /**
     *
     * @return
     */
    public LocalDateTime getReturnDate() {
        return returnDate;
    }

    /**
     *
     * @param returnDate
     */
    public void setReturnDate(LocalDateTime returnDate) {
        this.returnDate = returnDate;
    }

    /**
     *
     * @return
     */
    public int getQuantity() {
        return quantity;
    }

    /**
     *
     * @param quantity
     */
    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    /**
     *
     * @return
     */
    public int getLoanPeriod() {
        return loanPeriod;
    }

    /**
     *
     * @param loanPeriod
     */
    public void setLoanPeriod(int loanPeriod) {
        this.loanPeriod = loanPeriod;
    }

    /**
     *
     * @return
     */
    public String getStatus() {
        return status;
    }

    /**
     *
     * @param status
     */
    public void setStatus(String status) {
        this.status = status;
    }

    // Định dạng LocalDateTime thành chuỗi

    /**
     *
     * @param dateTime
     * @return
     */
    public String formatDateTime(LocalDateTime dateTime) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        return dateTime.format(formatter);
    }

    /**
     *
     * @param dateTime
     * @return
     */
    public String formatDate(LocalDateTime dateTime) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        return dateTime.format(formatter);
    }
    
    
}
