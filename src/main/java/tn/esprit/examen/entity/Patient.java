package tn.esprit.examen.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
public class Patient {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idPatient;

    private String nomPatient;

    private int telephone;

    private Date dateNaissance;

    @OneToMany(mappedBy = "patient")
    @JsonIgnore
    private List<RendezVous> rendezVousList;

    // Constructeur sans arguments
    public Patient() {
    }

    // Constructeur avec tous les champs
    public Patient(Long idPatient, String nomPatient, int telephone, Date dateNaissance, List<RendezVous> rendezVousList) {
        this.idPatient = idPatient;
        this.nomPatient = nomPatient;
        this.telephone = telephone;
        this.dateNaissance = dateNaissance;
        this.rendezVousList = rendezVousList;
    }

    // Getters et Setters
    public Long getIdPatient() {
        return idPatient;
    }

    public void setIdPatient(Long idPatient) {
        this.idPatient = idPatient;
    }

    public String getNomPatient() {
        return nomPatient;
    }

    public void setNomPatient(String nomPatient) {
        this.nomPatient = nomPatient;
    }

    public int getTelephone() {
        return telephone;
    }

    public void setTelephone(int telephone) {
        this.telephone = telephone;
    }

    public Date getDateNaissance() {
        return dateNaissance;
    }

    public void setDateNaissance(Date dateNaissance) {
        this.dateNaissance = dateNaissance;
    }

    public List<RendezVous> getRendezVousList() {
        return rendezVousList;
    }

    public void setRendezVousList(List<RendezVous> rendezVousList) {
        this.rendezVousList = rendezVousList;
    }

    // Méthode toString
    @Override
    public String toString() {
        return "Patient{" +
                "idPatient=" + idPatient +
                ", nomPatient='" + nomPatient + '\'' +
                ", telephone=" + telephone +
                ", dateNaissance=" + dateNaissance +
                ", rendezVousList=" + rendezVousList +
                '}';
    }
}
