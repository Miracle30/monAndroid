package xuan.v;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

public class bai4 extends AppCompatActivity {

    EditText edt1, edt2;
    TextView tv1;
    Spinner spn;
    Button btn1;
    float a, b, result;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bai4);
        addControl();
        addEvent();
    }

    private void addEvent() {
        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                a = Float.parseFloat(edt1.getText().toString());
                b = Float.parseFloat(edt2.getText().toString());
                String options = spn.getSelectedItem().toString();
                switch (options){
                    case "Summation":
                        //cộng
                        result = a+b;
                        break;
                    case "Subtraction":
                        //trừ
                        result = a-b;
                        break;
                    case "Multiplication":
                        //nhân
                        result = a*b;
                        break;
                    case "Division":
                        //chia
                        result = a/b;
                        break;
                }
                tv1.setText("The result is "+ result);
            }
        });
    }

    private void addControl() {
        tv1 = findViewById(R.id.tvKetqua);
        spn = findViewById(R.id.spn);
        edt1 = findViewById(R.id.edt1);
        edt2 = findViewById(R.id.edt2);
        btn1 = findViewById(R.id.btn1);
    }

    //onclick cho button
//    public void tinhToan(View view) {
//        tv1 = findViewById(R.id.tvKetqua);
//        Spinner spn = findViewById(R.id.spn);
//        edt1 = findViewById(R.id.edt1);
//        edt2 = findViewById(R.id.edt2);
//
//
//
//        String options = String.valueOf(spn.getSelectedItem());
//        if (options.equals("Cộng")){
//            result = a+b;
//        }
//        else if(options.equals("Trừ")){
//            result = a-b;
//        }
//        else if (options.equals("Nhân")){
//            result = a*b;
//        }
//        else if (options.equals("Chia")){
//            result = a/b;
//        }
//        tv1.setText("Kết quả phép " + options + " là: "+ Float.toString(result));
//    }
}
