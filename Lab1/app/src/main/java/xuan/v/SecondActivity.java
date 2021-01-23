package xuan.v;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class SecondActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
    }

    public void showMe(View view) {
        String msg;
        EditText edT=findViewById(R.id.edtxt1);
        msg ="Xin chao" + edT.getText().toString();
        //hien thi message box
        Toast.makeText(getApplicationContext(),msg,Toast.LENGTH_LONG).show();
    }


}
