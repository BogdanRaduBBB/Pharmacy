package interfaces;

public abstract class Product  {

    protected int id;
    protected String name;
    protected float dosage;
    protected double price;
    protected int stock;

    public Product() {
    }

    public Product(int id, String name, float dosage, double price, int stock) {
        this.id = id;
        this.name = name;
        this.dosage = dosage;
        this.price = price;
        this.stock = stock;
    }

    public Product(String name, float dosage, double price) {
        this.name = name;
        this.dosage = dosage;
        this.price = price;
    }

    public int getStock() {return stock;}

    public void setStock(int stock) {this.stock = stock;}

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public float getDosage() {
        return dosage;
    }

    public void setDosage(float dosage) {
        this.dosage = dosage;
    }



    @Override
    public String toString() {
        return  name + ", Dosage=" + dosage + ", Price: " + price +"RON"+"\n";
    }

}
