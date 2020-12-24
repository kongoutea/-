package gui;

import model.User;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class StudentUI extends JFrame implements ActionListener {
    //学生用户界面
    JFrame studentFrame;
    JPanel studentPanel;
    JLabel studentWelcome;
    JButton checkGrade;
    JButton changePassword;
    JButton exit;

    String studentID;
    String studentPassword;

    public StudentUI(User student) {
        //学生用户的界面
        studentID = student.getUid();
        studentPassword = student.getPassword();

        studentFrame = new JFrame("学生成绩管理系统");
        studentFrame.setSize(600,400);

        studentPanel = new JPanel();
        studentPanel.setVisible(true);
        studentPanel.setLayout(null);
        studentPanel.setBounds(0,0,600,400);

        Font welFont = new Font("楷体",Font.BOLD,32);
        studentWelcome = new JLabel("欢迎您，学生");
        studentWelcome.setFont(welFont);
        studentWelcome.setBounds(200,40,500,80);

        checkGrade = new JButton("查询成绩");
        changePassword = new JButton("修改密码");
        exit = new JButton("退出");
        checkGrade.setBounds(220,140,160,50);
        changePassword.setBounds(220,200,160,50);
        exit.setBounds(220,260,160,50);

        Font buttonFont = new Font("黑体",Font.PLAIN,20);
        checkGrade.setFont(buttonFont);
        changePassword.setFont(buttonFont);
        exit.setFont(buttonFont);

        studentPanel.add(checkGrade);
        studentPanel.add(changePassword);
        studentPanel.add(exit);
        studentPanel.add(studentWelcome);

        studentFrame.setLayout(null);
        studentFrame.setDefaultCloseOperation(EXIT_ON_CLOSE);
        studentFrame.setVisible(true);
        studentFrame.add(studentPanel);
        studentFrame.setLocationRelativeTo(null);

        checkGrade.addActionListener(this);
        changePassword.addActionListener(this);
        exit.addActionListener(this);

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        //按钮的事件监听
        String buttonName = e.getActionCommand();
        if(buttonName.equals("退出")) {
            System.exit(0);
        }
        else if(buttonName.equals("查询成绩")) {

        }
        else if(buttonName.equals("修改密码")) {
            new ChangePasswordUI();
        }
    }
}
