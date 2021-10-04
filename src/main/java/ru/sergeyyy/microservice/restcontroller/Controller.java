package ru.sergeyyy.microservice.restcontroller;


import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import ru.sergeyyy.microservice.model.User;
import ru.sergeyyy.microservice.service.UserService;

import java.util.List;

@RestController
public class Controller {
    
    private final UserService userService;
    private Object User;


    public Controller(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/api/test")
    public String getTest() {
        return HttpStatus.OK.name();
    }
    @GetMapping("/api/user/{id}")
    public String getUser(@PathVariable Long id) {
        User user = userService.findById(id);
        return String.format("User: %s %s %s",user.getId(),user.getFirstName(),user.getLastName());
    }
    @GetMapping("/api/user/all")
    public String getUserAll() {
        GsonBuilder builder = new GsonBuilder();
        Gson gson = builder.create();
        List<User> users = userService.findAll();
        return gson.toJson(users);
    }
    @PostMapping(path = "/api/user/add", consumes = "application/json", produces = "application/json")
    public String addUser(@RequestBody User user)  {
        try{
            userService.addUser(user);
            return "Successful";
        }
        catch(Throwable throwable){
            return throwable.getMessage();
        }
    }
    @DeleteMapping("/api/delete/{id}")
    public String deleteUser(@PathVariable Long id)  {
        try{
            userService.deleteById(id);
            return "Successful";
        }
        catch(Throwable throwable){
            return throwable.getMessage();
        }
    }
    @PutMapping(path = "/api/user/put", consumes = "application/json", produces = "application/json")
    public String updateUser(@RequestBody User user)  {
        try{
            userService.updateUser(user);
            return "Successful";
        }
        catch(Throwable throwable){
            return throwable.getMessage();
        }
    }
}
