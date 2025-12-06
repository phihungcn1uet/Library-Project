package Database;

import Model.User;
import java.sql.ResultSet;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import Model.Function;
import java.sql.SQLException;

/**
 *
 * @author admin
 */
public class UserDAO {

    private static final ConnectionDB cn = Database.ConnectionDB.getInstance();

    /**
     *
     * @return
     */
    public static ArrayList<String> getUserNameList() {
        ArrayList<String> ds = new ArrayList<>();
        try {
            String sql = "select userName from [User] where role = 0";

            ResultSet rs = cn.executeQuery(sql);
            while (rs.next()) {
                ds.add(rs.getString(1).trim());
            }
        } catch (SQLException e) {
            System.out.println("Loi khong the lay danh sach ten user");
            System.out.println(e.getMessage());
        }
        return ds;
    }

    /**
     *
     * @return
     */
    public static ArrayList<String> getAccountNameList() {
        ArrayList<String> ds = new ArrayList<>();
        try {
            String sql = "select accountName from [User] where role = 0";

            ResultSet rs = cn.executeQuery(sql);
            while (rs.next()) {
                ds.add(rs.getString(1).trim());
            }
        } catch (SQLException e) {
            System.out.println("Loi khong the lay ten dang nhap");
        }
        return ds;
    }

    /**
     *
     * @param userName
     * @return
     */
    public static String getIdUser(String userName) {
        String str = "";
        try {
            String sql = "select userId from [User] where ten_User = N'" + userName.trim() + "' AND role = 0";

            ResultSet rs = cn.executeQuery(sql);
            while (rs.next()) {
                str = rs.getString(1);
            }
        } catch (SQLException e) {
            System.out.println("Loi khong the lay id User");
        }
        return str;
    }

    /**
     *
     * @return
     */
    public static ArrayList<User> getUserList() {
        ArrayList<User> ds = new ArrayList<>();

        try {
            String sql = "SELECT * FROM [User] where role = 0";

            ResultSet rs = cn.executeQuery(sql);
            while (rs.next()) {
                User user = new User();
                user.setIdUser(rs.getString(1).trim());
                user.setUserName(rs.getString(2).trim());

                // Sử dụng LocalDate để loại bỏ múi giờ
                LocalDate birthday = rs.getObject(3, LocalDate.class);
                if (birthday != null) {
                    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
                    user.setBirthday(birthday.format(formatter)); // Định dạng LocalDate thành chuỗi
                } else {
                    user.setBirthday(null);
                }

                user.setAddress(rs.getString(4).trim());
                user.setPhoneNumber(rs.getString(5).trim());
                user.setIdentityNumber(rs.getString(6).trim());
                user.setSex(rs.getString(7).trim());
                user.setAccountName(rs.getString(8).trim());
                user.setPassword(rs.getString(9).trim());
                user.setRole(rs.getInt(10));
                user.setPrestige(rs.getInt(11));
                user.setImage(rs.getBytes(12));
                ds.add(user);
            }
        } catch (SQLException e) {
            System.out.println("Loi khong the get UserList: " + e.getMessage());
        }
        return ds;
    }

    /**
     *
     * @param user
     * @return
     */
    public static boolean addUser(User user) {
        boolean result = false;
        byte[] imageBytes = user.getImage();

        // Chuyển đổi mảng byte thành chuỗi hex
        String userImage = Function.convertToHex(imageBytes);
        String sql1 = "";
        if (userImage != null) {
            sql1 = String.format("set dateformat dmy EXEC Add_User N'%s', '%s', N'%s', N'%s', '%s', N'%s', '%s', '%s', %d, 0x%s",
                    user.getUserName(),
                    user.getBirthday(),
                    user.getAddress(),
                    user.getPhoneNumber(),
                    user.getIdentityNumber(),
                    user.getSex(),
                    user.getAccountName(),
                    user.getPassword(),
                    0,
                    userImage);
        } else {
            sql1 = String.format("set dateformat dmy EXEC Add_User N'%s', '%s', N'%s', N'%s', '%s', N'%s', '%s', '%s', %d, null",
                    user.getUserName(),
                    user.getBirthday(),
                    user.getAddress(),
                    user.getPhoneNumber(),
                    user.getIdentityNumber(),
                    user.getSex(),
                    user.getAccountName(),
                    user.getPassword(),
                    0);
        }
        int n = cn.executeUpdate(sql1);
        if (n == 1) {
            result = true;
        }
        return result;
    }

    /**
     *
     * @param id
     * @return
     */
    public static boolean deleteUser(String id) {
        boolean result = false;
        String sql = "delete from [User] where userId = '" + id + "'";

        int n = cn.executeUpdate(sql);
        if (n == 1) {
            result = true;
        }
        return result;
    }

    /**
     *
     * @param user
     * @return
     */
    public static boolean repairUser(User user) {
        boolean result = false;

        // Lệnh để cài đặt định dạng ngày
        String dateFormatSql = "SET DATEFORMAT dmy";

        byte[] imageBytes = user.getImage();

        // Chuyển đổi mảng byte thành chuỗi hex
        String userImage = Function.convertToHex(imageBytes);
        String updateSql = "";
        // Lệnh update
        if (userImage == null) {
            updateSql = String.format("UPDATE [User] SET userName = N'%s', birthday = '%s', location = N'%s', phoneNumber = '%s', identityNumber = '%s', sex = N'%s' WHERE userId = '%s'",
                    user.getUserName(),
                    user.getBirthday(),
                    user.getAddress(),
                    user.getPhoneNumber(),
                    user.getIdentityNumber(),
                    user.getSex(),
                    user.getIdUser());
        } else {
            updateSql = String.format("UPDATE [User] SET userName = N'%s', birthday = '%s', location = N'%s', phoneNumber = '%s', identityNumber = '%s', sex = N'%s', image = 0x%s WHERE userId = '%s'",
                    user.getUserName(),
                    user.getBirthday(),
                    user.getAddress(),
                    user.getPhoneNumber(),
                    user.getIdentityNumber(),
                    user.getSex(),
                    userImage,
                    user.getIdUser());
        }
        // Thực thi lệnh cài đặt định dạng ngày trước
        cn.executeUpdate(dateFormatSql);

        // Thực thi lệnh update
        int n = cn.executeUpdate(updateSql);
        if (n == 1) {
            result = true;
        }

        return result;
    }

    /**
     *
     * @param id
     * @return
     */
    public static User getUserByID(String id) {
        User user = new User();
        String sql = "SELECT * FROM [User] WHERE userId = '" + id + "'";
        try {
            // Nếu có kết quả
            try ( // Thực thi câu truy vấn
                    ResultSet rs = cn.executeQuery(sql)) {
                // Nếu có kết quả
                if (rs.next()) {
                    user.setIdUser(rs.getString(1).trim());
                    user.setUserName(rs.getString(2).trim());

                    // Sử dụng LocalDate để loại bỏ múi giờ
                    LocalDate birthday = rs.getObject(3, LocalDate.class);
                    if (birthday != null) {
                        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
                        user.setBirthday(birthday.format(formatter)); // Định dạng LocalDate thành chuỗi
                    } else {
                        user.setBirthday(null);
                    }

                    user.setAddress(rs.getString(4).trim());
                    user.setPhoneNumber(rs.getString(5).trim());
                    user.setIdentityNumber(rs.getString(6).trim());
                    user.setSex(rs.getString(7).trim());
                    user.setAccountName(rs.getString(8).trim());
                    user.setPassword(rs.getString(9).trim());
                    user.setRole(rs.getInt(10));
                    user.setPrestige(rs.getInt(11));
                    user.setImage(rs.getBytes(12));
                }
                // Đóng ResultSet
            }

        } catch (SQLException e) {
            System.out.println("Loi khi lay sach theo bookId: " + e.getMessage());
        }
        return user; // Trả về đối tượng Book hoặc null nếu không tìm thấy
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
            System.out.println("excuteSQL Thanh cong");

        } catch (Exception e) {
            System.out.println("excuteSQL Khong thanh cong");

        }
        return i;
    }

    /**
     *
     * @param searchType
     * @param keyword
     * @return
     */
    public static ArrayList<User> searchUserList(String searchType, String keyword) {
        ArrayList<User> ds = new ArrayList<>();
        try {
            // Gọi stored procedure với tham số đầu vào là từ khóa
            String sql = null;
            if ("Theo tên".equals(searchType)) {
                sql = "EXEC SearchByName @keywords = N'" + keyword + "'";
            } else if ("Theo mã".equals(searchType)) {
                sql = "SELECT userId FROM [User] WHERE userId = '" + keyword + "'";
            }

            ResultSet rs = cn.executeQuery(sql);
            while (rs.next()) {
                User user = UserDAO.getUserByID(rs.getString(1));
                ds.add(user);
            }
        } catch (SQLException e) {
            System.out.println("Loi khong the tim kiem User: " + e.getMessage());
        }
        return ds;
    }

    /**
     *
     * @param userId
     * @return
     */
    public static int CheckBookOverDue(String userId) {
        int overdueCount = 0;
        try {
            // Gọi stored procedure với tham số đầu vào và đầu ra
            String sql = "{CALL CheckBookOverdue(?, ?)}";
            java.sql.CallableStatement cstmt = cn.getCn().prepareCall(sql);

            // Thiết lập tham số đầu vào và đầu ra
            cstmt.setString(1, userId); // userId là tham số đầu vào
            cstmt.registerOutParameter(2, java.sql.Types.INTEGER); // Số sách quá hạn là tham số đầu ra

            // Thực thi stored procedure
            cstmt.execute();

            // Lấy số sách quá hạn từ tham số đầu ra
            overdueCount = cstmt.getInt(2);

            // In thông báo thành công
            System.out.println("Kiểm tra sách quá hạn thành công. Số sách quá hạn: " + overdueCount);
        } catch (Exception e) {
            System.out.println("Lỗi kiểm tra sách quá hạn: " + e.getMessage());
        }
        return overdueCount;
    }

    /**
     *
     * @param userId
     * @return
     */
    public static String getMessageBox(String userId) {
        StringBuilder message = new StringBuilder("Thông báo\n");
        String sql = "SELECT CONVERT(VARCHAR(10), returnDate, 120) AS returnDate, message "
                + "FROM [Loan] WHERE userId = ? AND status = N'Đã thu hồi' ORDER BY returnDate";

        try (java.sql.PreparedStatement ps = cn.getCn().prepareStatement(sql)) {
            ps.setString(1, userId); // Truyền tham số an toàn
            try (ResultSet rs = ps.executeQuery()) {
                String currentDate = "";
                while (rs.next()) {
                    String returnDate = rs.getString("returnDate");
                    String msg = rs.getString("message");

                    // Nếu ngày thay đổi, thêm tiêu đề ngày mới
                    if (!returnDate.equals(currentDate)) {
                        currentDate = returnDate;
                        message.append("Thông báo ngày ").append(currentDate).append("\n");
                    }

                    // Thêm thông báo
                    message.append(msg).append("\n");
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
            return "Có lỗi xảy ra khi lấy thông báo.";
        }
        return message.toString();
    }

}
