package dao;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;

public interface DAOInterface<T> {
    public int insert(T t) throws SQLException;
    public int update(T t) throws SQLException;
    public  int delete(T t);

    public  ArrayList<T> selectAll() throws SQLException;
    public  T selectById(T t);
    public  ArrayList<T> selectByCondition(String condition) throws SQLException;


}
