package com.academiavivere.semana3.services;


import com.academiavivere.semana3.exceptions.ResourceNotFoundException;
import com.academiavivere.semana3.models.User;
import com.academiavivere.semana3.repositories.UserRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public List<User> getAll(){
        return userRepository.findAll();
    }

    public User getById(int userId){
       return userRepository.findById(userId)
               .orElseThrow(() ->  new ResourceNotFoundException("User not found with id: " + userId));

    }

    public User createUser (User user) throws Exception {
        User userExists = userRepository.findByLogin(user.getLogin());
        if(userExists == null){
            return userRepository.save(user);
        }else {

            throw new Exception("login already exists");
        }
    }

    public User updateUser(User userUpdate, int userId){
       return userRepository.findById(userId).map(user ->{
           user.setName(userUpdate.getName());
           user.setLogin(userUpdate.getLogin());
           user.setPassword(userUpdate.getPassword());
           user.setPhone(userUpdate.getPhone());
           user.setEmail(userUpdate.getEmail());
           user.setProfile(userUpdate.getProfile());
           user.setStatus(userUpdate.getStatus());
           return userRepository.save(user);
       }).orElseThrow(() -> new ResourceNotFoundException("User not found with id: " + userId));
    }

    public void deleteUser (int userId){
        userRepository.delete(userRepository.findById(userId)
                .orElseThrow(() -> new ResourceNotFoundException("User not found with id: " + userId)));
    }

    public Iterable<User> getByNameAndEmail(String name, String email){
        return userRepository.findByNameAndEmail(name, email);
    }

    public Iterable<User> getByName(String name){
        return userRepository.findByName(name);
    }

    public Iterable<User> getByEmail(String email){
        return userRepository.findByEmail(email);
    }


    public String getByLogin(String login, String password){
        User user = userRepository.findByLogin(login);
        if(user.getLogin().equals(login) && user.getPassword().equals(password) && user.getStatus().getDescription().equals("A")){
             return "Welcome";
        }else{
            throw new ResourceNotFoundException("Access Denied");
        }
    }


}
