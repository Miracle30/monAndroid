package xuan.v.beer;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

import xuan.v.beerModel.Beer;
import xuan.v.beerModel.BeerAdapter;
import xuan.v.beerModel.BeerModel;

public class MainActivity extends AppCompatActivity {

    ListView lvBeers;
    ArrayList<Beer> dsBeer;
    BeerAdapter beerAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        linkViews();
        addEvents();
    }

    private void addEvents() {
        lvBeers.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                    //create and show dialog
                Dialog dialog = new Dialog(MainActivity.this);
                dialog.setContentView(R.layout.custom_dialog);
                //get data
                Beer b = beerAdapter.getItem(position);
                ImageView imvThumb = dialog.findViewById(R.id.imvThumb);
                imvThumb.setImageResource(b.getImg_id());
                TextView txtName = dialog.findViewById(R.id.txtName);
                txtName.setText(b.getName());
                dialog.show();
            }
        });
    }

    private void linkViews() {
        lvBeers = findViewById(R.id.lvBeers);
        dsBeer =  BeerModel.getDsBeer();
        beerAdapter = new BeerAdapter(this, R.layout.custom_item_listview, dsBeer);
        lvBeers.setAdapter(beerAdapter);
    }

}
