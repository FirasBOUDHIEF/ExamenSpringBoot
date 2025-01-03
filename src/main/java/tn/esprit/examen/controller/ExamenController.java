package tn.esprit.examen.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.*;
import tn.esprit.examen.entity.*;
import tn.esprit.examen.service.IserviceExamen;

import java.util.Date;
import java.util.List;


@RestController
public class ExamenController {

    @Autowired
    private IserviceExamen serviceExamen;

    @PostMapping("/addClinique")
    public Clinique addClinique(@RequestBody Clinique clinique) {
        return serviceExamen.addClinique(clinique);
    }

    @PostMapping("/addPatient")
    public Patient addPatient(@RequestBody Patient patient) {
        return serviceExamen.addPatient(patient);
    }

    @PostMapping("/addMedecinAndAssignToClinique/{idClinique}")
    public Medecin addMedecinAndAssignToClinique(@RequestBody Medecin medecin, @PathVariable Long idClinique){
        return  serviceExamen.addMedecinandAssignToClinique(medecin,idClinique);
    }

    @PostMapping("/addRDVAndAssignMedAndPatient/{idP}/{idM}")
    public  RendezVous addRDVAndAssignMedAndPatient(@RequestBody RendezVous rendezVous,@PathVariable Long idP,@PathVariable Long idM){
      return serviceExamen.addRDVandAssignMedAndPatient(rendezVous,idP,idM);
    }

    @GetMapping("/getRendezVousByCliniqueAndSpecialite/{idC}/{sp}")
    public List<RendezVous> getRDV(@PathVariable Long idC, @PathVariable Specialite sp){
       return serviceExamen.getRendezVousByCliniqueAndSpecialite(idC,sp);
    }

    @GetMapping("/getNbrRendezVousMedecin/{idM}")
    public int getNbrRendezVousMedecin(@PathVariable Long idM){
        return serviceExamen.getNbrRendezVousMedecin(idM);
    }

    @GetMapping("/getRevenue/{idM}/{startDate}/{endDate}")
    public int getRevenue(@PathVariable Long idM,
                          @PathVariable @DateTimeFormat(pattern = "yyyy-MM-dd")Date startDate,
                          @PathVariable @DateTimeFormat(pattern = "yyyy-MM-dd")Date endDate){
        return  serviceExamen.getRevenueMedecin(idM,startDate,endDate);
    }



}
