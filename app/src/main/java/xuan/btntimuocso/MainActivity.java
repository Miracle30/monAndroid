package xuan.btntimuocso;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    Button btnXuly;
    EditText edtSoNguyen;
    TextView txtKetQua;

    public static final int  REQUEST_CODE = 1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        addViews();
        addEvents();
    }

    private void addViews() {
        edtSoNguyen = findViewById(R.id.edtSoNguyen);
        btnXuly = findViewById(R.id.btnXuly);
        txtKetQua = findViewById(R.id.txtKetqua);
    }

    private void addEvents() {
        btnXuly.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                moManHinhUocSo();
            }
        });
    }

    private void moManHinhUocSo() {
        Intent intent = new Intent(MainActivity.this,MainActivity2.class);
        intent.putExtra("n", Integer.parseInt(edtSoNguyen.getText().toString()));
        startActivityForResult(intent,REQUEST_CODE);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if(requestCode == REQUEST_CODE && resultCode == Activity.RESULT_OK && data != null){
            ArrayList<Integer> ds = data.getIntegerArrayListExtra("Danhsachuocso");
            txtKetQua.setText("");
            for(int i : ds)
                txtKetQua.append(i + "\n");
        }
    }
}