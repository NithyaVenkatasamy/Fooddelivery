package DAO;

import Models.MenuItem;
import Models.Order;
import Models.Purchase;
import Models.User;
import Util.ConnectionUtil;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class UserRepo {
    Connection conn;

    public UserRepo() {

        conn = ConnectionUtil.getConnection();
    }
    public User getUserById(int id){
      try{
          PreparedStatement statement = conn.prepareStatement("select * from users where users.id=?");
          statement.setInt(1,id);
          ResultSet rs = statement.executeQuery();
          rs.next();
          User user = new User();
          user.setId(rs.getInt("id"));
          user.setEmailId(rs.getString("email_id"));
          user.setPassword(rs.getString("password"));
          user.setUsername(rs.getString("username"));
          user.setPhonenumber(rs.getString("phonenumber"));
          user.setFirstName(rs.getString("firstname"));
          user.setLastName(rs.getString("lastname"));
          return user;
      }catch(SQLException e) {
          e.printStackTrace();
      }
      return null;
    }
    public void addUser(User user){
        try{
            PreparedStatement statement = conn.prepareStatement("insert into users(username,password,firstname,lastname)values(?,?,?,?);");

            statement.setString(1,user.getUsername());
            statement.setString(2,user.getPassword());
            statement.setString(3,user.getFirstName());
            statement.setString(4,user.getLastName());

            statement.executeUpdate();
        }catch(SQLException e) {
            e.printStackTrace();
        }

    }
    public List<User>getAllUsers(){
        List<User>allUsers = new ArrayList<>();
        try{
            Statement statement = conn.createStatement();
            ResultSet rs = statement.executeQuery("select * from  users");
            while (rs.next()){
                User loadeduser = new User(rs.getInt("id"),rs.getString("username"),rs.getString("password"),rs.getString("firstName")
                        ,rs.getString("lastName"));
                allUsers.add(loadeduser);
            }

        }catch(SQLException e){
            e.printStackTrace();

        }
        return allUsers;
    }
    public void updateUser(String firstname,String lastname,int id){
        try{
            PreparedStatement statement = conn.prepareStatement("update users \n" +
                    "set firstname= ?,lastname= ?\n" +
                    "where users.id=?;");
            statement.setString(1,firstname);
            statement.setString(2,lastname);
            statement.setInt(3,id);
            statement.executeUpdate();

        }catch(SQLException e) {
            e.printStackTrace();
        }

    }
    public void removeUser(int id){
        try{
            PreparedStatement statement = conn.prepareStatement("DELETE from users where id = ?");
            statement.setInt(1,id);
            statement.executeUpdate();

        }catch(SQLException e) {
            e.printStackTrace();
        }

    }
    public List<MenuItem>getAllMenuItems(){
        List<MenuItem>allMenuItems = new ArrayList<>();
        try{
            Statement statement = conn.createStatement();
            ResultSet rs = statement.executeQuery("select * from menuitems");
            while (rs.next()){
                MenuItem loadedmenuItem = new MenuItem(rs.getString("menuitem"), rs.getInt("prize"));
               allMenuItems.add(loadedmenuItem);
            }
        }catch(SQLException e){
            e.printStackTrace();
        }
        return allMenuItems;

    }

    public MenuItem getMenuById(int id){
        try{
            PreparedStatement statement = conn.prepareStatement("select * from menuitems where menuitems.id=?");
            statement.setInt(1,id);
            ResultSet rs = statement.executeQuery();
            rs.next();
            MenuItem menu = new MenuItem();
            menu.setId(rs.getInt("id"));
            menu.setMenuitem(rs.getString("menuitems"));
            menu.setPrize(rs.getInt("prize"));
            return menu;
        }catch(SQLException e){
            e.printStackTrace();
        }

        return null;
    }
    public void addMenuItem(MenuItem menuItem){
        try{
            PreparedStatement statement = conn.prepareStatement("insert into menuitems(menuitem,prize)values(?,?)");
            statement.setString(1,menuItem.getMenuitem());
            statement.setInt(2,menuItem.getPrize());
            statement.executeUpdate();
        }catch(SQLException e){
            e.printStackTrace();
        }
    }
    public void updateMenuItem(int id,String menuitem,int prize){
    try{
        PreparedStatement statement = conn.prepareStatement("update menuitems set menuitem = ?,prize = ? \n" +
                "\twhere menuitems.id=?\n");
        statement.setString(1,menuitem);
        statement.setInt(2,prize);
        statement.setInt(3,id);
        statement.executeUpdate();

    }catch(SQLException e) {
        e.printStackTrace();
    }

    }
    public void removeMenuItem(int id){
        try{
            PreparedStatement statement = conn.prepareStatement("DELETE from menuitems where menuitems = ?");
            statement.setInt(1,id);
            statement.executeUpdate();

        }catch(SQLException e) {
            e.printStackTrace();
        }

    }

    public List<Purchase> getPurchaseByOrderId(int id){
        List<Purchase> purchase = new ArrayList<>();
        try{
            PreparedStatement statement = conn.prepareStatement("select * from purchases where order_id=?");
            statement.setInt(1,id);
            ResultSet rs = statement.executeQuery();
            while(rs.next()){
                Purchase p = new Purchase();
                p.setOrderid(rs.getInt("order_id"));
                p.setMenuitem(getMenuById(rs.getInt("menuitems_id")));
                purchase.add(p);
            }

        }catch(SQLException e){
            e.printStackTrace();
        }

        return purchase;
    }
    public void addPurchase(Purchase purchase){
        try{
            PreparedStatement statement = conn.prepareStatement("insert into purchases(menuitems_id,order_id)values(?,?)");
            statement.setString(1,purchase.toString());
            statement.setInt(2,purchase.getOrderid());
        }catch(SQLException e){
            e.printStackTrace();
        }

    }
    public List<Order> getOrderById(int id){
        List<Order> order = new ArrayList<>();
        try{
            PreparedStatement statement = conn.prepareStatement("select * from orders where orders.id=?");
            statement.setInt(1,id);
            ResultSet rs = statement.executeQuery();
            while(rs.next()){
                Order o = new Order();
                o.setUser(getUserById(rs.getInt("user_id")));
               // o.setPurchases(getPurchaseByOrderId(rs.getInt("")));
                order.add(o);
            }
        }catch(SQLException e){
            e.printStackTrace();
        }
        return order;
    }
    public void addOrder(Order order){
        try{
            PreparedStatement statement = conn.prepareStatement("insert into orders(user_id)values(?)");
            statement.setInt(1,order.getId());

        }catch(SQLException e){
            e.printStackTrace();
        }

    }


    public Purchase getPurchaseById() {
        return null;
    }

    public Order getOrderByPurchaseId() {
        return null;
    }
}
