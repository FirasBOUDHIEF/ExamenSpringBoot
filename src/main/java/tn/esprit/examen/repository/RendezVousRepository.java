package tn.esprit.examen.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import tn.esprit.examen.entity.RendezVous;

public interface RendezVousRepository extends JpaRepository<RendezVous,Long> {
}
