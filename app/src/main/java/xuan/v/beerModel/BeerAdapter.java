package xuan.v.beerModel;

import android.annotation.SuppressLint;
import android.content.Context;
import android.icu.text.Transliterator;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.ArrayList;

import xuan.v.beer.R;
import xuan.v.beerModel.Beer;

public class BeerAdapter extends ArrayAdapter<Beer> {

    Context context;
    int resId;
    ArrayList<Beer> dsBia;

    public BeerAdapter(@NonNull Context context, int resource, @NonNull ArrayList<Beer> objects) {
        super(context, resource, objects);
        this.context = context;
        this.resId = resource;
        this.dsBia = objects;
    }

    @SuppressLint("ViewHolder")
    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        View view =null;
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        view = inflater.inflate(resId, null);
        ImageView imvBeer = view.findViewById(R.id.imvBeer);
        TextView tvName = view.findViewById(R.id.tvName);
        TextView tvPrice = view.findViewById(R.id.tvPrice);

        Beer b = dsBia.get(position);
        if (b!= null){
            tvName.setText(b.getName());
            imvBeer.setImageResource(b.getImg_id());
            tvPrice.setText(b.getPrice() + "VND");
        }
        return view;
    }
}
