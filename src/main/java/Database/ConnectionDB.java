package Database;

import java.sql.*;

/**
 *
 * @author admin
 */
public class ConnectionDB {
    private static ConnectionDB instance;
    private Connection cn;

    
    private ConnectionDB() {    
        try {
            String url = "jdbc:sqlserver://localhost:1433;databaseName=library;encrypt=false;trustServerCertificate=true";
            String user = "sa";
            String pass = "Hung7a159753@";

            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");

            cn = DriverManager.getConnection(url, user, pass);

            System.out.println("Ket noi CSDL thanh cong");
        } catch (Exception e) {
            System.err.println(">> LỖI KẾT NỐI CSDL:");
            e.printStackTrace();
        }
    }
    
    /**
     *
     * @return
     */
    public static ConnectionDB getInstance() {
        if (instance == null) {
            instance = new ConnectionDB();
        }
        return instance;
    }
    
    /**
     *
     * @return
     */
    public Connection getCn() {
        return cn;
    }

    /**
     *
     */
    public void close(){
        try {
            this.cn.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    /**
     *
     * @param sql
     * @return
     */
    public ResultSet executeQuery(String sql){
        ResultSet rs = null;
        try {
            Statement stm = cn.createStatement();
            rs = stm.executeQuery(sql);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return rs;
    }
    
    /**
     *
     * @param sql
     * @return
     */
    public int executeUpdate(String sql){
        int i = -1;
        try {
            Statement stm = cn.createStatement();
            i = stm.executeUpdate(sql);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return i;
    }
}
