package service;

import models.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import repository.UserRepository;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {
    @Autowired
    public UserRepository userRepository;
    User saveUser(User user){
        return this.userRepository.save(user);
    };
    Optional<User> getUserById(Long id){
        return this.userRepository.findById(id) ;
    };
    List<User> getUsers(){
        return this.userRepository.findAll();
    };
    User updateUser(User user){
        return this.userRepository.save(user);
    };

}
