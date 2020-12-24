package gui;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;

import database.*;

public class ChangePasswordUI extends JFrame implements ActionListener {
    //用户修改密码
    String userID;
    String userPw;

    JFrame pwFrame;
    JPanel pwPanel;
    JButton Confirm;
    JButton Cancel;
    JTextField newPw;
    JPasswordField confirmPw;
    JLabel new_pw_label;
    JLabel confirm_pw_label;
    DbOperation changePwOpt = new DbOperation();
    DbUtil dbUtil = new DbUtil();

    public ChangePasswordUI(String id, String password) {
        userID = id;
        userPw = password;

        pwFrame = new JFrame("修改密码");
        pwFrame.setSize(400,250);

        pwPanel = new JPanel();
        pwPanel.setVisible(true);
        pwPanel.setLayout(null);
        pwPanel.setBounds(0,0,400,250);

        new_pw_label = new JLabel("新密码");
        confirm_pw_label = new JLabel("确认新密码");
        new_pw_label.setBounds(40,40,60,30);
        confirm_pw_label.setBounds(40,100,100,30);

        newPw = new JTextField();
        confirmPw = new JPasswordField();
        newPw.setBounds(180,40,150,30);
        confirmPw.setBounds(180,100,150,30);

        Confirm = new JButton("确认");
        Cancel = new JButton("取消");
        Confirm.setBounds(100,150,80,50);
        Cancel.setBounds(220,150,80,50);

        pwPanel.add(new_pw_label);
        pwPanel.add(newPw);
        pwPanel.add(confirm_pw_label);
        pwPanel.add(confirmPw);
        pwPanel.add(Confirm);
        pwPanel.add(Cancel);

        pwFrame.setLayout(null);
        pwFrame.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        pwFrame.add(pwPanel);
        pwFrame.setVisible(true);
        pwFrame.setLocationRelativeTo(null);

        Confirm.addActionListener(this);
        Cancel.addActionListener(this);
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        String buttonName = e.getActionCommand();
        if(buttonName.equals("取消")) {
            pwFrame.dispose();
        }
        else if(buttonName.equals("确认")) {
            String newPassword = newPw.getText();
            String cf_Pw = String.valueOf(confirmPw.getPassword());
            System.out.println(newPassword+" "+cf_Pw+" "+userPw);
            if(newPassword.equals(cf_Pw) && !newPassword.equals(userPw)) {
                Connection con = null;
                try {
                    con = dbUtil.getConnect();
                    boolean success = changePwOpt.changePw(con, userID, newPassword);
                    if(success) {
                        JOptionPane.showMessageDialog(null,"密码修改成功！");
                        pwFrame.dispose();
                    }
                    else{
                        JOptionPane.showMessageDialog(null,"密码修改失败，请联系管理员");
                        return ;
                    }
                } catch (Exception exception) {
                    exception.printStackTrace();
                }
            }
            else {
                JOptionPane.showMessageDialog(null,"密码不一致或与原密码相同！");
                return ;
            }
        }
    }
}
