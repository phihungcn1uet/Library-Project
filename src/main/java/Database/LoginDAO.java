/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Database;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author admin
 */
public class LoginDAO {

    private static final ConnectionDB cn = ConnectionDB.getInstance();

    /**
     *
     * @param user
     * @return
     */
    public static String getPassword(String user) {
        String password = "";
        try {
            String sql = "select password from [User] where accountName = '" + user.trim() + "'";

            ResultSet rs = cn.executeQuery(sql);
            while (rs.next()) {
                password = rs.getString(1);
            }

        } catch (SQLException e) {
            System.out.println("Loi khong the lay du lieu password");
        }
        return password;
    }

    /**
     *
     * @param user
     * @return
     */
    public static String getAccountName(String user) {
        String accountName = "";
        try {
            String sql = "select accountName from [User] where accountName = '" + user.trim() + "'";

            ResultSet rs = cn.executeQuery(sql);
            while (rs.next()) {
                accountName = rs.getString(1);
            }

        } catch (SQLException e) {
            System.out.println("Loi khong the lay du lieu accountname");
        }
        return accountName;
    }

    /**
     *
     * @param user
     * @return
     */
    public static String getId(String user) {
        String accountName = "";
        try {
            String sql = "select userId from [User] where accountName = '" + user.trim() + "'";

            ResultSet rs = cn.executeQuery(sql);
            while (rs.next()) {
                accountName = rs.getString(1);
            }

        } catch (SQLException e) {
            System.out.println("Loi khong the lay du lieu id");
        }
        return accountName;
    }

    /**
     *
     * @param user
     * @return
     */
    public static int getRole(String user) {
        int a = 0;
        try {
            String sql = "select role from [User] where accountName = '" + user.trim() + "'";

            ResultSet rs = cn.executeQuery(sql);
            while (rs.next()) {
                a = Integer.parseInt(rs.getString(1));
            }

        } catch (NumberFormatException | SQLException e) {
            System.out.println("Loi khong the lay du lieu role");
        }
        return a;
    }

    /**
     *
     * @param user
     * @return
     */
    public static int getPrestige(String user) {
        int a = 0;
        try {
            String sql = "select prestige from [User] where accountName = '" + user.trim() + "'";

            ResultSet rs = cn.executeQuery(sql);
            while (rs.next()) {
                a = Integer.parseInt(rs.getString(1));
            }

        } catch (NumberFormatException | SQLException e) {
            System.out.println("Loi khong the lay du lieu uy tin");
        }
        return a;
    }

    /**
     *
     * @param user
     * @return
     */
    public static String getFullname(String user) {
        String accountName = "";
        try {
            String sql = "select userName from [User] where accountName = '" + user.trim() + "'";

            ResultSet rs = cn.executeQuery(sql);
            while (rs.next()) {
                accountName = rs.getString(1).trim();
            }

        } catch (SQLException e) {
            System.out.println("Loi khong the lay du lieu fullname");
        }
        return accountName;
    }

    /**
     *
     * @param user
     * @return
     */
    public static byte[] getFileimage(String user) {
        byte[] imageBytes = null;
        try {
            String sql = "select image from [User] where accountName = '" + user.trim() + "'";

            ResultSet rs = cn.executeQuery(sql);
            while (rs.next()) {
                imageBytes = rs.getBytes(1);
            }

        } catch (SQLException e) {
            System.out.println("Loi khong the lay du lieu image");
        }
        return imageBytes;
    }

    /**
     *
     * @param id
     * @return
     */
    public static String getPasswordFromID(String id) {
        String password = "";
        try {
            String sql = "select password from [User] where userId = '" + id.trim() + "'";

            ResultSet rs = cn.executeQuery(sql);
            while (rs.next()) {
                password = rs.getString(1);
            }

        } catch (SQLException e) {
            System.out.println("Loi khong the lay du lieu getPasswordFromID");
        }
        return password;
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
}
