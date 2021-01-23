package xuan.v.btintent;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Log.i("Life Cycle", "onCreate");
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.i("Life Cycle", "onStart");
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.i("Life Cycle", "onRestart");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.i("Life Cycle", "onResume");

    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.i("Life Cycle", "onPause");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.i("Life Cycle", "onStop");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.i("Life Cycle", "onDestroy");
    }



    public void showFirstActivity(View view) {
        Intent intent = new Intent(MainActivity.this,FirstActivity.class);
        startActivity(intent);

    }

    public void showSecondDialog(View view) {
//        AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
//        builder.setTitle("Xác nhận");
//        builder.setMessage("Bạn có muốn thoát");
//        builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
//            @Override
//            public void onClick(DialogInterface dialog, int which) {
//                finish();
//            }
//        });
//        builder.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
//            @Override
//            public void onClick(DialogInterface dialog, int which) {
//                dialog.dismiss();
//            }
//        });
//        AlertDialog dialog = builder.create();
//        dialog.show();
        //Intent intent = new Intent(MainActivity.this,SecondActivity.class);
        //startActivity(intent);
    }
}
