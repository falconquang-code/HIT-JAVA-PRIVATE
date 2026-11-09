package model;
public class Product {
    private String id;
    private String name;
    private double price;
    private int stock;
    private static int count = 0;

    public Product(String id, String name, double price, int stock) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.stock = stock;
        count++;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    public int getStock() {
        return stock;
    }

    public static int getCount() {
        return count;
    }
    public void setName(String name){
        if (name.isEmpty()) {
            System.out.println("ten ko dc de trong");
            return;
        }
        this.name = name;
    }

    public void setPrice(double price) {
        if (price <=0){
            System.out.println("Gia phai lon hon 0");
            return;
        }
        this.price = price;
    }

    public void setStock(int stock) {
        if(stock < 0){
            System.out.println("So luong kho phai lon hon 0");
            return;
        }
        else{
            this.stock = stock;
        }
    }
    @Override
    public String toString(){
        return id + " | " + name + " | " + price + " | " + stock;
    }
}


