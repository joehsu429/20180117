package com.example.student.myapplication;

import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import com.example.student.myapplication.data.student;

public class Main3Activity extends AppCompatActivity {
    student s;
    TextView tv,tv2,tv3;
    boolean fastback=false;//0118af2 按下Update後回到最上層的做法
    int id;//每次new進來的數據都不一樣所以可以放在這邊當成員變數
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);
        id = getIntent().getIntExtra("id",0);//getIntent是抓前一頁的資料
        tv =findViewById(R.id.textView);//不用每次被更新的資料放在這邊即可
        tv2 =findViewById(R.id.textView2);//不用每次被更新的資料放在這邊即可
        tv3 =findViewById(R.id.textView3);//不用每次被更新的資料放在這邊即可

    }
    @Override
    protected void onResume() {
        super.onResume();//要加上onResume後資料才會即時更新
        if(fastback)//0118af2 按下Update後回到最上層的做法
        {
            finish();
        }
        s = MainActivity.dao.getstudent(id);//每次要被更新的資料要放在這邊
        tv.setText(String.valueOf(s.id));
        tv2.setText(s.name);
        tv3.setText(String.valueOf(s.score));

    }
    public void click2(View v)
    {
        finish();
    }
    public void click3(View v)
    {
        AlertDialog.Builder builder=new AlertDialog.Builder(this);//步驟2美化
        builder.setTitle("刪除確認");
        builder.setMessage("確定要刪除本筆資料???");
        builder.setPositiveButton("確認", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                MainActivity.dao.delete(id);//0118m1  步驟1基本刪除做法
                finish();
            }
        });
        builder.setNegativeButton("取消", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {

            }
        });
        builder.show();
    }
    public void click4(View v)
    {
        Intent it=new Intent(Main3Activity.this,Main4Activity.class);
        it.putExtra("id",id);
        fastback=true;//0118af2 按下Update後回到最上層的做法
        startActivity(it);
    }
}
