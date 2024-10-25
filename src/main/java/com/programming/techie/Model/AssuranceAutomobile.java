package com.programming.techie.Model;

import jakarta.persistence.*;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;

@Entity
@Table(name = "assurance_automobile")
public class AssuranceAutomobile extends Assurance {

    @Min(value = 18, message = "Driver age must be at least 18")
    private Integer ageDuConducteur;

    @NotBlank(message = "Vehicle type cannot be blank")
    private String typeDeVehicule; // modèle, marque, type (luxe, utilitaire, etc.)

    @NotBlank(message = "Vehicle usage cannot be blank")
    private String utilisationDuVehicule; // privée, professionnelle

    private String historiqueDeConduite; // accidents, infractions

    // Getters and Setters
    public Integer getAgeDuConducteur() {
        return ageDuConducteur;
    }

    public void setAgeDuConducteur(Integer ageDuConducteur) {
        this.ageDuConducteur = ageDuConducteur;
    }

    public String getTypeDeVehicule() {
        return typeDeVehicule;
    }

    public void setTypeDeVehicule(String typeDeVehicule) {
        this.typeDeVehicule = typeDeVehicule;
    }

    public String getUtilisationDuVehicule() {
        return utilisationDuVehicule;
    }

    public void setUtilisationDuVehicule(String utilisationDuVehicule) {
        this.utilisationDuVehicule = utilisationDuVehicule;
    }

    public String getHistoriqueDeConduite() {
        return historiqueDeConduite;
    }

    public void setHistoriqueDeConduite(String historiqueDeConduite) {
        this.historiqueDeConduite = historiqueDeConduite;
    }
}

