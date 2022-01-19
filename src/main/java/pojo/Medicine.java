package pojo;

import interfaces.Product;


public class Medicine extends Product implements Comparable<Medicine> {


    public Medicine(String name, float dosage, double price) {
        super(name, dosage, price);
    }

    public Medicine() {
        super();
    }

    public Medicine(int id, String name, float dosage, double price, int stock) {super(id, name, dosage, price, stock);}

    @Override
    public int getStock() {return super.getStock();}

    @Override
    public void setStock(int stock) {super.setStock(stock);}

    @Override
    public double getPrice() {
        return super.getPrice();
    }

    @Override
    public void setPrice(double price) {
        super.setPrice(price);
    }

    @Override
    public int getId() {
        return super.getId();
    }

    @Override
    public void setId(int id) {
        super.setId(id);
    }

    @Override
    public String getName() {
        return super.getName();
    }

    @Override
    public void setName(String name) {
        super.setName(name);
    }

    @Override
    public float getDosage() {
        return super.getDosage();
    }

    @Override
    public void setDosage(float dosage) {
        super.setDosage(dosage);
    }

    @Override
    public String toString() {
        return super.toString();
    }

    @Override
    public int compareTo(Medicine o) {
        return name.compareToIgnoreCase(o.name);
    }

}




