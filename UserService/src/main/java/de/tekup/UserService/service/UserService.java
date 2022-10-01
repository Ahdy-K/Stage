package de.tekup.UserService.service;

import de.tekup.UserService.models.User;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import de.tekup.UserService.repository.UserRepository;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserService {

    public final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    public User saveUser(User user){
        user.setPassword(passwordEncoder.encode(user.getPassword()));
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
    public  User getUserByEmail(String email){
        return  this.userRepository.findUserByEmail(email);
    }
    public String deleteUser(Long id){
        User user = this.getUserById(id);
        if(user!=null){
            this.userRepository.delete(user);
            return "User Deleted";
        }else return "No Such user";
    }
}
