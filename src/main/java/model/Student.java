package model;

public class Student {
    private String studentID;
    private String studentName;
    private String Dob;
    private String sex;
    private String className;
    private String studentImage;

    private String checkAttendance;

    public Student() {
    }

    public Student(String studentID, String studentName, String dob, String sex, String className, String studentImage, String checkAttendance) {
        this.studentID = studentID;
        this.studentName = studentName;
        Dob = dob;
        this.sex = sex;
        this.className = className;
        this.studentImage = studentImage;
        this.checkAttendance = checkAttendance;
    }

    public String getStudentID() {
        return studentID;
    }

    public void setStudentID(String studentID) {
        this.studentID = studentID;
    }

    public String getStudentName() {
        return studentName;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

    public String getDob() {
        return Dob;
    }

    public void setDob(String dob) {
        Dob = dob;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getClassName() {
        return className;
    }

    public void setClassName(String className) {
        this.className = className;
    }

    public String getStudentImage() {
        return studentImage;
    }

    public void setStudentImage(String studentImage) {
        this.studentImage = studentImage;
    }

    public String getCheckAttendance() {
        return checkAttendance;
    }

    public void setCheckAttendance(String checkAttendance) {
        this.checkAttendance = checkAttendance;
    }

    @Override
    public String toString() {
        return String.format("| %-12s | %-17s |", studentID, studentName);

    }
}
