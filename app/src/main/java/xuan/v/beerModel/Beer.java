package xuan.v.beerModel;

public class Beer {
    private String name;
    private int img_id;
    private double price;

    public Beer() {
    }

    public Beer(String name, int img_id, double price) {
        this.name = name;
        this.img_id = img_id;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public int getImg_id() {
        return img_id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setImg_id(int img_id) {
        this.img_id = img_id;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
}
