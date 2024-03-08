package dao;

import java.sql.Connection;
import java.util.ArrayList;

public class TeacherDAO implements DAOInterface{

    public static TeacherDAO getInstance(){
        return new TeacherDAO();
    }
    @Override
    public int insert(Object o) {
        //Connection con = JDBCUtil.getConnection();
        return 0;
    }

    @Override
    public int update(Object o) {
        return 0;
    }

    @Override
    public int delete(Object o) {
        return 0;
    }

    @Override
    public ArrayList selectAll() {
        return null;
    }

    @Override
    public Object selectById(Object o) {
        return null;
    }

    @Override
    public ArrayList selectByCondition(String condition) {
        return null;
    }
}
