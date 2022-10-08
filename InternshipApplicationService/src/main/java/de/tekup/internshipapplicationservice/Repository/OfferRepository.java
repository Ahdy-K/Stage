package de.tekup.internshipapplicationservice.Repository;

import de.tekup.internshipapplicationservice.models.Offer;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface OfferRepository extends JpaRepository<Offer,Long> {
    Offer findOfferById(Long Id);
    List<Offer> findOfferByEntrepriseId(Long entrepriseId);

}
