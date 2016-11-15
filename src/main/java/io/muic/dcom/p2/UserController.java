package io.muic.dcom.p2;

import spark.Request;
import spark.Response;
import spark.Route;

import static spark.Spark.*;
public class UserController {
    public UserController(final UserService userService){
        get("/users", new Route() {
            @Override
            public Object handle(Request request, Response response) throws Exception {
                return userService.getAllUser();
            }
        });
    }

    public static void main(String[] args) {
        new UserController(new UserService());
    }
}
