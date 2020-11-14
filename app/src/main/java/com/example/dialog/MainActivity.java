package com.example.dialog;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        findViewById(R.id.button).setOnClickListener(v -> new AlertDialog.Builder(this)
                .setTitle("标题")
                .setMessage("简单的消息提示框")
                .setPositiveButton("确定", null)
                .show());
        findViewById(R.id.button2).setOnClickListener(v -> {
            AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
            // 创建一个view，并且将布局加入view中
            final View viewDialog = LayoutInflater.from(MainActivity.this).inflate(R.layout.dialog, null, false);
            builder.setTitle("自定义对话框")
                    .setView(viewDialog)
                    .setPositiveButton("确定", (dialog, which) -> {
                        //取得用户输入内容，注意findViewById前面的viewDialog，表示在该view里面进行查找
                        EditText name = viewDialog.findViewById(R.id.name);
                        EditText password = viewDialog.findViewById(R.id.password);
                        if (name.getText().toString().equals("abc") && password.getText().toString().equals("123"))
                            Toast.makeText(MainActivity.this, "登陆成功", Toast.LENGTH_LONG).show();
                        else {
                            Toast.makeText(MainActivity.this, "用户名或密码错误", Toast.LENGTH_LONG).show();
                        }
                    }).setNegativeButton("取消", (dialog, which) -> {
            });
            builder.create().show();
        });
    }
}