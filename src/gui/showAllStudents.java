package gui;

import database.DbOperation;
import database.DbUtil;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;

public class showAllStudents extends JFrame implements ActionListener {
    //显示所有学生的信息
    JScrollPane jsp;
    JPanel stuInfoPanel;
    JFrame stuInfoFrame;
    JTable resultTable;
    JButton exit;
    JButton refresh;
    JButton input;
    String[][] record;
    String[] tableHead = {"学号","密码"};
    DbOperation showAllGradeOpt = new DbOperation();
    DbUtil dbUtil = new DbUtil();

    public showAllStudents() {

        stuInfoFrame = new JFrame("查询课程得分");
        stuInfoFrame.setSize(500,300);

        Connection con = null;
        try{
            con = dbUtil.getConnect();
            record = showAllGradeOpt.showAllStudent(con);
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

        stuInfoPanel = new JPanel();
        stuInfoPanel.setLayout(null);
        stuInfoPanel.setBounds(0,0,500,300);
        stuInfoPanel.setVisible(true);

        stuInfoPanel.add(jsp);
        stuInfoFrame.add(stuInfoPanel);

        stuInfoPanel.add(exit);
        stuInfoPanel.add(refresh);
        stuInfoPanel.add(input);
        stuInfoFrame.setLayout(null);
        stuInfoFrame.setVisible(true);
        stuInfoFrame.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        stuInfoFrame.setLocationRelativeTo(null);
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        String buttonName = e.getActionCommand();
        if(buttonName.equals("退出")) {
            stuInfoFrame.dispose();
        }
        else if(buttonName.equals("刷新")) {
            stuInfoFrame.dispose();
            new showAllStudents();
        }
        else if(buttonName.equals("录入")) {
            new InputStudentUI();
        }
    }
}
