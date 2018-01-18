package com.example.student.myapplication;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import com.example.student.myapplication.data.student;

public class Main4Activity extends AppCompatActivity {
    int id;
    student s;
    TextView tv4;
    EditText ed4,ed5;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main4);
        id=getIntent().getIntExtra("id",0);
        tv4=findViewById(R.id.textView4);//不用每次被更新的資料放在這邊即可
        ed4=findViewById(R.id.editText4);//不用每次被更新的資料放在這邊即可
        ed5=findViewById(R.id.editText5);//不用每次被更新的資料放在這邊即可


    }



    public void click5(View v)
    {
        finish();
    }
    public void click6(View v)//這樣雖然有update但資料沒有即時更新,要加上onResume 參考Main3頁面
    {
        student s=new student(id,ed4.getText().toString(),Integer.valueOf(ed5.getText().toString()));
        MainActivity.dao.update(s);
        finish();
    }
}
