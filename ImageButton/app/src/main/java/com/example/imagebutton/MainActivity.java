package com.example.imagebutton;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener, View.OnLongClickListener {

    ImageView ivPhoto;
    ImageButton btnChange, btnClose;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        linkViews();
        addEvents();
    }

    private void linkViews() {
        ivPhoto =findViewById(R.id.imvPhoto);
        btnChange =findViewById(R.id.btnChange);
        btnClose =findViewById(R.id.btnClose);
    }

    private void addEvents() {
//        btnChange.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                //Changephoto
//                if (ivPhoto.getTag() == null || ivPhoto.getTag().equals("riot")) {
//                    //ivPhoto.setImageResource(R.drawable.beo);
//                    ivPhoto.setImageDrawable(getResources().getDrawable(R.drawable.beo));
//                    ivPhoto.setTag("beo");
//                }else{
//                    ivPhoto.setImageResource(R.drawable.riot);
//                    ivPhoto.setTag("riot");
//                }
//            }
//        });
//
//        btnClose.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                //close
//                finish();
//                System.exit(0);
//
//            }
//        });
        btnChange.setOnClickListener(this);
        btnClose.setOnClickListener(this);
        btnClose.setOnLongClickListener(this);
}

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btnChange:
                if (ivPhoto.getTag() == null || ivPhoto.getTag().equals("riot")) {
                    //ivPhoto.setImageResource(R.drawable.beo);
                    ivPhoto.setImageDrawable(getResources().getDrawable(R.drawable.beo));
                    ivPhoto.setTag("beo");
                }else{
                    ivPhoto.setImageResource(R.drawable.riot);
                    ivPhoto.setTag("riot");
                }
                break;
            case R.id.btnClose:
                finish();
                break;
        }
    }

    @Override
    public boolean onLongClick(View v) {
        if(v.getId() == R.id.btnClose){
            Toast.makeText(this, "Hello", Toast.LENGTH_SHORT).show();
        }
        return true;
    }


//    View.OnClickListener myClick = new View.OnClickListener() {
//        @Override
//        public void onClick(View v) {
//            if(v.getId()== R.id.btnChange){
//                if (ivPhoto.getTag() == null || ivPhoto.getTag().equals("riot")) {
//                    //ivPhoto.setImageResource(R.drawable.beo);
//                    ivPhoto.setImageDrawable(getResources().getDrawable(R.drawable.beo));
//                    ivPhoto.setTag("beo");
//                }else{
//                    ivPhoto.setImageResource(R.drawable.riot);
//                    ivPhoto.setTag("riot");
//                }
//            }
//            else if(v.getId() == R.id.btnClose){
//                finish();
//            }
//        }
//    };


}
