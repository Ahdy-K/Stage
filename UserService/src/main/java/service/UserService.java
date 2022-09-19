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
    public User saveUser(User user){
        return this.userRepository.save(user);
    };
    public User getUserById(Long id){
        return this.userRepository.findOneById(id) ;
    };
    public List<User> getUsers(){
        return this.userRepository.findAll();
    };
    public User updateUser(User user){
        return this.userRepository.save(user);
    };
    public String deleteUser(Long id){
        User user = this.getUserById(id);
        if(user!=null){
            this.userRepository.delete(user);
            return "User Deleted";
        }else return "No Such user";
    }
}
