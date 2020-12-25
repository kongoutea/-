package gui;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;

import model.*;
import database.*;

public class InputStudentUI extends JFrame implements ActionListener {
    //录入学生信息界面
    User newStudent;
    DbUtil dbUtil = new DbUtil();
    DbOperation inputStuOpt = new DbOperation();
    JFrame inputStuFrame;
    JPanel inputStuPanel;
    JButton confirm;
    JButton cancel;
    JTextField newStuText;
    JTextField newPwText;
    JLabel newStuLb;
    JLabel newPwLb;

    public InputStudentUI() {

        inputStuFrame = new JFrame("增加用户");
        inputStuFrame.setSize(400,300);

        inputStuPanel = new JPanel();
        inputStuPanel.setLayout(null);
        inputStuPanel.setBounds(0,0,400,300);
        inputStuPanel.setVisible(true);

        confirm = new JButton("确定");
        confirm.setBounds(100,150,80,50);
        confirm.addActionListener(this);
        cancel = new JButton("取消");
        cancel.setBounds(220,150,80,50);
        cancel.addActionListener(this);

        newStuText = new JTextField();
        newStuText.setBounds(180,40,150,30);
        newPwText = new JTextField();
        newPwText.setBounds(180,100,150,30);

        newStuLb = new JLabel("用户名");
        newStuLb.setBounds(40,40,60,30);
        newPwLb = new JLabel("密码");
        newPwLb.setBounds(40,100,60,30);

        inputStuPanel.add(confirm);
        inputStuPanel.add(cancel);
        inputStuPanel.add(newStuText);
        inputStuPanel.add(newStuLb);
        inputStuPanel.add(newPwLb);
        inputStuPanel.add(newPwText);

        inputStuFrame.add(inputStuPanel);
        inputStuFrame.setLayout(null);
        inputStuFrame.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        inputStuFrame.setLocationRelativeTo(null);
        inputStuFrame.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String buttonName = e.getActionCommand();
        if(buttonName.equals("确定")) {
            Connection con = null;
            try{
                con = dbUtil.getConnect();
                String userName = newStuText.getText();
                String userPw = newPwText.getText();
                User newUser = new User(userName, userPw, false);
                boolean success = inputStuOpt.inputStudent(con, newUser);
                if(success) {
                    JOptionPane.showMessageDialog(null,"添加成功！");
                    return ;
                }
                else {
                    JOptionPane.showMessageDialog(null,"添加失败，已存在该用户");
                    return ;
                }
            }catch(Exception exception) {
                exception.printStackTrace();
            }
        }
        else if(buttonName.equals("取消")) {
            inputStuFrame.dispose();
        }
    }
}
