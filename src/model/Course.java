package model;

public class Course {
    //课程实例
    String courseName;
    int courseGrade;

    //获取课程信息
    public String getCourseName() {
        return courseName;
    }
    public int getCourseGrade() {
        return courseGrade;
    }

    //设置课程信息
    public void setCourseName(String newCoursename) {
        this.courseName = newCoursename;
    }
    public void setCourseGrade(int newCourseGrade) {
        this.courseGrade = newCourseGrade;
    }
}
