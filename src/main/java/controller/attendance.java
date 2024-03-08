package controller;

import dao.StudentDAO;
import model.Student;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class attendance {
    public static void checkAttendance( List<String> list) throws SQLException {
        StudentDAO studentDAO = new StudentDAO();
        studentDAO.update();
        for(String str : list){
            studentDAO.update(str);
        }
        ArrayList<Student> arrayList = studentDAO.selectByCondition("1");

        ArrayList<Student> arrayList0 = studentDAO.selectByCondition("0");
        System.out.println("List of Student present: ");
        show(arrayList);
        System.out.println();
        System.out.println("List of Student absent: ");
        show(arrayList0);

    }
    public static void show( List<Student> list){

        System.out.println("+--------------+-------------------+");
        System.out.printf("|%-14s|%-19s|\n","++StudentID++", "++Student Name++");
        System.out.println("+--------------+-------------------+");
        int sum = 0;
        for (Student student : list) {
            sum++;
            System.out.println(student);
        }
        System.out.println("+--------------+-------------------+");
        System.out.printf("|%-34s|\n","Total: " + sum + " student");
        System.out.println("+--------------+-------------------+");
    }
}
