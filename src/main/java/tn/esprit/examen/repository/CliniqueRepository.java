package tn.esprit.examen.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import tn.esprit.examen.entity.Clinique;

public interface CliniqueRepository extends JpaRepository<Clinique, Long> {
}
