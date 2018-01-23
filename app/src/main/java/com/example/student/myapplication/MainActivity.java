package com.example.student.myapplication;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;


import com.example.student.myapplication.data.DBtype;
import com.example.student.myapplication.data.StudentDAO;
import com.example.student.myapplication.data.StudentDAOFactory;
import com.example.student.myapplication.data.StudentFileDAO;
import com.example.student.myapplication.data.StudentScoreDAO;
import com.example.student.myapplication.data.student;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    //public static StudentFileDAO dao;//0118af1
    //final public static StudentScoreDAO dao;
    public static StudentDAO dao;//0118af4
    //int dbtype;//0118af4
    DBtype dbtype;//af4-2
    ListView lv;
    ArrayList<String> studentNames;//0123
    ArrayAdapter<String> adapter;//0123
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //dao = new StudentFileDAO(this);//0118af1
        //dbtype= 1;//1.記憶體,2.檔案//0118af4
        //dbtype=DBtype.File;//af4-2
//        dbtype=DBtype.DB;//0122
        dbtype=DBtype.CLOUD;//0123
//        switch(dbtype)//0118af4 一開始先寫這邊再貼到Factory去
//        {
//            case 1: dao=new StudentScoreDAO();
//                break;
//            case 2:dao=new StudentFileDAO(this);
//                break;
//        }
        dao= StudentDAOFactory.getDAOInstance(this,dbtype);
        studentNames = new ArrayList<>();
        adapter = new ArrayAdapter<String>(MainActivity.this,
                android.R.layout.simple_list_item_1, studentNames);
        lv=findViewById(R.id.listView);
        lv.setAdapter(adapter);
        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {
                Intent it=new Intent(MainActivity.this,Main3Activity.class);
                it.putExtra("id",dao.getList().get(position).id);
                startActivity(it);
            }
        });
    }

    @Override
    protected void onResume() {
        super.onResume();
        refreshData();
    }
    public void refreshData()
    {
        studentNames.clear();
        for (student s : dao.getList())
        {
            studentNames.add(s.name);
        }
        adapter.notifyDataSetChanged();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main_menu2,menu);
        return super.onCreateOptionsMenu(menu);
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == R.id.menu_add)
        {
            Intent it = new Intent(MainActivity.this, AddActivity.class);
            startActivity(it);
        }
        return super.onOptionsItemSelected(item);
    }
}
