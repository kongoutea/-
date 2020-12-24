package database;

import model.*;

import javax.xml.transform.Result;
import java.sql.*;

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

    public String[][] showGrade(Connection con, String userName) throws Exception {
        //查询成绩
        String sql = "select * from grade where userId = '"+userName+"'";
        PreparedStatement stmt = con.prepareStatement(sql, ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_READ_ONLY);
        ResultSet result = stmt.executeQuery();

        String[][] record;
        result.last();
        int count = result.getRow();
        int i = 0;
        record = new String[count][3];
        result.beforeFirst();
        while(result.next()) {
            for(int j = 0; j < 3; j++) {
                record[i][j] = result.getString(j+1);
            }
            i++;
        }
        return record;
    }

    public boolean changePw(Connection con, String userId, String newPw) throws Exception {
        //修改密码
        String sql = "update user set pw = '"+newPw+"' where uid = '"+userId+"'";
        PreparedStatement stmt = con.prepareStatement(sql);
        int result = stmt.executeUpdate(sql);
        if(result > 0) {
            return true;
        }
        else{
            return false;
        }
    }
    public String[][] showAllStudent(Connection con) throws Exception {
        //获取所有学生信息
        String sql = "select * from user where permission = 0";
        PreparedStatement stmt = con.prepareStatement(sql, ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_READ_ONLY);
        ResultSet result = stmt.executeQuery();

        String[][] record;
        result.last();
        int count = result.getRow();
        int i = 0;
        record = new String[count][2];
        result.beforeFirst();
        while(result.next()) {
            for(int j = 0; j < 2; j++) {
                record[i][j] = result.getString(j+1);
            }
            i++;
        }
        return record;
    }

    public String[][] showAllGrade(Connection con) throws Exception {
        //查询所有成绩
        String sql = "select * from grade";
        PreparedStatement stmt = con.prepareStatement(sql, ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_READ_ONLY);
        ResultSet result = stmt.executeQuery();

        String[][] record;
        result.last();
        int count = result.getRow();
        int i = 0;
        record = new String[count][3];
        result.beforeFirst();
        while(result.next()) {
            for(int j = 0; j < 3; j++) {
                record[i][j] = result.getString(j+1);
            }
            i++;
        }
        return record;
    }

    public boolean inputGrade(Connection con, Course course) throws SQLException {
        //录入成绩
        String sql = "insert into grade values ('"+course.getStudentId()+"','"+course.getCourseId()+"','"+course.getCourseGrade()+"')";
        PreparedStatement stmt = con.prepareStatement(sql);
        int result = stmt.executeUpdate();
        if(result > 0) {
            return true;
        }
        else {
            return false;
        }
    }
}
