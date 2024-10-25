package com.programming.techie.Model;

import jakarta.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "assurance_habitation")
public class AssuranceHabitation extends Assurance {

    @NotNull(message = "Property value cannot be null")
    private Double valeurDuBien;

    @NotBlank(message = "Housing type cannot be blank")
    private String typeDeLogement; // appartement, maison, etc.

    @NotBlank(message = "Location cannot be blank")
    private String localisation; // zone à risque

    private String systemeDeSecurite; // alarme, caméras

    // Getters and Setters
    public Double getValeurDuBien() {
        return valeurDuBien;
    }

    public void setValeurDuBien(Double valeurDuBien) {
        this.valeurDuBien = valeurDuBien;
    }

    public String getTypeDeLogement() {
        return typeDeLogement;
    }

    public void setTypeDeLogement(String typeDeLogement) {
        this.typeDeLogement = typeDeLogement;
    }

    public String getLocalisation() {
        return localisation;
    }

    public void setLocalisation(String localisation) {
        this.localisation = localisation;
    }

    public String getSystemeDeSecurite() {
        return systemeDeSecurite;
    }

    public void setSystemeDeSecurite(String systemeDeSecurite) {
        this.systemeDeSecurite = systemeDeSecurite;
    }
}
