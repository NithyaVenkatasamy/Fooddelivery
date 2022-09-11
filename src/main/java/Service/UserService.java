package Service;

import DAO.UserRepo;
import Models.MenuItem;
import Models.Order;
import Models.Purchase;
import Models.User;

import java.util.List;

public class UserService {
    UserRepo ur;
    public UserService(){
        ur = new UserRepo();
    }

    public void addUser(int id,String username,String password,String firstname,String lastname){
       User existingUser = ur.getUserById(id);
        if(existingUser == null) {
           User newUser = new User(firstname,lastname);
           ur.addUser(newUser);
        }
    }
    public List<MenuItem> getAllMenuItems(){
        return ur.getAllMenuItems();
    }
    public void addMenuItem(int id,String menuitem,int prize){
     MenuItem existingMenuItem = ur.getMenuById(id);
     if(existingMenuItem == null){
         MenuItem newMenuItem = new MenuItem(id,menuitem,prize);
         ur.addMenuItem(newMenuItem);
      }
    }
    public void updateMenuItem(int id,String menuitem,int prize){
        MenuItem existingMenuItem = ur.getMenuById(id);
        if(existingMenuItem == null){
            MenuItem newMenuItem = new MenuItem(id,menuitem,prize);
            //ur.updateMenuItem(id,MenuItem);
        }
    }
    public void removeMenuItem(int id){
        MenuItem existingMenuItem = ur.getMenuById(id);
        if(existingMenuItem == null){
            MenuItem newMenuItem = new MenuItem(id);
            ur.removeMenuItem(id);
        }
    }

    public List<Purchase> getPurchaseByOrderId(int id){
        return ur.getPurchaseByOrderId(id);
    }
    public void addPurchase(int orderid,MenuItem menuitem){
        Purchase existingPurchase = ur.getPurchaseById();
        if(existingPurchase == null){
            Purchase newPurchase = new Purchase(orderid);
            ur.addPurchase(newPurchase);
        }

    }
    public List<Order> getOrderById(int id){
        return ur. getOrderById(id);
    }
    public void addOrder(int id,User user){
        Order existingOrder = ur.getOrderByPurchaseId();
        if(existingOrder == null){
            Order newOrder = new Order(id);
            ur.addOrder(newOrder);
        }
    }


}
