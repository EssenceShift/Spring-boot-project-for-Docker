package ru.sergeyyy.microservice.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.sergeyyy.microservice.model.User;
import ru.sergeyyy.microservice.repository.UserRepository;

import java.util.List;
@Service
public class UserService {


    private final UserRepository userRepository;

    @Autowired
    private UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }



    public User findById(Long id){
        return userRepository.getById(id);
    }
    public List<User> findAll(){
        return userRepository.findAll();
    }

    public User addUser(User user){
        return userRepository.save(user);
    }
    public void deleteById(Long id){
        userRepository.deleteById(id);
    }
    public User updateUser(User user) {
        return userRepository.save(user);
    }
}
