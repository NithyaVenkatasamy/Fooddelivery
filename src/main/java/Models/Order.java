package Models;

import java.util.ArrayList;

public class Order {
    private int id;
    private User user;
    ArrayList<Purchase>purchases=new ArrayList<>();

    public Order(int id, User user) {
        this.id = id;
        this.user = user;
    }

    public Order() {
    }

    public Order(int id) {

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public ArrayList<Purchase> getPurchases() {
        return purchases;
    }

    public void setPurchases(ArrayList<Purchase> purchases) {
        this.purchases = purchases;
    }
}
