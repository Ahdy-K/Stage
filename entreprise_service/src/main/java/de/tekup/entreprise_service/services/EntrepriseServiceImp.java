package de.tekup.entreprise_service.services;

import de.tekup.entreprise_service.entities.Entreprise;
import de.tekup.entreprise_service.entities.Offer;
import de.tekup.entreprise_service.repositories.EntrepriseRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;
@Service
@RequiredArgsConstructor
public class EntrepriseServiceImp implements  EntrepriseService {
    @Override
    public UserDetails loadUserByUsername(String username) {
        Entreprise en=entrepriseRepository.findEntrepriseByEmail(username);
        return new User(en.getEmail(),en.getPassword(), Collections.emptyList());
    }

    private final EntrepriseRepository entrepriseRepository;
   // private final OfferRepository offerRepository;
    private final BCryptPasswordEncoder passwordEncoder;
    @Override
    public Entreprise saveEntreprise(Entreprise entreprise) {
        entreprise.setPassword(passwordEncoder.encode(entreprise.getPassword()));
        return entrepriseRepository.save(entreprise);
    }

    @Override
    public Entreprise getEntrepriseByEmail(String Email) {
        return entrepriseRepository.findEntrepriseByEmail(Email);
    }

    @Override
    public void deleteEntreprise(Long id) {
        Entreprise entreprise=entrepriseRepository.findEntrepriseById(id);
        entrepriseRepository.delete(entreprise);

    }

    @Override
    public Entreprise updateEntreprise(Long id, Entreprise newEntreprise) {
        Entreprise entreprise=entrepriseRepository.findEntrepriseById(id);
        if(newEntreprise.getName()!=null)
            entreprise.setName(newEntreprise.getName());
        if(newEntreprise.getDescription()!=null)
            entreprise.setDescription(newEntreprise.getDescription());
        if(newEntreprise.getStatus()!=null)
            entreprise.setStatus(newEntreprise.getStatus());
        if(newEntreprise.getPassword()!=null)
            entreprise.setPassword(passwordEncoder.encode(newEntreprise.getPassword()));



        return entrepriseRepository.save(entreprise) ;
    }

    @Override
    public Entreprise getEntreprise(String name) {
        return entrepriseRepository.findEntrepriseByName(name);
    }

    @Override
    public Entreprise getEntrepriseById(Long Id) {
        return entrepriseRepository.findEntrepriseById(Id);
    }
    @Override
    public List<Entreprise> getEntreprises() {
        return entrepriseRepository.findAll();
    }

  /*  @Override
    public void makeOffer(Entreprise entreprise, Offer offer) {
        offer.setEntreprise(entreprise);
        offerRepository.save(offer);

    }

    @Override
    public List<Offer> getOffers() {
        return offerRepository.findAll();
    }



    @Override
    public Offer getOffer(Long id) {
        return offerRepository.getOfferById(id);
    }

    @Override
    public Offer updateOffer(Long id , Offer newOffer) {
        Offer offer =offerRepository.getOfferById(id);
        if(newOffer.getSubject()!=null)
            offer.setSubject(newOffer.getSubject());
        if(newOffer.getTechnologies()!=null)
            offer.setTechnologies(newOffer.getTechnologies());
        if (newOffer.getType()!=null)
            offer.setType(newOffer.getType());
        return offerRepository.save(offer);
    }

    @Override
    public void deletOffer(Long id) {
        Offer offer=offerRepository.getOfferById(id);
        offerRepository.delete(offer);



    }*/
}
