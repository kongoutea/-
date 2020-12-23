package gui;

import javax.swing.*;
import java.awt.*;
import actListen.loginListener;

public class mainUI extends JFrame {

    JFrame mainFrame;
    JPanel mainPanel;
    JButton login;
    JButton quit;
    JLabel welcome;
    JLabel Name;
    JLabel Password;
    JTextField userName;
    JPasswordField userPassword;
    loginListener loginCheck;

    public mainUI() {
        //搭建登陆界面
        mainFrame = new JFrame("学生成绩管理系统");
        mainFrame.setSize(600,400);


        mainPanel = new JPanel();
        mainPanel.setVisible(true);
        mainPanel.setBounds(0,0,600,400);
        mainPanel.setLayout(null);


        Font welFont = new Font("楷体",Font.BOLD,36);
        welcome = new JLabel("欢迎使用学生成绩管理系统！");
        welcome.setFont(welFont);
        welcome.setBounds(55,40,500,80);

        Font loginFont = new Font("黑体",Font.PLAIN,18);
        Name = new JLabel("用户名");
        Name.setBounds(100,140,80,30);
        Name.setFont(loginFont);
        Password = new JLabel("密  码");
        Password.setBounds(100,200,80,30);
        Password.setFont(loginFont);

        userName = new JTextField();
        userPassword = new JPasswordField();
        userName.setBounds(180,140,300,30);
        userPassword.setBounds(180,200,300,30);

        Font buttonFont = new Font("黑体",Font.PLAIN,20);
        login = new JButton("登陆");
        login.setBounds(160,280,80,50);
        login.setFont(buttonFont);
        quit = new JButton("退出");
        quit.setBounds(360,280,80,50);
        quit.setFont(buttonFont);

        mainPanel.add(welcome);
        mainPanel.add(login);
        mainPanel.add(quit);
        mainPanel.add(Name);
        mainPanel.add(userName);
        mainPanel.add(Password);
        mainPanel.add(userPassword);

        mainFrame.setLayout(null);
        mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        mainFrame.setVisible(true);
        mainFrame.add(mainPanel);
        //为按钮添加监听器
        loginCheck = new loginListener(userName,userPassword);
        login.addActionListener(loginCheck);
        quit.addActionListener(loginCheck);
    }

}
