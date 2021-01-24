package com.example.listview;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity {
    private TextView tv1;
    private Button bt1, bt2,bt3, bt4, bt5;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //hàm addControls để setFindviewbyID
        addControls();
        //hàm add events để set các sự kiện
        addEvents();
    }

    private void addControls() {
        tv1 = findViewById(R.id.tv1);
        bt1 = findViewById(R.id.btn1);
        bt2 = findViewById(R.id.btn2);
        bt3 = findViewById(R.id.btn3);
        bt4 = findViewById(R.id.btn4);
        bt5 = findViewById(R.id.btn5);
    }

    private void addEvents(){
        bt1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                doSth();
            }
        });
        bt2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                beBack();
            }
        });

        //muốn từ 1 activity này sang 1 activity khác, ta dùng Intent
        bt3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // đối số 1 là activity hiện tại, đối số 2 là activity cần đến
                Intent intent = new Intent(MainActivity.this,layout2.class);
                // dùng startActivity, truyền intent vào là xong
                MainActivity.this.startActivity(intent);
            }
        });

        bt4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent (MainActivity.this,layout3.class);
                MainActivity.this.startActivity(intent);
            }
        });

        //Stopwatch app
        bt5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent (MainActivity.this,layout4.class);
                MainActivity.this.startActivity(intent);
            }
        });
    }

    public void doSth() {
//        tvVariable = (TextView)findViewById(R.id.tv1);
        tv1.setText("Welcome to android");

    }

    public void beBack() {
        tv1.setText(getString(R.string.Heading));
    }
}