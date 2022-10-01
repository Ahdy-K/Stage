package de.tekup.UserService.ressource;

import de.tekup.UserService.models.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import de.tekup.UserService.service.UserService;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin(origins="*")
@RequestMapping("/api-user")
public class UserController {
    @Autowired
    private UserService userService;
    @Autowired
    private RestTemplate restTemplate;
    @GetMapping("/all")
    public List<User> getAllUsers(){
        return userService.getUsers();
    }
    @GetMapping("/get/{userId}")
    public User getUser(@PathVariable("userId") Long userId ){
        return this.userService.getUserById(userId);
    }
    @GetMapping("/get-user/{email}")
    public User getUserByEmail(@PathVariable("email") String email ){
        return this.userService.getUserByEmail(email);
    }
    @PostMapping("/add/user")
    public User addUser(@RequestBody User user ){
        return this.userService.saveUser(user);
    }
    @PutMapping("/update/{userId}")
    public Optional<User> updateUser(@RequestBody User user ){
        User userToUpdate= this.userService.getUserById(user.getId());
        if(userToUpdate!=null){
            return Optional.ofNullable(this.userService.updateUser(userToUpdate));
        }else
            return null;
    }
    @DeleteMapping("/delete/{userId}")
    public String  deleteUser(@PathVariable("userId") Long userId ){
        return this.userService.deleteUser(userId);
    }

    @GetMapping("/offers")
    public List<Object> getOffers() {
        Object[] objects = restTemplate.getForObject("http://entreprise-service/api-entreprise/entreprises", Object[].class);
        return Arrays.asList(objects);
    }

}
