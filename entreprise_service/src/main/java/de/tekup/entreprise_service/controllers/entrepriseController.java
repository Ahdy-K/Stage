package de.tekup.entreprise_service.controllers;

import de.tekup.entreprise_service.entities.Entreprise;
import de.tekup.entreprise_service.entities.Offer;
import de.tekup.entreprise_service.services.EntrepriseService;

import lombok.RequiredArgsConstructor;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@CrossOrigin(origins = "*")
@RequiredArgsConstructor
@RequestMapping("/api")
public class entrepriseController {
    private final EntrepriseService entrepriseService;
    @GetMapping("/entreprise/{name}")
    public ResponseEntity<?> getEntreprise(@PathVariable String name){
        Entreprise entreprise=entrepriseService.getEntreprise(name);
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


    @PostMapping("/makeoffer/{id}")
    public ResponseEntity<?> makeOffer(@PathVariable Long id,@RequestBody Offer offer){
        Entreprise entreprise =entrepriseService.getEntrepriseById(id);
        entrepriseService.makeOffer(entreprise,offer);
        return ResponseEntity.ok().body(offer);

    }
    @GetMapping("/offer/{id}")
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



}
