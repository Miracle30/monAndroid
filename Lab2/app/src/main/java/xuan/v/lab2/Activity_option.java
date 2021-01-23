package xuan.v.lab2;



import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Spinner;

public class Activity_option extends Activity {


        //tao 2 bien private chua index mau ma user chon
        private int index1 = 0, index2 = 0, index3 =0;

        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_option);

            setContentView(R.layout.activity_option);
            Spinner spinner1 = (Spinner) findViewById(R.id.spinner1);
            spinner1.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                @Override
                public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                    index1 = position; //lay index user chon
                }

                @Override
                public void onNothingSelected(AdapterView<?> parent) {
                }
            });

            Spinner spinner2 = (Spinner) findViewById(R.id.spinner2);
            spinner2.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                @Override
                public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                    index2 = position; //lay index user chon
                }

                @Override
                public void onNothingSelected(AdapterView<?> parent) {
                }
            });

            Spinner spinner3 = (Spinner) findViewById(R.id.spinner3);
            spinner3.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                @Override
                public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                    index3 = position; //lay index user chon
                }

                @Override
                public void onNothingSelected(AdapterView<?> parent) {
                }
            });
        }

    public void onOK(View view) {
        //goi du lieu ve activity truoc
        Intent intent = new Intent();
        Bundle bundle = new Bundle();
        bundle.putInt("ForeColor", index1);
        bundle.putInt("BackColor", index2);
        bundle.putInt("Size", index3);
        intent.putExtras(bundle); //goi kem du liẹu
        setResult(RESULT_OK, intent);//goi ket qua ve
        finish();//dong activity
    }


}

