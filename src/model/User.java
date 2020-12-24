package model;

public class User {
    //用户实例
    private String uid;
    private String password;
    private boolean permission = false;


    public User(String userName, String userPassword, boolean permission) {
        this.uid = userName;
        this.password = userPassword;
        this.permission = permission;
    }


    //更改用户信息
    public void setUid(String newUid) {
        this.uid = newUid;
    }
    public void setPassword(String newPassword) {
        this.password = newPassword;
    }
    public void setPermission(boolean newPermit) {
        this.permission = newPermit;
    }
    //获取用户信息
    public String getUid() {
        return this.uid;
    }
    public String getPassword() {
        return this.password;
    }
    public boolean getPermission() {
        return this.permission;
    }
}
