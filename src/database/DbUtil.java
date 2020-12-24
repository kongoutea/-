package database;

import java.sql.*;

public class DbUtil {
    //连接数据库
    private String dbUrl = "jdbc:mysql://localhost:3306/Grade_User";
    private String dbUserName = "root";
    private String dbPassword = "myc82myc";
    private String jdbcName = "com.mysql.cj.jdbc.Driver";

    public Connection getConnect() throws Exception {
        Class.forName(jdbcName);
        Connection con = DriverManager.getConnection(dbUrl, dbUserName, dbPassword);
        System.out.println("连接成功");
        return con;
    }
    public void closeConnect(Connection con) throws Exception {
        if(con != null) {
            con.close();
        }
    }
}
