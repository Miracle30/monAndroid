package vipprp.btintent;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class Sub2Activity extends AppCompatActivity {

    TextView tvKetQua;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sub2);
        tvKetQua = findViewById(R.id.tvKetQua);

        Intent intent = getIntent();
        Bundle bundle = intent.getBundleExtra("myBundle");
        int a = bundle.getInt("a");
        double b = bundle.getInt("b");
        String c = bundle.getString("c");
        boolean d = bundle.getBoolean("d");

        tvKetQua.setText("");
        tvKetQua.append("a = "+a+"\n");
        tvKetQua.append("b = "+b+"\n");
        tvKetQua.append("c = "+c+"\n");
        tvKetQua.append("d = "+d+"\n");
    }
}