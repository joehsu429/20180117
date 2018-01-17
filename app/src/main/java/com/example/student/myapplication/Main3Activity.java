package com.example.student.myapplication;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.example.student.myapplication.data.student;

public class Main3Activity extends AppCompatActivity {
    student s;
    TextView tv,tv2,tv3;
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);

        int id=getIntent().getIntExtra("id",0);
        s =MainActivity.dao.getstudent(id);
        tv =findViewById(R.id.textView);
        tv2 =findViewById(R.id.textView2);
        tv3 =findViewById(R.id.textView3);
        tv.setText(String.valueOf(s.id));
        tv2.setText(s.name);
        tv3.setText(String.valueOf(s.score));
    }
}
