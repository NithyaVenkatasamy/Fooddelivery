package Models;

public class MenuItem {
    private int id;
    private String menuitem;
    private int prize;

    public MenuItem(int id, String menuitem, int prize) {
        this.id = id;
        this.menuitem = menuitem;
        this.prize = prize;
    }

    public MenuItem() {

    }

    public MenuItem(int id) {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getMenuitem() {
        return menuitem;
    }

    public void setMenuitem(String menuitem) {
        this.menuitem = menuitem;
    }

    public int getPrize() {
        return prize;
    }

    public void setPrize(int prize) {
        this.prize = prize;
    }
}
