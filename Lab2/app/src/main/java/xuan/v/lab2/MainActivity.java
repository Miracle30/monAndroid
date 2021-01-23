package xuan.v.lab2;

import androidx.annotation.NonNull;
import androidx.annotation.Size;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        super.onCreateOptionsMenu(menu);
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu,menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        super.onOptionsItemSelected(item);

        switch (item.getItemId()){
            case R.id.clear:
                //viet phan xoa o day
                AlertDialog.Builder message = new AlertDialog.Builder(this);
                message.setTitle(R.string.message_caption);
                message.setMessage(R.string.message_content);
                message.setNeutralButton(R.string.close, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        EditText et = (EditText)findViewById(R.id.edt1);
                        et.setText("");//xoa noi dung edittext
                    }
                }).show();
                break;
            case R.id.setting:
                //phan setting
                Intent intent = new Intent(this,Activity_option.class);
                final int result = 1;
                //khoi tao activity co lay ket qua ve
                startActivityForResult(intent,result);
                break;
            case R.id.exit:
                // thoat ung dung
                new AlertDialog.Builder(this).setTitle(R.string.exit_caption).setMessage(R.string.exit_content).setNegativeButton(R.string.yes, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        finish();
                    }
                }).setPositiveButton(R.string.no, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        //auto_generated method stub
                        return;
                    }
                }).show();
                break;
        }//end switch
        return true;
    }//end onOptionItemSelected
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        // lấy Bundle dữ liệu
        Bundle bundle = data.getExtras();
        int index1 = bundle.getInt("ForeColor");
        int index2 = bundle.getInt("BackColor");
        int index3 = bundle.getInt("Size");
        // lấy mảng màu
        String colorArray[] = getResources().getStringArray(R.array.color_array);
        String size[] = getResources().getStringArray(R.array.size);
        // tham chiếu đến editText
        EditText et = (EditText)findViewById(R.id.edt1);
        // thiết lập màu
        et.setTextColor(Color.parseColor(colorArray[index1]));
        et.setBackgroundColor(Color.parseColor(colorArray[index2]));
        et.setTextSize(Float.parseFloat(size[index3]));
    }
}
