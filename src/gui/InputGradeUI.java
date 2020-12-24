package gui;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;

import model.*;
import database.*;

import static java.lang.Integer.parseInt;

public class InputGradeUI extends JFrame implements ActionListener {
    //录入成绩界面
    Course newGrade;
    DbUtil dbUtil = new DbUtil();
    DbOperation inputOpt = new DbOperation();

    JFrame inputFrame;
    JPanel inputPanel;
    JButton confirm;
    JButton cancel;
    JTextField stuIdText;
    JTextField courIdText;
    JTextField gradeText;
    JLabel stu;
    JLabel cour;
    JLabel gra;

    public InputGradeUI() {

        inputFrame = new JFrame("录入成绩");
        inputFrame.setSize(400,300);

        inputPanel = new JPanel();
        inputPanel.setLayout(null);
        inputPanel.setBounds(0,0,400,300);
        inputPanel.setVisible(true);

        confirm = new JButton("确定");
        confirm.setBounds(100,200,80,50);
        cancel = new JButton("取消");
        cancel.setBounds(220,200,80,50);
        confirm.addActionListener(this);
        cancel.addActionListener(this);

        stu = new JLabel("学号");
        stu.setBounds(40,40,60,30);
        cour = new JLabel("课程名");
        cour.setBounds(40,90,60,30);
        gra = new JLabel("成绩");
        gra.setBounds(40,140,60,30);

        stuIdText = new JTextField();
        stuIdText.setBounds(180,40,150,30);
        courIdText = new JTextField();
        courIdText.setBounds(180,90,150,30);
        gradeText = new JTextField();
        gradeText.setBounds(180,140,150,30);

        inputPanel.add(confirm);
        inputPanel.add(cancel);
        inputPanel.add(stu);
        inputPanel.add(cour);
        inputPanel.add(gra);
        inputPanel.add(stuIdText);
        inputPanel.add(courIdText);
        inputPanel.add(gradeText);

        inputFrame.add(inputPanel);
        inputFrame.setLayout(null);
        inputFrame.setLocationRelativeTo(null);
        inputFrame.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        inputFrame.setVisible(true);
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        String buttonName = e.getActionCommand();
        if(buttonName.equals("取消")) {
            inputFrame.dispose();
        }
        else if(buttonName.equals("确定")) {
            String courseId = courIdText.getText();
            String studentId = stuIdText.getText();
            int Grade = parseInt(gradeText.getText());
            newGrade = new Course(studentId, courseId, Grade);
            Connection con = null;
            try{
                con = dbUtil.getConnect();
                boolean success = inputOpt.inputGrade(con, newGrade);
                if(success) {
                    JOptionPane.showMessageDialog(null,"录入成功！");
                    inputFrame.dispose();
                }
                else{
                    JOptionPane.showMessageDialog(null,"录入失败，请联系管理员");
                    return ;
                }
            }catch(Exception exception){
                exception.printStackTrace();
            }
        }
    }
}
