package com.example.student.myapplication.data;

import java.util.ArrayList;

/**
 * Created by Student on 2018/1/18.
 */
//0118af3 用Interface開新class
public interface StudentDAO {
    public boolean add(student s);
    public ArrayList<student> getList();
    public student getstudent(int id);
    public boolean update(student s);
    public boolean delete(int id);

}
