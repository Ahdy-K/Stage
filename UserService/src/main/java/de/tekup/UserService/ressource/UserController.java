package de.tekup.UserService.ressource;

import de.tekup.UserService.models.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
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
    public Optional<User> updateUser(@RequestBody User user ){
        User userToUpdate= this.userService.getUserById(user.getId());
        if(userToUpdate!=null){
            return Optional.ofNullable(this.userService.updateUser(userToUpdate));
        }else
            return null;
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



    @GetMapping("/getEntreprises")
    public ResponseEntity<?> getEntreprises() {
        Object objects = restTemplate.getForObject("http://localhost:8081/api-entreprise/entreprises", Object.class);
        return ResponseEntity.ok().body(objects);
    }

    @GetMapping("/getEntreprise/{id}")
    public ResponseEntity<?> getEntreprise(@PathVariable("id")Long id) {
        Object objects = restTemplate.getForObject("http://localhost:8081/api-entreprise/get-entreprise-by-id/{id}", Object.class,id);
        return ResponseEntity.ok().body(objects);
    }

    @PostMapping("/makerequest/{offerId}/{userId}")
    public ResponseEntity<?> makeRequest(@PathVariable("offerId") Long offerId,  @PathVariable("userId") Long userId)
    {
        ResponseEntity<?> responseEntity = restTemplate.
                postForEntity("http://localhost:9099/request/makerequest/{offerId}/{userId}", null,Object.class,offerId,userId);
        return ResponseEntity.ok().body(responseEntity);
    }
    @GetMapping("/getRequests")
    public ResponseEntity<?> getRequests() {
        Object objects = restTemplate.getForObject("http://localhost:9099/request/getRequests", Object.class);
        return ResponseEntity.ok().body(objects);
    }


}
