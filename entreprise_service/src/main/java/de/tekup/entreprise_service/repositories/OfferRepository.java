package de.tekup.entreprise_service.repositories;

import de.tekup.entreprise_service.entities.Offer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OfferRepository extends JpaRepository<Offer,Long> {
    Offer getOfferById(Long id);
}
