package gui;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;

import database.*;

public class showGrades extends JFrame implements ActionListener{
    //显示所有课程成绩
    String userName;

    JScrollPane jsp;
    JPanel gradePanel;
    JFrame gradeFrame;
    JTable resultTable;
    JButton exit;
    String[][] record;
    String[] tableHead = {"学号","课程名","成绩"};
    DbOperation showGradeOpt = new DbOperation();
    DbUtil dbUtil = new DbUtil();

    public showGrades(String name) {
        //搭建查分界面
        userName = name;

        gradeFrame = new JFrame("查询课程得分");
        gradeFrame.setSize(500,300);

        Connection con = null;
        try{
            con = dbUtil.getConnect();
            record = showGradeOpt.showGrade(con, userName);
        }catch(Exception exception){
            exception.printStackTrace();
        }
        resultTable = new JTable(record, tableHead);
        jsp = new JScrollPane();
        jsp.setViewportView(resultTable);
        jsp.setVisible(true);
        jsp.setSize(400,300);

        exit = new JButton("退出");
        exit.setBounds(410,120,60,40);
        exit.addActionListener(this);

        gradePanel = new JPanel();
        gradePanel.setLayout(null);
        gradePanel.setBounds(0,0,500,300);
        gradePanel.setVisible(true);

        gradePanel.add(jsp);
        gradeFrame.add(gradePanel);

        gradePanel.add(exit);
        gradeFrame.setLayout(null);
        gradeFrame.setVisible(true);
        gradeFrame.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        gradeFrame.setLocationRelativeTo(null);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String buttonName = e.getActionCommand();
        if(buttonName.equals("退出")) {
            gradeFrame.dispose();
        }
    }
}
