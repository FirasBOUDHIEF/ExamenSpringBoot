package tn.esprit.examen.entity;

import jakarta.persistence.*;
import java.util.Date;

@Entity
public class RendezVous {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idRDV;

    private Date dateRDV;

    private String remarque;

    @ManyToOne
    private Medecin medecin;

    @ManyToOne
    private Patient patient;

    // Constructeur sans arguments
    public RendezVous() {
    }

    // Constructeur avec tous les champs
    public RendezVous(Long idRDV, Date dateRDV, String remarque, Medecin medecin, Patient patient) {
        this.idRDV = idRDV;
        this.dateRDV = dateRDV;
        this.remarque = remarque;
        this.medecin = medecin;
        this.patient = patient;
    }

    // Getters et Setters
    public Long getIdRDV() {
        return idRDV;
    }

    public void setIdRDV(Long idRDV) {
        this.idRDV = idRDV;
    }

    public Date getDateRDV() {
        return dateRDV;
    }

    public void setDateRDV(Date dateRDV) {
        this.dateRDV = dateRDV;
    }

    public String getRemarque() {
        return remarque;
    }

    public void setRemarque(String remarque) {
        this.remarque = remarque;
    }

    public Medecin getMedecin() {
        return medecin;
    }

    public void setMedecin(Medecin medecin) {
        this.medecin = medecin;
    }

    public Patient getPatient() {
        return patient;
    }

    public void setPatient(Patient patient) {
        this.patient = patient;
    }

    // Méthode toString
    @Override
    public String toString() {
        return "RendezVous{" +
                "idRDV=" + idRDV +
                ", dateRDV=" + dateRDV +
                ", remarque='" + remarque + '\'' +
                ", medecin=" + (medecin != null ? medecin.getIdMedecin() : null) +
                ", patient=" + (patient != null ? patient.getIdPatient() : null) +
                '}';
    }
}
