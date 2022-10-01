package de.tekup.entreprise_service.repositories;

import de.tekup.entreprise_service.entities.Entreprise;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EntrepriseRepository extends JpaRepository<Entreprise, Long> {

Entreprise findEntrepriseByName(String name);
Entreprise findEntrepriseById(Long id);
Entreprise findEntrepriseByEmail(String Email);
}
