package model;

import java.util.List;
import java.util.ArrayList;
public class Order {
    private String id;
    private Customer customer;
    private List<CartItem> items;
    private String status;

    public Order(String id, Customer customer, List<CartItem> items, String status) {
        this.id = id;
        this.customer = customer;
        this.items = new ArrayList<>();
        this.status = "PENDING";
    }

    public String getId() {
        return id;
    }

    public Customer getCustomer() {
        return customer;
    }

    public String getStatus() {
        return status;
    }

    public List<CartItem> getItems() {
        return items;
    }

    public void addItem(CartItem item) {
        if (item == null) {
            throw new IllegalArgumentException("KHONG HOP LE");
        }
        items.add(item);
    }

    public double getTotal() {
        double total = 0;
        for (int i = 0; i < items.size(); i++) {
            total += items.get(i).getTotal();
        }
        return total;
    }

    public void confirm() {
        status = "CONFIRMED";
    }

    public void cancel() {
        status = "CANCELLED";
    }
}
