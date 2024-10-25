package com.programming.techie.Model;

import jakarta.persistence.*;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;

@Entity
@Table(name = "assurance_sante")
public class AssuranceSante extends Assurance {

    @Min(value = 0, message = "Age must be at least 0")
    private Integer age;

    private String etatDeSante; // antécédents médicaux

    @NotBlank(message = "Coverage type cannot be blank")
    private String typeDeCouverture; // de base, premium

    // Getters and Setters
    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getEtatDeSante() {
        return etatDeSante;
    }

    public void setEtatDeSante(String etatDeSante) {
        this.etatDeSante = etatDeSante;
    }

    public String getTypeDeCouverture() {
        return typeDeCouverture;
    }

    public void setTypeDeCouverture(String typeDeCouverture) {
        this.typeDeCouverture = typeDeCouverture;
    }
}
