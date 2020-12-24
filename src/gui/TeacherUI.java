package gui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TeacherUI extends JFrame implements ActionListener {
    //管理员用户界面
    JFrame teacherFrame;
    JPanel teacherPanel;
    JLabel teacherWelcome;
    JButton studentInfo;
    JButton gradeInfo;
    JButton exit;

    public TeacherUI() {
        //管理员用户界面
        teacherFrame = new JFrame("学生成绩管理系统");
        teacherFrame.setSize(600,400);

        teacherPanel = new JPanel();
        teacherPanel.setVisible(true);
        teacherPanel.setLayout(null);
        teacherPanel.setBounds(0,0,600,400);

        Font welFont = new Font("楷体",Font.BOLD,32);
        teacherWelcome = new JLabel("欢迎您，管理员");
        teacherWelcome.setFont(welFont);
        teacherWelcome.setBounds(200,40,500,80);

        studentInfo = new JButton("学生信息");
        gradeInfo = new JButton("所有成绩");
        exit = new JButton("退出");
        studentInfo.setBounds(220,140,160,50);
        gradeInfo.setBounds(220,200,160,50);
        exit.setBounds(220,260,160,50);

        Font buttonFont = new Font("黑体",Font.PLAIN,20);
        studentInfo.setFont(buttonFont);
        gradeInfo.setFont(buttonFont);
        exit.setFont(buttonFont);

        teacherPanel.add(studentInfo);
        teacherPanel.add(gradeInfo);
        teacherPanel.add(exit);
        teacherPanel.add(teacherWelcome);

        teacherFrame.setLayout(null);
        teacherFrame.setDefaultCloseOperation(EXIT_ON_CLOSE);
        teacherFrame.setVisible(true);
        teacherFrame.add(teacherPanel);
        teacherFrame.setLocationRelativeTo(null);

        studentInfo.addActionListener(this);
        gradeInfo.addActionListener(this);
        exit.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String buttonName = e.getActionCommand();
        if(buttonName.equals("退出")) {
            System.exit(0);
        }
        else if(buttonName.equals("所有成绩")) {
            new showAllGrades();
        }
        else if(buttonName.equals("学生信息")) {
            new showAllStudents();
        }
    }
}
