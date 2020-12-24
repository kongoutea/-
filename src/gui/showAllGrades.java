package gui;

import database.DbOperation;
import database.DbUtil;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;

public class showAllGrades extends JFrame implements ActionListener {

    JScrollPane jsp;
    JPanel gradePanel;
    JFrame gradeFrame;
    JTable resultTable;
    JButton exit;
    JButton refresh;
    JButton input;
    String[][] record;
    String[] tableHead = {"学号","课程名","成绩"};
    DbOperation showAllGradeOpt = new DbOperation();
    DbUtil dbUtil = new DbUtil();

    public showAllGrades() {
        //搭建查分界面


        gradeFrame = new JFrame("查询课程得分");
        gradeFrame.setSize(500,300);

        Connection con = null;
        try{
            con = dbUtil.getConnect();
            record = showAllGradeOpt.showAllGrade(con);
        }catch(Exception exception){
            exception.printStackTrace();
        }
        resultTable = new JTable(record, tableHead);
        jsp = new JScrollPane();
        jsp.setViewportView(resultTable);
        jsp.setVisible(true);
        jsp.setSize(400,300);

        exit = new JButton("退出");
        exit.setBounds(410,200,60,40);
        refresh = new JButton("刷新");
        refresh.setBounds(410,140,60,40);
        input = new JButton("录入");
        input.setBounds(410,80,60,40);
        exit.addActionListener(this);
        refresh.addActionListener(this);
        input.addActionListener(this);

        gradePanel = new JPanel();
        gradePanel.setLayout(null);
        gradePanel.setBounds(0,0,500,300);
        gradePanel.setVisible(true);

        gradePanel.add(jsp);
        gradeFrame.add(gradePanel);

        gradePanel.add(exit);
        gradePanel.add(refresh);
        gradePanel.add(input);
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
        else if(buttonName.equals("刷新")) {
            gradeFrame.dispose();
            new showAllGrades();
        }
        else if(buttonName.equals("录入")) {
            new InputGradeUI();
        }
    }
}
