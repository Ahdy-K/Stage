package de.tekup.UserService.ressource;

import de.tekup.UserService.models.User;
import de.tekup.UserService.service.FileStorageService;
import lombok.SneakyThrows;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.configurationprocessor.json.JSONObject;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import de.tekup.UserService.service.UserService;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
///
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.*;
import java.util.stream.Collectors;

@RestController
@CrossOrigin(origins="*")
@RequestMapping("/api-user")

public class UserController {

    @Autowired
    private  UserService userService;
    @Autowired
    private  RestTemplate restTemplate;

    @Autowired
     private  FileStorageService fileStorageService;


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
    public Optional<User> updateUser(@PathVariable("userId") Long id, @RequestBody User user ){

            return Optional.ofNullable(this.userService.updateUser(id,user));//}else

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



    @PostMapping("/uploadFile/{userId}")
    public UploadFileResponse uploadFile(@RequestParam("file") MultipartFile file, @PathVariable("userId") String userId) {
        String fileName = fileStorageService.storeFile(file, userId);

        String fileDownloadUri = ServletUriComponentsBuilder.fromCurrentContextPath()
                .path("/downloadFile/")
                .path(fileName)
                .toUriString();

        return new UploadFileResponse(fileName, fileDownloadUri,
                file.getContentType(), file.getSize());
    }
    @DeleteMapping("/cv/delete/{fileName}")
    public String deleteFile(@PathVariable("fileName") String fileName){
        return this.fileStorageService.deleteFile(fileName);
    }
    // Download File:
    @SneakyThrows
    @GetMapping("/downloadFile/{fileName}")
    public ResponseEntity<Resource> downloadFile(@PathVariable String fileName, HttpServletRequest request) {
        // Load file as Resource
        Resource resource = fileStorageService.loadFileAsResource(fileName);

        // Try to determine file's content type
        String contentType = null;
        try {
            contentType = request.getServletContext().getMimeType(resource.getFile().getAbsolutePath());
        } catch (IOException ex) {
            throw new IOException("Could not determine file type.");
        }

        // Fallback to the default content type if type could not be determined
        if(contentType == null) {
            contentType = "application/octet-stream";
        }

        return ResponseEntity.ok()
                .contentType(MediaType.parseMediaType(contentType))
                .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"" + resource.getFilename() + "\"")
                .body(resource);
    }
// get url
    /*@GetMapping("/downloadFiles/{fileName}/{userId}")
    public String downloadCV(@PathVariable("fileName")String filename,@PathVariable("userId") Long userId){
        User user = this.userService.getUserById(userId);
        return user.getCV();
    }*/
    @GetMapping("/downloadF/{userId}")
    public Map<String, String> downloadCV(@PathVariable("userId") Long userId){
        User user = this.userService.getUserById(userId);
        String url = user.getCV();
        Map<String, String> map = new HashMap<>();
        map.put("url", url);
        //return ResponseEntity.ok().body(url);
        return map;
    }
    @GetMapping("/getUserProfile/{id}")
    public String getUserProfile(@PathVariable("id")Long id){
        return this.userService.getUserProfile(id);
    }


}
