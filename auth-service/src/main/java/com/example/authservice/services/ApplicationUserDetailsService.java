package com.example.authservice.services;

import com.example.authservice.AppStudent;
import com.example.authservice.AppUser;
import com.fasterxml.jackson.databind.ObjectMapper;
import net.minidev.json.JSONObject;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Collections;

@Service
public class ApplicationUserDetailsService implements UserDetailsService {
    //chercher un utilisateur par username
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        RestTemplate restTemplate = new RestTemplate();
        String substr=username.substring(username.indexOf("@"));
        String domain=substr.substring(1,substr.indexOf("."));
        System.out.println(domain);
        String types="";
        switch (domain){
            case "gmail":
                types="Student";
                break;
            case "yahoo":
                types="Student";
                break;
            case "hotmail":
                types="Student";
                break;
            default:
                types="Entreprise";
                break;


        }

        if(types.equals("Student")){
            ResponseEntity<Object> responseEntity =
                    restTemplate.getForEntity("http://localhost:9090/api-user/get-user/{email}", Object.class, username);
            Object object = responseEntity.getBody();
            ObjectMapper mapper = new ObjectMapper();
            AppStudent student = mapper.convertValue(object, AppStudent.class);
            return new User(student.getEmail(),student.getPassword(), Collections.emptyList());
        }
        else {
            ResponseEntity<Object> responseEntity =
                    restTemplate.getForEntity("http://localhost:8081/api-entreprise/get-entreprise/{email}", Object.class, username);
            Object object = responseEntity.getBody();
            ObjectMapper mapper = new ObjectMapper();
            AppUser user = mapper.convertValue(object, AppUser.class);
            return new User(user.getEmail(),user.getPassword(), Collections.emptyList());
        }



    }
}
