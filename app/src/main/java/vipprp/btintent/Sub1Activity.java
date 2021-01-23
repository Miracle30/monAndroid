package vipprp.btintent;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class Sub1Activity extends AppCompatActivity {

    TextView tvKetQua;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sub1);
        linkViews();
        getData();
    }

    private void getData() {
        Intent intent = getIntent();
        String chuoi = intent.getStringExtra("Tag");
        int a = intent.getIntExtra("So", 0);
        boolean b = intent.getBooleanExtra("Bu lin", false);

        tvKetQua.setText("");
        tvKetQua.append("Chuoi "+ chuoi +"\n");
        tvKetQua.append("So "+ a +"\n");
        tvKetQua.append("Boolean "+ b +"\n");
    }

    private void linkViews() {
        tvKetQua = findViewById(R.id.tvKetQua);


    }
}