package Model;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

/**
 *
 * @author admin
 */
public class Function {

    // Convert to hex string
    /**
     *
     * @param bytes
     * @return
     */
    public static String convertToHex(byte[] bytes) {
        if (bytes == null) {
            return null;
        }
        StringBuilder hexString = new StringBuilder();
        for (byte b : bytes) {
            hexString.append(String.format("%02X", b)); // Chuyển từng byte thành hex
        }
        return hexString.toString();
    }

    /**
     *
     * @param height
     * @param width
     * @param bytes
     * @return
     */
    public static ImageIcon loadUserImage(int height, int width, byte[] bytes) {
        Image image;

        // Kiểm tra nếu mảng byte rỗng hoặc null
        if (bytes == null || bytes.length == 0) {
            // Lấy ảnh mặc định từ đường dẫn /Icon/avatar1.png
            image = new ImageIcon(Function.class.getResource("/Icon/user.png")).getImage();
        } else {
            // Tạo ảnh từ mảng byte
            image = new ImageIcon(bytes).getImage();
        }

        // Thay đổi kích thước ảnh theo tham số height và width
        Image resizedImage = image.getScaledInstance(width, height, java.awt.Image.SCALE_SMOOTH);

        // Trả về ImageIcon mới từ ảnh đã thay đổi kích thước
        return new ImageIcon(resizedImage);
    }

    /**
     *
     * @param height
     * @param width
     * @param bytes
     * @return
     */
    public static ImageIcon loadBookImage(int height, int width, byte[] bytes) {
        Image image;

        // Kiểm tra nếu mảng byte rỗng hoặc null
        if (bytes == null || bytes.length == 0) {
            // Lấy ảnh mặc định từ đường dẫn /Icon/avatar1.png
            image = new ImageIcon(Function.class.getResource("/Icon/bookRepresent.png")).getImage();
        } else {
            // Tạo ảnh từ mảng byte
            image = new ImageIcon(bytes).getImage();
        }

        // Thay đổi kích thước ảnh theo tham số height và width
        Image resizedImage = image.getScaledInstance(width, height, java.awt.Image.SCALE_SMOOTH);

        // Trả về ImageIcon mới từ ảnh đã thay đổi kích thước
        return new ImageIcon(resizedImage);
    }

    public static boolean checkDate(String dateStr) {
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        sdf.setLenient(false);

        // Kiểm tra định dạng cơ bản
        if (dateStr == null || !dateStr.matches("\\d{2}/\\d{2}/\\d{4}")) {
            JOptionPane.showMessageDialog(null,
                    "Định dạng ngày không hợp lệ! Vui lòng nhập theo định dạng dd/MM/yyyy.",
                    "Lỗi nhập liệu", JOptionPane.ERROR_MESSAGE);
            return false;
        }

        String[] dateParts = dateStr.split("/");
        int day, month, year;

        try {
            // Tách các phần ngày, tháng, năm
            day = Integer.parseInt(dateParts[0]);
            month = Integer.parseInt(dateParts[1]);
            year = Integer.parseInt(dateParts[2]);

            // Kiểm tra giá trị ngày, tháng, năm
            if (year < 1000 || year > 9999) {
                JOptionPane.showMessageDialog(null,
                        "Năm không hợp lệ! Năm phải nằm trong khoảng 1000-9999.",
                        "Lỗi nhập liệu", JOptionPane.ERROR_MESSAGE);
                return false;
            }

            if (month < 1 || month > 12) {
                JOptionPane.showMessageDialog(null,
                        "Tháng không hợp lệ! Tháng phải nằm trong khoảng 1-12.",
                        "Lỗi nhập liệu", JOptionPane.ERROR_MESSAGE);
                return false;
            }

            if (day < 1 || day > 31) {
                JOptionPane.showMessageDialog(null,
                        "Ngày không hợp lệ! Ngày phải nằm trong khoảng 1-31.",
                        "Lỗi nhập liệu", JOptionPane.ERROR_MESSAGE);
                return false;
            }

            // Kiểm tra tính hợp lệ của ngày với tháng và năm
            Date date = sdf.parse(dateStr); // Sẽ ném lỗi nếu ngày không hợp lệ
            return true;

        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null,
                    "Ngày, tháng, hoặc năm không phải số nguyên! Vui lòng kiểm tra lại.",
                    "Lỗi nhập liệu", JOptionPane.ERROR_MESSAGE);
            return false;
        } catch (ParseException e) {
            JOptionPane.showMessageDialog(null,
                    "Ngày không hợp lệ! Vui lòng kiểm tra lại giá trị ngày.",
                    "Lỗi nhập liệu", JOptionPane.ERROR_MESSAGE);
            return false;
        }
    }

    public static boolean checkPhoneNumber(String phoneNumber) {

        if (phoneNumber.matches(".*[a-zA-Z].*")) {
            JOptionPane.showMessageDialog(null, "Số điện thoại không chứa ký tự");
            return false;
        } else if (phoneNumber.length() != 10) {
            JOptionPane.showMessageDialog(null, "Số điện thoại phải đủ 10 số");
            return false;
        }
        return true;
    }
}
