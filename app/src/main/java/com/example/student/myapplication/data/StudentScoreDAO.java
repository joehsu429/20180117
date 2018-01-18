package com.example.student.myapplication.data;

import java.util.ArrayList;

/**
 * Created by Student on 2018/1/17.
 */

public class StudentScoreDAO implements StudentDAO
{
    public ArrayList<student> mylist;

    public StudentScoreDAO() {
        mylist = new ArrayList<>();
    }

    public boolean add(student s) {
        mylist.add(s);
        return true;
    }

    public ArrayList<student> getList() {
        return mylist;
    }

    public student getstudent(int id) {
        for (student s : mylist) {
            if (s.id == id) {
                return s;
            }
        }
        return null;
    }

    public boolean update(student s) {
        for (student t : mylist) {
            if (t.id == s.id) {
                t.name = s.name;
                t.score = s.score;
                return true;
            }
        }
        return false;
    }
    public boolean delete(int id) {
        for (int i=0;i<mylist.size();i++)
        {
            if(mylist.get(i).id ==id)
            {
                mylist.remove(i);
                return true;
            }
        }

        return false;
    }
}