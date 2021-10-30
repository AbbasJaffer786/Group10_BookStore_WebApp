package com.Group10.bookstore.Users;

import com.Group10.bookstore.Users.User;
import org.springframework.web.bind.annotation.*;


@RestController
public class LoginController {
    public User user;

    @RequestMapping(value = "/login")
    public String login(){
        return "Login Screen";
    }

    /*
    @RequestMapping(value = "/login", method = RequestMethod.POST)

    public String login(@RequestBody User user) {
        user = user;
        return "Success";
    }
    */
}
