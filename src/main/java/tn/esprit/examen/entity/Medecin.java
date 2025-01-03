package tn.esprit.examen.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import java.util.List;

@Entity
public class Medecin {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idMedecin;

    private String nomMedecin;

    @Enumerated(EnumType.STRING)
    private Specialite specialite;

    private int telephone;

    private int prixConsultation;

    @ManyToMany(mappedBy = "medecins")
    @JsonIgnore
    private List<Clinique> cliniques;

    @OneToMany(mappedBy = "medecin")
    @JsonIgnore
    private List<RendezVous> rendezVousList;

    // Constructeur sans arguments
    public Medecin() {
    }

    // Constructeur avec tous les champs
    public Medecin(Long idMedecin, String nomMedecin, Specialite specialite, int telephone, int prixConsultation,
                   List<Clinique> cliniques, List<RendezVous> rendezVousList) {
        this.idMedecin = idMedecin;
        this.nomMedecin = nomMedecin;
        this.specialite = specialite;
        this.telephone = telephone;
        this.prixConsultation = prixConsultation;
        this.cliniques = cliniques;
        this.rendezVousList = rendezVousList;
    }

    // Getters et Setters
    public Long getIdMedecin() {
        return idMedecin;
    }

    public void setIdMedecin(Long idMedecin) {
        this.idMedecin = idMedecin;
    }

    public String getNomMedecin() {
        return nomMedecin;
    }

    public void setNomMedecin(String nomMedecin) {
        this.nomMedecin = nomMedecin;
    }

    public Specialite getSpecialite() {
        return specialite;
    }

    public void setSpecialite(Specialite specialite) {
        this.specialite = specialite;
    }

    public int getTelephone() {
        return telephone;
    }

    public void setTelephone(int telephone) {
        this.telephone = telephone;
    }

    public int getPrixConsultation() {
        return prixConsultation;
    }

    public void setPrixConsultation(int prixConsultation) {
        this.prixConsultation = prixConsultation;
    }

    public List<Clinique> getCliniques() {
        return cliniques;
    }

    public void setCliniques(List<Clinique> cliniques) {
        this.cliniques = cliniques;
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
        return "Medecin{" +
                "idMedecin=" + idMedecin +
                ", nomMedecin='" + nomMedecin + '\'' +
                ", specialite=" + specialite +
                ", telephone=" + telephone +
                ", prixConsultation=" + prixConsultation +
                ", cliniques=" + cliniques +
                ", rendezVousList=" + rendezVousList +
                '}';
    }
}
