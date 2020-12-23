package gui;

import actListen.userListener;
import javax.swing.*;
import java.awt.*;

public class StudentUI extends JFrame {
    //学生用户界面
    JFrame studentFrame;
    JPanel studentPanel;
    JLabel studentWelcome;
    JButton checkGrade;
    JButton changePassword;
    JButton exit;
    userListener studentListener;

    public StudentUI() {
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

        studentListener = new userListener();
        checkGrade.addActionListener(studentListener);
        changePassword.addActionListener(studentListener);
        exit.addActionListener(studentListener);

    }
}
