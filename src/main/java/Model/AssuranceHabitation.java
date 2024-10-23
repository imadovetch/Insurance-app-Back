package Model;

import jakarta.persistence.*;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "assurance_habitation")
public class AssuranceHabitation {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull(message = "Valeur du bien est obligatoire")
    @Min(value = 1, message = "La valeur du bien doit être supérieure à 0")
    private Double valeurBien;

    @NotBlank(message = "Type de logement est obligatoire")
    private String typeLogement;

    @NotBlank(message = "Localisation est obligatoire")
    private String localisation;

    @NotNull(message = "Système de sécurité est obligatoire")
    private Boolean systemeSecurite; // true = avec sécurité, false = sans sécurité

    @Column(nullable = false)
    private Double primeMensuelle; // Calculée à partir des règles

    // Constructors, getters, and setters

    public AssuranceHabitation() {
    }

    public AssuranceHabitation(Double valeurBien, String typeLogement, String localisation, Boolean systemeSecurite, Double primeMensuelle) {
        this.valeurBien = valeurBien;
        this.typeLogement = typeLogement;
        this.localisation = localisation;
        this.systemeSecurite = systemeSecurite;
        this.primeMensuelle = primeMensuelle;
    }

    // Getters and Setters

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Double getValeurBien() {
        return valeurBien;
    }

    public void setValeurBien(Double valeurBien) {
        this.valeurBien = valeurBien;
    }

    public String getTypeLogement() {
        return typeLogement;
    }

    public void setTypeLogement(String typeLogement) {
        this.typeLogement = typeLogement;
    }

    public String getLocalisation() {
        return localisation;
    }

    public void setLocalisation(String localisation) {
        this.localisation = localisation;
    }

    public Boolean getSystemeSecurite() {
        return systemeSecurite;
    }

    public void setSystemeSecurite(Boolean systemeSecurite) {
        this.systemeSecurite = systemeSecurite;
    }

    public Double getPrimeMensuelle() {
        return primeMensuelle;
    }

    public void setPrimeMensuelle(Double primeMensuelle) {
        this.primeMensuelle = primeMensuelle;
    }
}
