package gui;

import javax.swing.*;
import java.awt.*;

public class mainUI extends JFrame {

    JFrame mainFrame;
    JPanel mainPanel;
    JButton login;
    JButton quit;
    JLabel welcome;

    public void init() {
        //搭建登陆界面
        mainFrame = new JFrame("学生成绩管理系统");
        mainFrame.setSize(600,400);
        mainFrame.setLayout(null);
        mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        mainFrame.setVisible(true);
        mainFrame.add(mainPanel);

        mainPanel.setBounds(0,0,600,400);
        mainPanel.setLayout(null);

        Font welFont = new Font("楷体",Font.BOLD,36);
        welcome.setFont(welFont);
        welcome.setBounds(90,100,500,80);

        Font buttonFont = new Font("黑体",Font.PLAIN,20);
        login = new JButton("登陆");
        login.setBounds(160,220,80,50);
        login.setFont(buttonFont);
        quit = new JButton("退出");
        quit.setBounds(300,200,80,50);
        quit.setFont(buttonFont);

        mainPanel.add(welcome);
        mainPanel.add(login);
        mainPanel.add(quit);
        mainPanel.setVisible(true);
    }

    public void close() {
        this.dispose();
    }

}
