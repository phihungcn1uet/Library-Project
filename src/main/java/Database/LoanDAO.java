package Database;

import Model.*;
import Model.Loan;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author admin
 */
public class LoanDAO {

    private static ConnectionDB cn = ConnectionDB.getInstance();

    /**
     *
     * @return
     */
    public static ArrayList<Loan> getLoanList() {
        ArrayList<Loan> loans = new ArrayList<>();
        try {
            String sql = "SELECT LoanID FROM [Loan]";
            ResultSet rs = cn.executeQuery(sql);
            while (rs.next()) {
                Loan l = LoanDAO.getLoan(rs.getInt(1));
                loans.add(l);
            }
            rs.close();
        } catch (Exception e) {
            System.out.println("Lỗi không thể lấy dữ liệu: " + e.getMessage());
        }
        return loans;
    }

    /**
     *
     * @param LoanID
     * @return
     */
    public static Loan getLoan(int LoanID) {
        Loan t = new Loan();
        try {
            String sql = "SELECT * FROM [Loan] WHERE loanID = '" + LoanID + "'";
            ResultSet rs = cn.executeQuery(sql);
            while (rs.next()) {
                t.setLoanID(rs.getInt("loanID"));
                t.setUserId(rs.getString("userID"));
                t.setBookId(rs.getString("bookID"));
                t.setBorrowDate(rs.getTimestamp("borrowDate").toLocalDateTime());

                java.sql.Timestamp returnTimestamp = rs.getTimestamp("returnDate");
                if (returnTimestamp != null) {
                    t.setReturnDate(returnTimestamp.toLocalDateTime());
                }

                t.setQuantity(rs.getInt("Quantity"));
                t.setLoanPeriod(rs.getInt("loanPeriod"));
                t.setStatus(rs.getString("status"));
            }
            rs.close();
        } catch (Exception e) {
            System.out.println("Lỗi không thể lấy dữ liệu: " + e.getMessage());
        }
        return t;
    }

    /**
     *
     * @param loan
     * @return
     */
    public static boolean addLoan(Loan loan) {
        boolean kq = false;
        String s = "Đang mượn";

        // Câu lệnh để thiết lập định dạng ngày
        String dateFormatSql = "SET DATEFORMAT ymd";

        // Chuyển LocalDateTime thành Timestamp với giây làm tròn
        java.time.LocalDateTime borrowDateTime = loan.getBorrowDate();
        java.time.LocalDateTime roundedDateTime = borrowDateTime.withNano(0); // Bỏ phần nano giây để có số giây nguyên
        java.sql.Timestamp borrowDate = java.sql.Timestamp.valueOf(roundedDateTime);

        // Câu lệnh SQL sử dụng PreparedStatement để tránh lỗi định dạng
        String sql = "INSERT INTO [Loan] (userID, bookID, borrowDate, returnDate, Quantity, loanPeriod, status) "
                + "VALUES (?, ?, ?, NULL, ?, ?, ?)";

        try {
            // Thực thi câu lệnh để thiết lập định dạng ngày
            cn.executeUpdate(dateFormatSql);

            // Sử dụng PreparedStatement để tránh lỗi chuyển đổi
            java.sql.PreparedStatement pst = cn.getCn().prepareStatement(sql);
            pst.setString(1, loan.getUserId());
            pst.setString(2, loan.getBookId());
            pst.setTimestamp(3, borrowDate);  // Truyền Timestamp với giây làm tròn vào
            pst.setInt(4, loan.getQuantity());
            pst.setInt(5, loan.getLoanPeriod());
            pst.setString(6, s);
            // Thực thi câu truy vấn INSERT
            int n = pst.executeUpdate();

            if (n > 0) {
                kq = true; // Nếu thêm thành công, trả về true
            }

            pst.close(); // Đảm bảo đóng PreparedStatement
        } catch (Exception e) {
            System.out.println("Lỗi khi thêm khoản vay: " + e.getMessage());
        }

        return kq; // Trả về kết quả
    }

    /**
     *
     * @param userId
     * @return
     */
    public static ArrayList<Loan> BookBorrowingList(String userId) {
        ArrayList<Loan> loans = new ArrayList<>();
        String sql = "SELECT loanID FROM [Loan] WHERE userID = '" + userId + "' AND returnDate IS NULL";

        try {
            // Thực thi câu truy vấn để lấy danh sách bookID
            ResultSet rs = cn.executeQuery(sql);

            // Duyệt qua các bookID và lấy thông tin sách
            while (rs.next()) {
                int loanID = rs.getInt("loanID");

                // lấy thông tin sách theo bookID
                Loan loan = LoanDAO.getLoan(loanID);
                if (loan != null) {
                    loans.add(loan);
                }
            }

            rs.close(); // Đóng ResultSet
        } catch (Exception e) {
            System.out.println("Lỗi khi lấy danh sách sách đang mượn: " + e.getMessage());
        }

        return loans; // Trả về danh sách sách
    }

    /**
     *
     * @param userId
     * @return
     */
    public static ArrayList<Loan> BookBorrowedList(String userId) {
        ArrayList<Loan> loans = new ArrayList<>();
        String sql = "SELECT loanID FROM [Loan] WHERE userID = '" + userId + "' AND returnDate IS NOT NULL";
        try {
            // Thực thi câu truy vấn để lấy danh sách bookID
            ResultSet rs = cn.executeQuery(sql);

            // Duyệt qua các bookID và lấy thông tin sách
            while (rs.next()) {
                int loanID = rs.getInt("loanID");

                // lấy thông tin sách theo bookID
                Loan loan = LoanDAO.getLoan(loanID);
                if (loan != null) {
                    loans.add(loan);
                }
            }

            rs.close(); // Đóng ResultSet
        } catch (Exception e) {
            System.out.println("Lỗi khi lấy danh sách sách đang mượn: " + e.getMessage());
        }

        return loans; // Trả về danh sách sách
    }

    /**
     *
     * @param userID
     * @return
     */
    public static ArrayList<Loan> getLoanList(String userID) {
        ArrayList<Loan> ds = new ArrayList<>();
        try {
            String sql = "SELECT * FROM [Loan] WHERE userID = '" + userID + "'";
            ResultSet rs = cn.executeQuery(sql);
            while (rs.next()) {
                Loan t = new Loan();
                t.setLoanID(rs.getInt("loanID"));
                t.setUserId(rs.getString("userID"));
                t.setBookId(rs.getString("bookID"));
                t.setBorrowDate(rs.getTimestamp("borrowDate").toLocalDateTime());

                java.sql.Timestamp returnTimestamp = rs.getTimestamp("returnDate");
                if (returnTimestamp != null) {
                    t.setReturnDate(returnTimestamp.toLocalDateTime());
                }

                t.setQuantity(rs.getInt("Quantity"));
                t.setLoanPeriod(rs.getInt("loanPeriod"));
                t.setStatus(rs.getString("status"));
                ds.add(t);
            }
            rs.close();
        } catch (Exception e) {
            System.out.println("Lỗi không thể lấy dữ liệu: " + e.getMessage());
        }
        return ds;
    }

    /**
     *
     * @param loan
     * @return
     */
    public static boolean returnBook(Loan loan) {
        boolean kq = false;
        // Chuyển LocalDateTime thành Timestamp với giây làm tròn
        java.time.LocalDateTime returnDateTime = loan.getReturnDate();
        java.time.LocalDateTime roundedDateTime = returnDateTime.withNano(0); // Bỏ phần nano giây để có số giây nguyên
        java.sql.Timestamp returnDate = java.sql.Timestamp.valueOf(roundedDateTime);

        try {
            String sql = "UPDATE [Loan] SET returnDate = '" + returnDate + "', status = N'Đã trả' WHERE loanID = " + loan.getLoanID();
            int n = cn.executeUpdate(sql);

            if (n == 1) {
                kq = true;
            }
        } catch (Exception e) {
            System.out.println("Lỗi trả sách từ database.");
        }

        return kq;
    }

    /**
     *
     * @param loanID
     * @param star
     */
    public static void rateBook(int loanID, float star) {
        String sql = "UPDATE [Loan] SET star = " + star + " WHERE loanID = " + loanID;

        try {
            cn.executeUpdate(sql);
        } catch (Exception e) {
            System.out.println("Lỗi đánh giá sách !");
        }
    }

    /**
     *
     * @param bookID
     * @return
     */
    public static ArrayList<User> borrowingUserList(String bookID) {
        ArrayList<User> users = new ArrayList<>();
        try {
            String sql = "SELECT DISTINCT userID FROM [Loan] WHERE bookID = '" + bookID + "' AND returnDate IS NULL";
            ResultSet rs = cn.executeQuery(sql);
            while (rs.next()) {
                User user = UserDAO.getUserByID(rs.getString(1));
                users.add(user);
            }
        } catch (Exception e) {
            System.out.println("Loi lay danh sach nguoi dang muon sach");
        }
        return users;
    }

    /**
     *
     * @param userID
     * @return
     */
    public static ArrayList<Loan> borrowingBookListByUser(String userID) {
        ArrayList<Loan> loans = new ArrayList<>();
        try {
            String sql = "SELECT loanID FROM [Loan] WHERE userID = '" + userID + "' AND returnDate IS NULL";
            ResultSet rs = cn.executeQuery(sql);
            while (rs.next()) {
                Loan loan = LoanDAO.getLoan(rs.getInt(1));
                loans.add(loan);
            }
        } catch (Exception e) {
            System.out.println("Loi lay danh sach nguoi dang muon sach");
        }
        return loans;
    }

    /**
     *
     * @param loanID
     * @return
     */
    public static boolean restoreBookByAdmin(int loanID) {
        boolean kq = false;

        // Chuyển LocalDateTime thành Timestamp với giây làm tròn
        java.time.LocalDateTime currentDateTime = java.time.LocalDateTime.now();
        java.time.LocalDateTime roundedDateTime = currentDateTime.plusNanos(500_000_000).withNano(0); // Làm tròn giây
        java.sql.Timestamp returnDate = java.sql.Timestamp.valueOf(roundedDateTime);

        try {
            String sql = "UPDATE [Loan] SET returnDate = '" + returnDate + "', status = N'Đã thu hồi' WHERE loanId = " + loanID;
            int n = cn.executeUpdate(sql);
            Loan loan = LoanDAO.getLoan(loanID);
            Book book = BookDAO.getBookById(loan.getBookId());
            BookDAO.borrowBook(book, -loan.getQuantity());

            if (n == 1) {
                kq = true;
            }
        } catch (Exception e) {
            System.out.println("Lỗi thu hồi sách: " + e.getMessage());
        }

        return kq;
    }
    
    /**
     *
     * @return
     */
    public static Map calculateHowManyUserBorrowThisBookPercentage() {
         Map<String, Integer> mp = new HashMap<>();
         String sql = "SELECT TOP 15 l.bookId, COUNT(*) AS total, b.name " +
              "FROM [Loan] l " +
              "JOIN [Book] b ON l.bookId = b.bookId " +  
              "GROUP BY l.bookId, b.name " +
              "ORDER BY total DESC";

        try {
            // Thực thi câu truy vấn và lấy kết quả
            ResultSet rs = cn.executeQuery(sql);
            // Lặp qua kết quả trả về và tạo đối tượng Book từ dữ liệu trong ResultSet
            while (rs.next()) {
                mp.put(rs.getString(3),rs.getInt(2));
            }
        } catch (SQLException e) {
            System.out.println("Loi khi lay du lieu HowManyUserBorrowThisBook: " + e.getMessage());
        }
        return mp;
    }
    
    /**
     *
     * @param loanID
     * @param message
     */
    public static void updateMessageBox(int loanID, String message) {
        try {
            // Nối thêm nội dung vào cột messageBox, thêm ký tự xuống dòng
            String sql = "UPDATE [Loan] SET message = N'" + message + "' WHERE loanID = " + loanID;
            cn.executeUpdate(sql);
        } catch (Exception e) {
            System.out.println("Lỗi update message! " + e.getMessage());
        }
    }
    
    /**
     *
     * @return
     */
    public static Map calculateEachUserBorrowHowManyBookPercentage() {
         Map<String, Integer> mp = new HashMap<>();
         String sql = "SELECT TOP 10 l.userId, COUNT(l.bookId) AS total, u.userName " +
              "FROM [Loan] l " +
              "JOIN [User] u ON l.userId = u.userId " +  
              "GROUP BY l.userId, u.userName " +
              "ORDER BY total DESC";

        try {
            // Thực thi câu truy vấn và lấy kết quả
            ResultSet rs = cn.executeQuery(sql);

            // Lặp qua kết quả trả về và tạo đối tượng Book từ dữ liệu trong ResultSet
            while (rs.next()) {
                mp.put(rs.getString(3),rs.getInt(2));
            }
        } catch (SQLException e) {
            System.out.println("Loi khi lay EachUserBorrowHowManyBook: " + e.getMessage());
        }
        return mp;
    }
}
