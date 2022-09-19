package ressource;

import models.User;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins="*")
@RequestMapping("/user")
public class UserController {
    @GetMapping("/all")
    public List<User> getAllUsers(){
        return null;
    }
    @GetMapping("/get/{userId}")
    public User getUser(@PathVariable("userId") String userId ){
        return new User();
    }
    @PostMapping("/add/user")
    public User addUser(@RequestBody User user ){
        return new User();
    }
    @PutMapping("/update/{userId}")
    public User updateUser(@RequestBody String userId ){
        return new User();
    }
    @DeleteMapping("/delete/{userId}")
    public User deleteUser(@PathVariable("userId") String userId ){
        return new User();
    }
}
