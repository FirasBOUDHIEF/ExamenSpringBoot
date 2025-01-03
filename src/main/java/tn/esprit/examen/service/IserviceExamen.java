package tn.esprit.examen.service;

import tn.esprit.examen.entity.*;

import java.util.Date;
import java.util.List;

public interface IserviceExamen {

     Clinique addClinique(Clinique clinique);
     Medecin addMedecinandAssignToClinique(Medecin medecin, Long cliniqueId);
     Patient addPatient(Patient patient);
     RendezVous addRDVandAssignMedAndPatient(RendezVous rdv, Long idMedecin, Long idPatient);
     List<RendezVous> getRendezVousByCliniqueAndSpecialite(Long idClinique, Specialite specialite);
     int getNbrRendezVousMedecin(Long idMedecin);
     int getRevenueMedecin(Long idMedecin, Date startDate, Date endDate);

}
