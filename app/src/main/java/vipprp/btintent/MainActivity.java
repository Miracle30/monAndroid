package vipprp.btintent;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    Button btnXuly ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    
        addEvents();
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
    }


    public void guiDuLieuTrucTiep(View view) {
        Intent intent = new Intent(MainActivity.this, Sub1Activity.class);
        //gui du lieu -  attach data
        intent.putExtra("Tag", "i love Vipp pro");
        intent.putExtra("So", 3000);
        intent.putExtra("Bu lin", true);

        //chayj man hinh
        startActivity(intent);
    }

    public void guiDuLieuBundle(View view) {
        Intent intent = new Intent(MainActivity.this, Sub2Activity.class);
        Bundle bundle = new Bundle();
        bundle.putInt("a",99);
        bundle.putDouble("b", 30.31);
        bundle.putString("c", "Forget me be");
        bundle.putBoolean("d", true);

        //dong tem, gui di
        intent.putExtra("myBundle", bundle);


        startActivity(intent);
    }
}