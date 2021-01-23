package xuan.btntimuocso;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.ArrayList;

public class MainActivity2 extends AppCompatActivity {

    TextView tvN;
    Button btnTimUoc;
    Intent intent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        addViews();
        addEvents();
    }

    private void addEvents() {
        btnTimUoc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                xuLyTraUocSo();
            }
        });
    }

    private void xuLyTraUocSo() {
        int n = Integer.parseInt(tvN.getText().toString());
        ArrayList<Integer> dsUs = new ArrayList<>();
        dsUs.add(1);
        for (int i =2; i <=n; i++){
            if(n%i==0){
                dsUs.add(i);
            }
        }

        intent.putExtra("Danhsachuocso",dsUs);
        setResult(Activity.RESULT_OK, intent);
        finish();
    }

    private void addViews() {
        tvN = findViewById(R.id.tvN);
        btnTimUoc = findViewById(R.id.btnTimUoc);
        intent = getIntent();
        tvN.setText(intent.getIntExtra("n",0)+"");
    }
}