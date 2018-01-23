package com.example.student.myapplication.data;

import android.content.Context;

/**
 * Created by Student on 2018/1/18.
 */

public class StudentDAOFactory {
//    0118af4
//    public static StudentDAO getDAOInstance(Context context, int dbtype) {
//        switch (dbtype) {
//            case 1:
//                return new StudentScoreDAO();
//            case 2:
//                return new StudentFileDAO(context);
//        }
//        return null;
//    }

    //af4-2
//    public static StudentDAO getDAOInstance(Context context, DBtype dbtype) //0122
//    {
//        switch (dbtype) {
//            case Memory:
//                return new StudentScoreDAO();
//            case File:
//                return new StudentFileDAO(context);
//            case DB:
//                return new StudentDAODBImpl(context);
//        }
//        return null;
//    }
    public static StudentDAO getDAOInstance(Context context, DBtype dbtype) //0123
    {
        switch (dbtype) {
            case Memory:
                return new StudentScoreDAO();
            case File:
                return new StudentFileDAO(context);
            case DB:
                return new StudentDAODBImpl(context);
            case CLOUD:
                return new StudentCloudDAO(context);
        }
        return null;
    }
}
