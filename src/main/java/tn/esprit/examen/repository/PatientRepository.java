package tn.esprit.examen.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import tn.esprit.examen.entity.Patient;

public interface PatientRepository extends JpaRepository<Patient, Long> {
}
