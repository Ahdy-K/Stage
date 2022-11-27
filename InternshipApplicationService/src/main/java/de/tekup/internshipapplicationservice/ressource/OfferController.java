package de.tekup.internshipapplicationservice.ressource;

import de.tekup.internshipapplicationservice.Service.OfferService;
import de.tekup.internshipapplicationservice.models.Offer;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@RestController
@RequestMapping("/offers")
@CrossOrigin(origins = "*")
public class OfferController {
    @Autowired
    private OfferService offerService;

    @GetMapping("/alloffers")
    public List<Offer> getAllOffers(){
        return this.offerService.getOffers();
    }
    // get entreprise  offers
    @GetMapping("/entrepriseoffer/{entrepriseid}")
    public List<Offer> getUserApplications(@PathVariable("entrepriseid") Long entrepriseid){
        return this.offerService.getOfferByEntrepriseId(entrepriseid);
    }
    // get offer by id
    @GetMapping("/offer/{id}")
    public Offer getOffer(@PathVariable("id") Long id){
        return this.offerService.getOffer(id);
    }



    //save new offer to DB
    @PostMapping("/makeoffer/{enterpriseId}")
    public ResponseEntity<Offer> makeOffer(@PathVariable("enterpriseId") Long enterpriseId, @RequestBody Offer offer){

        return ResponseEntity.ok().body(this.offerService.makeOffer(enterpriseId,offer));
    }
    //update an offer
    @PutMapping("/updateoffer/{offerId}")
    //get userId to return only user applications
    public Offer updateOffer(@PathVariable("offerId") Long offerId,@RequestBody Offer offer){
        return this.offerService.updateOffer(offerId,offer);
    }
    @DeleteMapping("/deletoffer/{idoffer}")
    public void deleteoffer(@PathVariable("idoffer") Long idoffer){
        this.offerService.deleteOffer(idoffer);

    }
}
