package xuan.v.beerModel;

import java.util.ArrayList;

import xuan.v.beer.R;

public class BeerModel {
    public static String [] name = new String[] {"bia 333", "bia ha noi", "bia ken", "bia la rue", "bia tphcm","bia sap po ro", "bia cop?"};
    public static int[] img = new int[] {
            R.drawable.beerba, R.drawable.hanoi, R.drawable.heineken, R.drawable.larue,
            R.drawable.saigon,R.drawable.sapporo,R.drawable.tiger
    };
    public static double [] price = new double[] {
            10000,20000,30000,40000,50000,60000,70000
    };

    private static ArrayList<Beer> dsBeer;
    public static ArrayList<Beer> getDsBeer(){
        if (dsBeer == null){
            BeerModel beerModel = new BeerModel();
            beerModel.initBeerList();
        }
        return dsBeer;
    }

    private void initBeerList() {
        dsBeer = new ArrayList<Beer>();
        for (int i = 0; i < name.length ; i++) {
            Beer b = new Beer(name[i], img[i], price[i]);
            dsBeer.add(b);
        }
    }
}
