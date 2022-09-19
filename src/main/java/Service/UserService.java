package Service;

import DAO.UserRepo;
import Models.MenuItem;
import Models.Order;
import Models.Purchase;
import Models.User;

import java.sql.SQLException;
import java.util.List;

public class UserService {
    UserRepo ur;
    public UserService(){
        ur = new UserRepo();
    }

    public UserService(UserRepo ur)throws SQLException{
        this.ur=ur;
    }


    public void addUser(String username,String password,String firstname,String lastname){
        User newUser = new User(username,password,firstname,lastname);
           ur.addUser(newUser);

    }

    public User getUserById(int id){
        return ur.getUserById(id);
    }
    public List<User>getAllUsers(){return ur.getAllUsers();}

    public void updateUser(String firstname,String lastname,int id){
       // User newUser = new User(firstname,lastname);
        ur.updateUser(firstname,lastname,id);
    }
    public void removeUSer(int id){
       // User newUser = new User(id);
        ur.removeUser(id);
    }
    public List<MenuItem> getAllMenuItems(){
        return ur.getAllMenuItems();
    }
    public void addMenuItem(String menuitem,int prize){

         MenuItem newMenuItem = new MenuItem(menuitem,prize);
         ur.addMenuItem(newMenuItem);

    }
    public void updateMenuItem(int id,String menuitem,int prize){
        // MenuItem existingMenuItem = ur.getMenuById(id);

           MenuItem newMenuItem = new MenuItem(menuitem,prize);
            ur.updateMenuItem(id,menuitem,prize);

    }
    public void removeMenuItem(int id){
       // MenuItem existingMenuItem = ur.getMenuById(id);
      //  if(existingMenuItem == null){
            MenuItem newMenuItem = new MenuItem(id);
            ur.removeMenuItem(id);
      //  }
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
