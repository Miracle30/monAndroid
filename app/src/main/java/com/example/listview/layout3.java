package com.example.listview;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;
import java.util.List;

public class layout3 extends AppCompatActivity {
    TextView tvBrand;
    Spinner colorSpn;
    Button btnFindBeer;
    private BeerExpert expert = new BeerExpert();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_layout3);
        addControl();
        addEvent();

    }

    private void addEvent() {
        btnFindBeer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Get recommendations from the BeerExpert class
                String beerType = String.valueOf(colorSpn.getSelectedItem());
                //dùng class BeerExpert để lấy ra list các brands
                List <String> brandList = expert.getBrands(beerType);
                //display ra mỗi brand là 1 dòng
                StringBuilder brandsFormatted = new StringBuilder();
                for (String brand: brandList){
                    brandsFormatted.append(brand).append("\n");
                }

                tvBrand.setText(brandsFormatted);
            }
        });
    }

    private void addControl() {
        tvBrand = (TextView)findViewById(R.id.tvBrand);
        btnFindBeer = (Button)findViewById(R.id.btnFindBeer);
        colorSpn = (Spinner)findViewById(R.id.colorSpn);

    }


    //o dit à vl oke ban oi
    public void doSth(View view) {




    }
}