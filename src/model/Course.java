package model;

public class Course {
    //课程实例
    String studentId;
    String courseId;
    int courseGrade;

    public Course(String student, String course, int grade) {
        studentId = student;
        courseId = course;
        courseGrade = grade;
    }
    //获取课程信息
    public String getStudentId() {
        return studentId;
    }
    public String getCourseId() {
        return courseId;
    }
    public int getCourseGrade() {
        return courseGrade;
    }

    //设置课程信息
    public void setStudentId(String newStudentId) {
        this.studentId = newStudentId;
    }
    public void setCourseId(String newCourseId) {
        this.courseId = newCourseId;
    }
    public void setCourseGrade(int newCourseGrade) {
        this.courseGrade = newCourseGrade;
    }
}
