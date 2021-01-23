package xuan.v.lab4;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.database.Cursor;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CursorAdapter;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import android.widget.TabHost;
import android.app.TabActivity;
import android.widget.AdapterView;

public class MainActivity extends TabActivity {
    //bien thanh viên
    //    private Restaurant r = new Restaurant();
    List<Restaurant> restaurantsList = new ArrayList<Restaurant>();

//    ArrayAdapter<Restaurant> adapter = null;
//
//    RestaurantHelper helper;
//
    Cursor curRestaurant = null;

    RestaurantAdapter adapter = null;

    RestaurantHelper helper = null;

    private AdapterView.OnItemClickListener onListClick = new
            AdapterView.OnItemClickListener() {
                @Override
                public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                    //phan code trong buoc 4
//                    Restaurant r = restaurantsList.get(position);
                    curRestaurant.moveToPosition(position);

                    EditText name;
                    EditText address;
                    RadioGroup types;

                    // Tham chiếu đến các view trong details
                    name = (EditText)findViewById(R.id.name);
                    address = (EditText)findViewById(R.id.addr);
                    types = (RadioGroup)findViewById(R.id.types);

                    // sử dụng đối tượng helper để lấy các thông tin nhà hàng
                    name.setText(helper.getName(curRestaurant));
                    address.setText(helper.getAddress(curRestaurant));
                    if (helper.getType(curRestaurant).equals("Sit down"))
                        types.check(R.id.sit_down);
                    else if (helper.getType(curRestaurant).equals("Take out"))
                        types.check(R.id.take_out);
                    else
                        types.check(R.id.delivery);
                        // chuyen qua tab detail
                    getTabHost().setCurrentTab(1);
                }
            };

    class RestaurantAdapter extends CursorAdapter {
        public RestaurantAdapter(Cursor c) {
            super(MainActivity.this, c);
        }

        public RestaurantAdapter(Context context, Cursor c) {
            super(context, c);
        }

        @Override
        public void bindView(View view, Context context, Cursor cursor) {

            View row = view;
            ((TextView) row.findViewById(R.id.title)).setText(helper.getName(cursor));
            ((TextView) row.findViewById(R.id.address)).setText(helper.getAddress(cursor));
            ImageView icon = (ImageView) row.findViewById(R.id.icon);
            String type = helper.getType(cursor);
            if (type.equals("Take out"))
                icon.setImageResource(R.drawable.ic_takeout);
            else if (type.equals("Sit down"))
                icon.setImageResource(R.drawable.ic_sitdown);
            else
                icon.setImageResource(R.drawable.ic_delivery);
        }

        @Override
        public View newView(Context context, Cursor cursor, ViewGroup parent) {
            LayoutInflater inflater = getLayoutInflater();
            View row = inflater.inflate(R.layout.row, parent, false);
            return row;
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //khoi tao doi tuong RestaurantHelper
        helper = new RestaurantHelper(this);

        Button save = (Button)findViewById(R.id.save);
        save.setOnClickListener(onSave);

        ListView list = (ListView)findViewById(R.id.restaurants);

        list.setOnItemClickListener(onListClick);

        //lay du lieu tu CSDL
        curRestaurant = helper.getAll();
        startManagingCursor(curRestaurant);
        adapter = new RestaurantAdapter(curRestaurant);
        list.setAdapter(adapter);

        //phan bo sung cho Tab

        TabHost.TabSpec spec = getTabHost().newTabSpec("tag1");
        spec.setContent(R.id.restaurants);
        spec.setIndicator("List",getResources().getDrawable(R.drawable.list));
        getTabHost().addTab(spec);

        spec = getTabHost().newTabSpec("tag2");
        spec.setContent(R.id.details);
        spec.setIndicator("Details",
                getResources().getDrawable(R.drawable.res));
        getTabHost().addTab(spec);

        getTabHost().setCurrentTab(0);

        
//        list.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
//            @Override
//            public boolean onItemLongClick(AdapterView<?> parent, View view, final int position, long id) {
//                AlertDialog.Builder adb = new AlertDialog.Builder(MainActivity.this);
//                adb.setTitle("Are you sure ?");
//                adb.setMessage("Do you want to delete this item ?" + position);
//                adb.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
//                    @Override
//                    public void onClick(DialogInterface dialog, int which) {
//                        restaurantsList.remove(position);
//                        adapter.notifyDataSetChanged();
//                        list.setAdapter(null);
//                    }
//                });
//                adb.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
//                    @Override
//                    public void onClick(DialogInterface dialog, int which) {
//
//                    }
//                });
//                adb.show();
//                return true;
//            }
//        });




    }

    private View.OnClickListener onSave = new View.OnClickListener(){
        @Override
        public void onClick(View v) {
            Restaurant r= new Restaurant();
            String msg;
            EditText name = (EditText) findViewById(R.id.name);
            EditText address = (EditText) findViewById(R.id.addr);
            RadioGroup type = (RadioGroup)findViewById(R.id.types);


            r.setName(name.getText().toString());
            r.setAddress(address.getText().toString());


            switch (type.getCheckedRadioButtonId()){
                case R.id.take_out:
                    msg = name.getText().toString() +" "+address.getText().toString()+"Take out";
                    Toast.makeText(getApplicationContext(),msg,Toast.LENGTH_LONG).show();
                    r.setType("Take out");
                    break;
                case R.id.sit_down:
                    msg = name.getText().toString() +" "+address.getText().toString()+"Sit down";
                    Toast.makeText(getApplicationContext(),msg,Toast.LENGTH_LONG).show();
                    r.setType("Sit down");
                    break;
                case R.id.delivery:
                    msg = name.getText().toString() +" "+address.getText().toString()+"Delivery";
                    Toast.makeText(getApplicationContext(),msg,Toast.LENGTH_LONG).show();
                    r.setType("Delivery");
                    break;
                default:
                    break;
            }
            //them vao co so du lieu
            helper.insert(r.getName(), r.getAddress(), r.getType());
            //them vao restaurant list
//            restaurantsList.add(r);
            //refresh lai du lieu
            curRestaurant.requery();
        }
    };

    @Override
    protected void onDestroy() {
        super.onDestroy();

        helper.close();
    }

}
