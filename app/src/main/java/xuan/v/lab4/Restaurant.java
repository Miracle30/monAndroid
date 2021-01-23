package xuan.v.lab4;

public class Restaurant {
    private String name = "";
    private String address = "";
    private String type = "";

    public Restaurant(String name, String address, String type) {
        this.name = name;
        this.address = address;
        this.type = type;
    }

    public Restaurant() {
    }

    public String getName() { return name; }

    public String toString(){
        return (getName() + getAddress() + getType());
    }

    public String getAddress() {
        return address;
    }

    public String getType() {
        return type;
    }


    public void setName(String name) {
        this.name = name;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setType(String type) {
        this.type = type;
    }
}
