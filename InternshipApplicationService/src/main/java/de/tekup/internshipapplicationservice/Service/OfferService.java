package de.tekup.internshipapplicationservice.Service;

import de.tekup.internshipapplicationservice.Repository.OfferRepository;
import de.tekup.internshipapplicationservice.models.Offer;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
@RequiredArgsConstructor
public class OfferService {
    private final OfferRepository offerRepository;



    public Offer makeOffer(Long entrepriseId, Offer offer) {
        offer.setEntrepriseId(entrepriseId);
        return offerRepository.save(offer);

    }


    public List<Offer> getOffers() {
        return offerRepository.findAll();
    }




    public Offer getOffer(Long id) {
        return offerRepository.findOfferById(id);
    }


    public Offer updateOffer(Long id , Offer newOffer) {
        Offer offer =offerRepository.findOfferById(id);
        if(newOffer.getSubject()!=null)
            offer.setSubject(newOffer.getSubject());
        if(newOffer.getTechnologies()!=null)
            offer.setTechnologies(newOffer.getTechnologies());
        if (newOffer.getType()!=null)
            offer.setType(newOffer.getType());
        return offerRepository.save(offer);
    }


    public void deleteOffer(Long id) {
        Offer offer=offerRepository.findOfferById(id);
        offerRepository.delete(offer);

    }
    public List<Offer> getOfferByEntrepriseId(Long entrepriseId){
        return  offerRepository.findOfferByEntrepriseId(entrepriseId);

    }
}
