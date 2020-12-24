package database;

import model.User;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DbOperation {
    //数据库操作
    public User login(Connection con, User user) throws Exception {
        //登录验证
        String sql = "select * from user where uid = ? and pw = ?";
        PreparedStatement stmt = con.prepareStatement(sql);
        stmt.setString(1,user.getUid());
        stmt.setString(2,user.getPassword());
        ResultSet result = stmt.executeQuery();
        if(result.next()) {
            String resultUid = result.getString("uid");
            String resultPassword = result.getString("pw");
            boolean resultPermission = result.getBoolean("permission");
            User resultUser = new User(resultUid, resultPassword, resultPermission);
            return resultUser;
        }
        return null;
    }

    public void showGrade(Connection con, User user) throws Exception {
        //查询成绩

    }

    public boolean changePw(Connection con, User user, String newPw) throws Exception {
        //修改密码
        String sql = "update user set pw = ? where uid = ?";
        PreparedStatement stmt = con.prepareStatement(sql);
        stmt.setString(1,user.getUid());
        stmt.setString(2,newPw);
        ResultSet result = stmt.executeQuery();
        if(result.next()) {
            return true;
        }
        return false;
    }
    public void showAllStudent(Connection con, User users[]) throws Exception {
        //获取所有学生信息
        String sql = "select * from user where permission = 0";
        PreparedStatement stmt = con.prepareStatement(sql);
        ResultSet result = stmt.executeQuery();
        int i = 0;
        while(result.next()) {
            String resultUid = result.getString("uid");
            String resultPassword = result.getString("pw");

        }
    }

    public void showAllGrade(Connection con) throws Exception {
        //查询所有成绩

    }
}
