package dao;

import database.DBConnection;
import model.Student;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;



public class StudentDAO implements DAOInterface<Student>{
    @Override
    public int update(Student student) throws SQLException {
        return 0;
    }

    public static StudentDAO getInstance(){
        return new StudentDAO();
    }

    @Override
    public int insert(Student student) throws SQLException {
        Connection con = DBConnection.getConnect();
        Statement st = con.createStatement();
        String sql = "insert into student(studentId, StudentName, checkAttendace)" +
                "Values (" + student.getStudentID() + ", " + student.getStudentName() + ", 0)";
        int kq = st.executeUpdate(sql);

        System.out.println("ban đã thục thi: " + sql);
        System.out.println("có" + kq + "dong bi thay doi");
        return 0;
    }
    public int update() throws SQLException {
        Connection con = DBConnection.getConnect();
        Statement st = con.createStatement();
        String sql = "update student set checkAttendance = " + 0;
        int kq = st.executeUpdate(sql);

        System.out.println("ban đã thục thi: " + sql);
        System.out.println("có" + kq + "dong bi thay doi");
        return 0;
    }


    public void update(String str) throws SQLException {
        Connection con = DBConnection.getConnect();
        Statement st = con.createStatement();
        String sql = "update student set checkAttendance = " + 1 + "where id = " + '\'' + str + '\'';
        int kq = st.executeUpdate(sql);

        System.out.println("ban đã thục thi: " + sql);
        System.out.println("có" + kq + "dong bi thay doi");
    }

    @Override
    public int delete(Student student) {
        return 0;
    }

    @Override
    public  ArrayList<Student> selectAll() throws SQLException {
        Connection con = DBConnection.getConnect();
        Statement st = con.createStatement();
        String sql = "select * from student";
        ResultSet rs = st.executeQuery(sql);
        ArrayList<Student> students = new ArrayList<>();
        while(rs.next()){
            String StudentID = rs.getString("studentid");
            String StudentName = rs.getString("studentName");
            String Dob = rs.getString("Dob");
            String sex = rs.getString("sex");
            String className = rs.getString("className");
            String studentImage = rs.getString("studentImage");
            String checkAttendance = rs.getString("checkAttendance");
            Student newStudent = new Student(StudentID, StudentName, Dob, sex, className, studentImage, checkAttendance);
            students.add(newStudent);
        }
        return students;
    }

    @Override
    public Student selectById(Student student) {

        return null;
    }

    @Override
    public ArrayList<Student> selectByCondition(String condition) throws SQLException {
        Connection con = DBConnection.getConnect();
        Statement st = con.createStatement();
        String sql = "select * from student where checkAttendance = "  + condition;
        ResultSet rs = st.executeQuery(sql);
        ArrayList<Student> students = new ArrayList<>();
        while(rs.next()){
            String StudentID = rs.getString("id");
            String StudentName = rs.getString("name");
            String Dob = null;
            String sex = null;
            String className = null;
            String studentImage = null;
            String checkAttendance = rs.getString("checkAttendance");
            Student newStudent = new Student(StudentID, StudentName, Dob, sex, className, studentImage, checkAttendance);
            students.add(newStudent);
        }
        return students;
    }
}
