package Database;

import Model.*;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author admin
 */
public class BookDAO {

    private static ConnectionDB cn = ConnectionDB.getInstance();

    /**
     *
     * @return
     */
    public static ArrayList<Book> getBookList() {
        ArrayList<Book> ds = new ArrayList<Book>();
        try {
            String sql = "select * from [Book]";

            ResultSet rs = cn.executeQuery(sql);
            while (rs.next()) {
                Book book = BookFactory.getBook(rs.getString(5).trim());
                book.setId(rs.getString(1).trim());
                book.setName(rs.getString(2).trim());
                book.setAuthor(rs.getString(3).trim());
                book.setQuantity(rs.getInt(4));
                book.setStars(rs.getFloat(6));
                book.setImage(rs.getBytes(7));
                ds.add(book);
            }
        } catch (Exception e) {
            System.out.println("Loi khong the lay du lieu BookList");
        }
        return ds;
    }

    /**
     *
     * @param book
     * @return
     */
    public static boolean addBook(Book book) {
        boolean result = false;

        // Giả sử book.getImage() trả về byte[] của hình ảnh
        byte[] imageBytes = book.getImage();

        // Chuyển đổi mảng byte thành chuỗi hex
        String bookImage = Function.convertToHex(imageBytes);

        // Gọi stored procedure InsertBook và thêm trường image vào câu truy vấn
        String sql = String.format("EXEC InsertBook N'%s', N'%s', %d, N'%s', 0x%s",
                book.getName(),
                book.getAuthor(),
                book.getQuantity(),
                book.getCategory(),
                bookImage);  // Thêm trường image đã chuyển thành chuỗi hex vào câu truy vấn

        try {
            // Thực thi câu truy vấn
            int n = cn.executeUpdate(sql);

            if (n > 0) {
                result = true; // Nếu thêm thành công, trả về true
            }
        } catch (Exception e) {
            System.out.println("Loi khi them sach: " + e.getMessage());
        }

        return result;
    }

    /**
     *
     * @param id
     * @return
     */
    public static boolean removeBook(String id) {
        boolean result = false;

        // Thay đổi câu truy vấn để xóa sách theo BookID
        String sql = "DELETE FROM [Book] WHERE BookID = '" + id + "'";

        // Thực thi câu truy vấn
        int n = cn.executeUpdate(sql);

        // Nếu một bản ghi bị xóa thành công, trả về true
        if (n == 1) {
            result = true;
        }
        return result;
    }

    /**
     *
     * @param book
     * @return
     */
    public static boolean repairBook(Book book) {
        boolean result = false;

        // Giả sử book.getImage() trả về byte[] của hình ảnh
        byte[] imageBytes = book.getImage();

        // Chuyển đổi mảng byte thành chuỗi hex
        String bookImage = Function.convertToHex(imageBytes);

        // Gọi stored procedure UpdateBook và thêm trường image vào câu truy vấn
        String sql;
        if (bookImage == null) {
            // Trường hợp image là null
            sql = String.format("UPDATE [Book] SET [name] = N'%s', author = N'%s', quantity = %d, category = N'%s', image = NULL WHERE BookID = '%s'",
                    book.getName(),
                    book.getAuthor(),
                    book.getQuantity(),
                    book.getCategory(),
                    book.getId());
        } else {
            // Trường hợp image không phải null
            sql = String.format("UPDATE [Book] SET [name] = N'%s', author = N'%s', quantity = %d, category = N'%s', image = 0x%s WHERE BookID = '%s'",
                    book.getName(),
                    book.getAuthor(),
                    book.getQuantity(),
                    book.getCategory(),
                    bookImage, // Thêm trường image đã chuyển thành chuỗi hex vào câu truy vấn
                    book.getId());
        }

        try {
            // Thực thi câu truy vấn
            int n = cn.executeUpdate(sql);

            // Nếu cập nhật thành công, trả về true
            if (n > 0) {
                result = true;
            }
        } catch (Exception e) {
            System.out.println("Loi khi cap nhat sach: " + e.getMessage());
        }

        return result;
    }

    /**
     *
     * @param sql
     * @return
     */
    public static int excuteSQL(String sql) {
        int i = 0;
        try {
            i = cn.executeUpdate(sql);
            System.out.println("Thanh cong");
        } catch (Exception e) {
            System.out.println("Khong thanh cong");
        }
        return i;
    }

    /**
     *
     * @param searchType
     * @param keyword
     * @return
     */
    public static ArrayList<Book> searchBookList(String searchType, String keyword) {
        ArrayList<Book> ds = new ArrayList<Book>();

        try {
            searchType = searchType.trim();
            String sql = null;
            if (searchType.equals("Theo tên sách")) {
                sql = "EXEC SearchBookByName @keywords = N'" + keyword + "'";
            } else if (searchType.equals("Theo mã sách")) {
                sql = "SELECT * FROM [Book] WHERE BookID = '" + keyword + "'";
            } else if (searchType.equals("Theo thể loại")) {
                sql = "EXEC SearchByCategory @keywords = N'" + keyword + "'";
            }
            // Thực thi câu truy vấn và lấy kết quả
            ResultSet rs = cn.executeQuery(sql);

            // Lặp qua kết quả trả về và thêm sách vào danh sách
            while (rs.next()) {
                Book book = BookFactory.getBook(rs.getString("category").trim());
                book.setId(rs.getString("BookID").trim()); // Thay thế bằng tên cột thực tế
                book.setName(rs.getString("name").trim());
                book.setAuthor(rs.getString("author").trim());
                book.setQuantity(rs.getInt("quantity")); // Giả sử quantity là kiểu int
                ds.add(book);
            }

        } catch (Exception e) {
            System.out.println("Loi khong the tim sach");
        }

        return ds;
    }

    /**
     *
     * @param bookId
     * @return
     */
    public static Book getBookById(String bookId) {
        Book book = null;  // Khởi tạo biến book là null

        // Câu lệnh SQL để lấy thông tin sách theo bookId
        String sql = "SELECT * FROM [Book] WHERE bookID = '" + bookId + "'";

        try {
            // Thực thi câu truy vấn
            ResultSet rs = cn.executeQuery(sql);

            // Nếu có kết quả
            if (rs.next()) {
                // Lấy dữ liệu từ ResultSet và tạo đối tượng Book
                String id = rs.getString("bookID");
                String name = rs.getString("name");
                String author = rs.getString("author");
                int quantity = rs.getInt("quantity");
                String category = rs.getString("category");
                float star = rs.getFloat("star");

                // Khởi tạo đối tượng Book
                book = BookFactory.getBook(category);
                book.setId(id);
                book.setName(name);
                book.setAuthor(author);
                book.setQuantity(quantity);
                book.setStars(star);
                book.setImage(rs.getBytes(7));
            }

            rs.close(); // Đóng ResultSet

        } catch (Exception e) {
            System.out.println("Loi khi lay sach theo bookId: " + e.getMessage());
        }
        return book; // Trả về đối tượng Book hoặc null nếu không tìm thấy
    }

    /**
     *
     * @param b
     * @param quantity
     */
    public static void borrowBook(Book b, int quantity) {
        // Câu lệnh UPDATE để giảm số lượng sách
        String updateQuantitySql = String.format("UPDATE [Book] SET quantity = quantity - %d WHERE bookID = '%s'", quantity, b.getId());

        try {

            // Thực thi câu lệnh UPDATE
            int n = cn.executeUpdate(updateQuantitySql);

            if (n > 0) {
                System.out.println("Cap nhat so luong sach thanh cong.");
            } else {
                System.out.println("Cap nhat so luong sach that bai.");
            }

        } catch (Exception e) {
            System.out.println("Loi khi muon sach: " + e.getMessage());
        }
    }

    /**
     *
     * @param b
     */
    public static void updateStar(Book b) {
        String sql = String.format(
                "UPDATE [Book] "
                + "SET star = (SELECT (SUM(star) + 5) / (COUNT(star) + 1.0) "
                + "FROM [Loan] WHERE bookID = '%s') "
                + "WHERE bookID = '%s'", b.getId(), b.getId());

        try {
            cn.executeUpdate(sql); // Thực thi lệnh SQL
            System.out.println("Cap nhat thanh cong so sao cho sach: " + b.getId());
        } catch (Exception e) {
            System.out.println("Loi khi cap nhat sao cho sach!");
            e.printStackTrace();
        }
    }

    /**
     *
     * @return
     */
    public static ArrayList<Book> getTopSixMostRated() {
        ArrayList<Book> topBooks = new ArrayList<Book>();

        // Câu lệnh SQL để lấy top 6 sách có số sao trung bình cao nhất
        String sql = "SELECT TOP 6 b.BookID "
                + "FROM [Book] b "
                + "ORDER BY b.star DESC";

        try {
            // Thực thi câu truy vấn và lấy kết quả
            ResultSet rs = cn.executeQuery(sql);

            // Lặp qua kết quả trả về và tạo đối tượng Book từ dữ liệu trong ResultSet
            while (rs.next()) {
                Book book = BookDAO.getBookById(rs.getString(1));
                topBooks.add(book);
            }
        } catch (Exception e) {
            System.out.println("Loi khi lay du lieu top6 book: " + e.getMessage());
        }

        return topBooks; // Trả về danh sách sách có số sao cao nhất
    }

    /**
     *
     * @return
     */
    public static Map calculateCategoryPercentage() {
        Map<String, Integer> mp = new HashMap<>();
        String sql = "SELECT category, COUNT(quantity) AS total "
                + "FROM [Book] "
                + "GROUP BY category "
                + "ORDER BY total DESC";
        try {
            // Thực thi câu truy vấn và lấy kết quả
            ResultSet rs = cn.executeQuery(sql);

            // Lặp qua kết quả trả về và tạo đối tượng Book từ dữ liệu trong ResultSet
            while (rs.next()) {
                mp.put(rs.getString(1), rs.getInt(2));
            }
        } catch (Exception e) {
            System.out.println("Loi khi lay du lieu top6 book: " + e.getMessage());
        }
        return mp;
    }
}
