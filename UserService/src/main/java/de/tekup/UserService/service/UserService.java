package de.tekup.UserService.service;

import de.tekup.UserService.models.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import de.tekup.UserService.repository.UserRepository;

import java.util.List;

@Service
public class UserService {
    @Autowired
    private  BCryptPasswordEncoder encoder;
    @Autowired
    public UserRepository userRepository;
    public User saveUser(User user){
        user.setPassword(encoder.encode(user.getPassword()));
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

    public User getUserByEmail(String email) {

        return userRepository.findUserByEmail(email);

    }
}
