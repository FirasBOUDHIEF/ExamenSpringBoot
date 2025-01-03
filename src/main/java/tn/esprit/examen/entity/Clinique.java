package tn.esprit.examen.entity;

import jakarta.persistence.*;
import java.util.List;

@Entity
public class Clinique {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idClinique;

    private String nomClinique;

    private String adresse;

    private int telephone;

    @ManyToMany
    private List<Medecin> medecins;

    // Constructeur sans arguments
    public Clinique() {
    }

    // Constructeur avec tous les champs
    public Clinique(Long idClinique, String nomClinique, String adresse, int telephone, List<Medecin> medecins) {
        this.idClinique = idClinique;
        this.nomClinique = nomClinique;
        this.adresse = adresse;
        this.telephone = telephone;
        this.medecins = medecins;
    }

    // Getters et Setters
    public Long getIdClinique() {
        return idClinique;
    }

    public void setIdClinique(Long idClinique) {
        this.idClinique = idClinique;
    }

    public String getNomClinique() {
        return nomClinique;
    }

    public void setNomClinique(String nomClinique) {
        this.nomClinique = nomClinique;
    }

    public String getAdresse() {
        return adresse;
    }

    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }

    public int getTelephone() {
        return telephone;
    }

    public void setTelephone(int telephone) {
        this.telephone = telephone;
    }

    public List<Medecin> getMedecins() {
        return medecins;
    }

    public void setMedecins(List<Medecin> medecins) {
        this.medecins = medecins;
    }

    // Méthode toString
    @Override
    public String toString() {
        return "Clinique{" +
                "idClinique=" + idClinique +
                ", nomClinique='" + nomClinique + '\'' +
                ", adresse='" + adresse + '\'' +
                ", telephone=" + telephone +
                ", medecins=" + medecins +
                '}';
    }
}
