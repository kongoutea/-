package actListen;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class loginListener implements ActionListener {
    //登陆验证操作
    JTextField userName;
    JPasswordField userPassword;
    public loginListener(JTextField userNameText, JPasswordField userPasswordText) {
        userName = userNameText;
        userPassword = userPasswordText;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String buttonName = e.getActionCommand();
        if(buttonName.equals("退出")) {
            System.exit(0);
        }
        else if(buttonName.equals("登陆")) {
            System.out.println(userName.getText());
        }
    }
}
