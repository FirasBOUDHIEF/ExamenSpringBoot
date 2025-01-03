package tn.esprit.examen.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import tn.esprit.examen.entity.Medecin;

public interface MedecinRepository extends JpaRepository<Medecin, Long> {
}
