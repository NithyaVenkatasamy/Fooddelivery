package Util;


import Models.MenuItem;
import Models.User;
import Service.UserService;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.javalin.Javalin;
import io.javalin.core.JavalinConfig;

import java.util.logging.Logger;

//import java.util.logging.Logger;


public class LoginUser {

    public static void main(String[] args) {
        Logger logger = Logger.getLogger("LoginUser.class");
        logger.info("info text");

        UserService us = new UserService();
        Javalin app = Javalin.create(JavalinConfig::enableCorsForAllOrigins).start(7078);

       // Javalin app = Javalin.create().start(7071);

        app.get("/users/",ctx->{
            ctx.json(us.getAllUsers());
        });
        app.get("/userid/{id}", ctx ->
        {
            ctx.json(us.getUserById(Integer.parseInt(ctx.pathParam("id"))));
        });
        app.post("register",ctx->{
            ObjectMapper mapper = new ObjectMapper();
            User requestUser = mapper.readValue(ctx.body(),User.class);
            us.addUser(requestUser.getUsername(),requestUser.getPassword(),requestUser.getFirstName(), requestUser.getLastName());

        });
        app.get("/FoodOrder/", ctx -> {ctx.json(us.getAllMenuItems());});

        app.post("menuitems",ctx->{
            ObjectMapper mapper = new ObjectMapper();
            MenuItem requestMenuItem = mapper.readValue(ctx.body(), MenuItem.class);
            us.addMenuItem(requestMenuItem.getMenuitem(),requestMenuItem.getPrize());
        });

       app.put("/users/{id}",ctx->{
           ObjectMapper mapper = new ObjectMapper();
           User requestUser = mapper.readValue(ctx.body(),User.class);
           us.updateUser(requestUser.getFirstName(),requestUser.getLastName(), Integer.parseInt(ctx.pathParam("id")));
        });

       app.delete("/users/{id}",ctx->{
          // ObjectMapper mapper = new ObjectMapper();
          // User requestUser = mapper.readValue(ctx.body(),User.class);
           us.removeUSer(Integer.parseInt(ctx.pathParam("id")));
       });
    }



    }
