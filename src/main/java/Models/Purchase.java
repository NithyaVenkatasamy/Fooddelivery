package Models;

public class Purchase {
    private MenuItem menuitem;
    private int orderid;

    public Purchase(int orderid) {
        this.menuitem = menuitem;
        this.orderid = orderid;
    }

    public Purchase() {
    }

    public MenuItem getMenuitems() {
        return menuitem;
    }

    public void setMenuitem(MenuItem menuitem) {
        this.menuitem = menuitem;
    }

    public int getOrderid() {
        return orderid;
    }

    public void setOrderid(int orderid) {
        this.orderid = orderid;
    }

    @Override
    public String toString() {
        return "Purchase{" +
                "menuitem=" + menuitem +
                ", orderid=" + orderid +
                '}';
    }
}
