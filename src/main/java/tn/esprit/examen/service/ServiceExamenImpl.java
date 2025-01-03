package tn.esprit.examen.service;

import lombok.extern.slf4j.Slf4j;
import org.apache.juli.logging.Log;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import tn.esprit.examen.entity.*;
import tn.esprit.examen.repository.CliniqueRepository;
import tn.esprit.examen.repository.MedecinRepository;
import tn.esprit.examen.repository.PatientRepository;
import tn.esprit.examen.repository.RendezVousRepository;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.logging.log4j.*;

@Service
@Slf4j
public class ServiceExamenImpl implements IserviceExamen{

    @Autowired
    private CliniqueRepository cliniqueRepository;
    @Autowired
    private MedecinRepository medecinRepository;
    @Autowired
    private PatientRepository patientRepository;
    @Autowired
    private RendezVousRepository rendezVousRepository;




    @Override
    public Clinique addClinique(Clinique clinique) {
        return cliniqueRepository.save(clinique);
    }

    @Override
    public Medecin addMedecinandAssignToClinique(Medecin medecin, Long cliniqueId) {

        Clinique clinique=cliniqueRepository.findById(cliniqueId).orElse(null);
        List<Medecin> list=new ArrayList<>();
        list.add(medecin);
        if(clinique.getMedecins()==null){
            clinique.setMedecins(list);
        }else{
            clinique.getMedecins().add(medecin);
        }
        return medecinRepository.save(medecin);
      }

    @Override
    public Patient addPatient(Patient patient) {
        return patientRepository.save(patient);
    }

    @Override
    public RendezVous addRDVandAssignMedAndPatient(RendezVous rdv, Long idMedecin, Long idPatient) {
            Medecin medecin=medecinRepository.findById(idMedecin).orElse(null);
            Patient patient=patientRepository.findById(idPatient).orElse(null);
            rdv.setMedecin(medecin);
            rdv.setPatient(patient);
            return rendezVousRepository.save(rdv);
    }

    @Override
    public List<RendezVous> getRendezVousByCliniqueAndSpecialite(Long idClinique, Specialite specialite) {
      Clinique clinique=cliniqueRepository.findById(idClinique).orElse(null);
      List<RendezVous>list=rendezVousRepository.findAll();
      List<RendezVous> resultat=new ArrayList<>();
      for(RendezVous r:list){
          if(r.getMedecin().getCliniques()!=null){
              for(Clinique c:r.getMedecin().getCliniques()){
                  if(clinique.equals(c) && r.getMedecin().getSpecialite().equals(specialite)){
                      resultat.add(r);
                  }
              }
          }
      }
      return resultat;
    }

    @Override
    public int getNbrRendezVousMedecin(Long idMedecin) {
        int nb=0;
        Medecin m=medecinRepository.findById(idMedecin).orElse(null);
        List<RendezVous> list=rendezVousRepository.findAll();
        for(RendezVous r:list){
            if(r.getMedecin().equals(m)){
                nb++;
            }
        }
        return nb;
    }


    @Override
    public int getRevenueMedecin(Long idMedecin, Date startDate, Date endDate) {
        int nb=0;
        Medecin m=medecinRepository.findById(idMedecin).orElse(null);
        List<RendezVous> list=rendezVousRepository.findAll();
        for(RendezVous r:list){
            if(r.getMedecin().equals(m) && r.getDateRDV().after(startDate) && r.getDateRDV().before(endDate)){
                nb++;
            }
        }
        return m.getPrixConsultation()*nb;
    }

    @Scheduled(cron = "*/30 * * * * *")
    public void retrieveRendezVous(){
       List<RendezVous> list=rendezVousRepository.findAll();
       for(RendezVous r:list){
           if(r.getDateRDV().after(new Date())){

           }
       }
    }





}
