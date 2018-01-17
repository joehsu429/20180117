package com.example.student.myapplication;

import com.example.student.myapplication.data.StudentScoreDAO;
import com.example.student.myapplication.data.student;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
public class ExampleUnitTest {
    @Test
    public void test1_add_data()throws Exception
    {
        StudentScoreDAO dao=new StudentScoreDAO();
        dao.add(new student(1,"Bob",95));
        dao.add(new student(2,"joe",90));
        assertEquals(2,dao.getList().size());
    }
    @Test
    public void test2_add_data()throws Exception
    {
        StudentScoreDAO dao=new StudentScoreDAO();
        dao.add(new student(1,"Bob",95));
        dao.add(new student(2,"joe",90));
        assertEquals(1,dao.getList().get(0).id);
    }
    @Test
    public void test_getstudent()throws Exception
    {
        StudentScoreDAO dao=new StudentScoreDAO();
        dao.add(new student(1,"Bob",95));
        dao.add(new student(2,"joe",90));
        assertEquals(95,dao.getstudent(1).score);
    }
    @Test
    public void test_getstudent1()throws Exception
    {
        StudentScoreDAO dao=new StudentScoreDAO();
        dao.add(new student(1,"Bob",95));
        dao.add(new student(2,"joe",90));
        assertEquals(null,dao.getstudent(3));
    }
    @Test
    public void test_update()throws Exception
    {
        StudentScoreDAO dao=new StudentScoreDAO();
        dao.add(new student(1,"Bob",95));
        dao.add(new student(2,"joe",90));
        dao.update(new student(2,"jojo",85));
        assertEquals(85,dao.getstudent(2).score);
    }
    @Test
    public void test_delete() throws Exception {
        StudentScoreDAO dao = new StudentScoreDAO();
        dao.add(new student(1, "Bob", 95));
        dao.add(new student(2, "joe", 90));
        dao.delete(2);
        assertEquals(1, dao.getList().size());
    }
}