package de.tekup.entreprise_service.services;

import de.tekup.entreprise_service.entities.Entreprise;
import de.tekup.entreprise_service.entities.Offer;
import org.apache.catalina.User;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.List;

public interface EntrepriseService {
    Entreprise saveEntreprise(Entreprise entreprise );
    void deleteEntreprise(Long id );
    Entreprise updateEntreprise(Long id,Entreprise newEntreprise);
    Entreprise getEntreprise(String name);
    Entreprise getEntrepriseById(Long Id);
    Entreprise getEntrepriseByEmail(String Email);
    List<Entreprise> getEntreprises();

    UserDetails loadUserByUsername(String username);

/*
    void makeOffer(Entreprise entreprise, Offer offer);
    List<Offer> getOffers();

    Offer getOffer(Long id);

    Offer updateOffer(Long  id ,Offer newOffer);
    void deletOffer(Long id);*/

}
