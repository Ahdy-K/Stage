package de.tekup.entreprise_service.controllers;

import de.tekup.entreprise_service.entities.Entreprise;
import de.tekup.entreprise_service.entities.Offer;
import de.tekup.entreprise_service.services.EntrepriseService;

import lombok.RequiredArgsConstructor;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.security.Principal;


@RestController
@CrossOrigin(origins = "*")
@RequiredArgsConstructor
@RequestMapping("/api-entreprise")
public class entrepriseController {
    private final EntrepriseService entrepriseService;
    private final RestTemplate restTemplate;
    @GetMapping("/entreprise/{name}")
    public ResponseEntity<?> getEntreprise(@PathVariable String name){
        Entreprise entreprise=entrepriseService.getEntreprise(name);
        if(entreprise!=null)
            return  ResponseEntity.ok().body(entreprise);
        else
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Entreprise Not Found");
    }
    @GetMapping("/get-entreprise/{email}")
    public ResponseEntity<?> getEntrepriseByEmail(@PathVariable String email){
        Entreprise entreprise=entrepriseService.getEntrepriseByEmail(email);
        if(entreprise!=null)
            return  ResponseEntity.ok().body(entreprise);
        else
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Entreprise Not Found");
    }

    @GetMapping("/entreprises")
    public ResponseEntity<?> getEntreprises(){
        return  ResponseEntity.ok().body(entrepriseService.getEntreprises());
    }

    @PostMapping("/addEntreprise")
    public ResponseEntity<?> addEntreprise(@RequestBody Entreprise entreprise){
        entrepriseService.saveEntreprise(entreprise);
        return ResponseEntity.ok().build();

    }

    @PostMapping("/deleteEntreprise/{id}")
    public ResponseEntity<?> deleteEntreprise(@PathVariable Long id) {

        try{
            entrepriseService.deleteEntreprise(id);
            return ResponseEntity.noContent().build();
        }
        catch (EmptyResultDataAccessException e){
            return ResponseEntity.notFound().build();
        }
    }
    
    
    @PutMapping("/updateEntreprise/{id}")
    public ResponseEntity<?> updateEntreprise(@PathVariable Long id,@RequestBody Entreprise newEntreprise){
        entrepriseService.updateEntreprise(id,newEntreprise);
        return ResponseEntity.ok().body(newEntreprise);
        
    }



    @PostMapping("/makeoffer/{enterpriseId}")
    public ResponseEntity<?> makeOffer(@PathVariable("enterpriseId") Long enterpriseId,@RequestBody Offer offer){
        ResponseEntity<?> responseEntity = restTemplate.
                postForEntity("http://localhost:9099/offers/makeoffer/{enterpriseId}", offer,Object.class,enterpriseId);
        return responseEntity;

    }

   /* @GetMapping("/offer/{id}")
    public ResponseEntity<?> getOffer(@PathVariable Long id){
        Offer offer=entrepriseService.getOffer(id);
        if(offer!=null)
            return  ResponseEntity.ok().body(offer);
        else
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Offer Not Found");
    }

    @GetMapping("/offers")
    public ResponseEntity<?> getOffers(){
        return  ResponseEntity.ok().body(entrepriseService.getOffers());
    }

    @PostMapping("/deleteOffer/{id}")
    public ResponseEntity<?> deleteOffer(@PathVariable Long id) {

        try{
            entrepriseService.deletOffer(id);
            return ResponseEntity.noContent().build();
        }
        catch (EmptyResultDataAccessException e){
            return ResponseEntity.notFound().build();
        }
    }


    @PutMapping("/updateOffer/{id}")
    public ResponseEntity<?> updateOffer(@PathVariable Long id,Offer offer){
        entrepriseService.updateOffer(id,offer);
        return ResponseEntity.ok().body(offer);

    }
*/


}
