package de.tekup.ipagatewayservice;

import com.fasterxml.jackson.databind.ObjectMapper;
import de.tekup.ipagatewayservice.DTO.userDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;
import org.springframework.http.HttpHeaders;

import java.util.Collections;

@RestController
@RequestMapping("/api")
@CrossOrigin(origins = "*")
public class ApiController {
   /* @Autowired
    private RestTemplate restTemplate;
    @PostMapping("/add-user")
    public userDto adduser(@RequestBody userDto user){

        // create headers
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(org.springframework.http.MediaType.APPLICATION_JSON);
        headers.setAccept(Collections.singletonList(MediaType.APPLICATION_JSON));

        // build the request
        HttpEntity<userDto> request = new HttpEntity<>(user, headers);
        userDto addedUser=restTemplate.postForObject("http://user-service/api-user/add/user",request,userDto.class);
       return addedUser;
    }
    @GetMapping("/get-user/{email}")
    public userDto getUserbyEmail(@PathVariable String email){
        ResponseEntity<Object> responseEntity =
                restTemplate.getForEntity("http://user-service/api-user/get-user/{email}", Object.class, email);
        Object object = responseEntity.getBody();
        ObjectMapper mapper = new ObjectMapper();
        userDto student = mapper.convertValue(object, userDto.class);
        return student;
    }
*/
}
