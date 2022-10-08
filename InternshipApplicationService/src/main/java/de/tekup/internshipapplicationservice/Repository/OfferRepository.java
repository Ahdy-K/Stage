package de.tekup.internshipapplicationservice.Repository;

import de.tekup.internshipapplicationservice.models.Offer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface OfferRepository extends JpaRepository<Offer,Long> {
    Offer findOfferById(Long Id);
    List<Offer> findOfferByEntrepriseId(Long entrepriseId);

}
