package de.tekup.UserService.ressource;

import de.tekup.UserService.models.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import de.tekup.UserService.service.UserService;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
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
    public ResponseEntity<?> addUser(@RequestBody User user ){
        User u =userService.getUserByEmail(user.getEmail());
        if(u==null) {

            return ResponseEntity.ok().body(userService.saveUser(user));
        }
        else
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("User Exist In DB ");
    }
    @PutMapping("/update/{userId}")
    public Optional<User> updateUser(@PathVariable("userId") Long id,@RequestBody User user ){

            return Optional.ofNullable(this.userService.updateUser(id,user));//}else
          
    }
    // upload user CV
    @PostMapping("/cv/upload")
    public ResponseEntity<?> uploadCV( @RequestBody MultipartFile file ) {

        String fileName = file.getOriginalFilename();
        try {
            // C:\\Users\\Asus\\Downloads\\Project Stagi\\Stage
            file.transferTo(new File("C:\\Users\\Asus\\Downloads\\Project Stagi\\Stage\\storage\\" + fileName));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
        return ResponseEntity.ok("File uploaded successfully.");
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
