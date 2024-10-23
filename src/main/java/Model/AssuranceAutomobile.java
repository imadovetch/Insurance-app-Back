package Model;

import jakarta.persistence.*;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "assurance_automobile")
public class AssuranceAutomobile {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull(message = "Age du conducteur ne peut pas être nul")
    @Min(value = 18, message = "L'âge minimum est de 18 ans")
    private Integer ageConducteur;

    @NotBlank(message = "Type de véhicule est obligatoire")
    private String typeVehicule;

    @NotBlank(message = "Utilisation du véhicule est obligatoire")
    private String utilisationVehicule;

    @NotNull(message = "Historique de conduite est obligatoire")
    private Boolean historiqueConduite; // true = sans sinistre, false = avec sinistre

    @Column(nullable = false)
    private Double primeMensuelle; // Calculée à partir des règles

    // Constructors, getters, and setters

    public AssuranceAutomobile() {
    }

    public AssuranceAutomobile(Integer ageConducteur, String typeVehicule, String utilisationVehicule, Boolean historiqueConduite, Double primeMensuelle) {
        this.ageConducteur = ageConducteur;
        this.typeVehicule = typeVehicule;
        this.utilisationVehicule = utilisationVehicule;
        this.historiqueConduite = historiqueConduite;
        this.primeMensuelle = primeMensuelle;
    }

    // Getters and Setters

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getAgeConducteur() {
        return ageConducteur;
    }

    public void setAgeConducteur(Integer ageConducteur) {
        this.ageConducteur = ageConducteur;
    }

    public String getTypeVehicule() {
        return typeVehicule;
    }

    public void setTypeVehicule(String typeVehicule) {
        this.typeVehicule = typeVehicule;
    }

    public String getUtilisationVehicule() {
        return utilisationVehicule;
    }

    public void setUtilisationVehicule(String utilisationVehicule) {
        this.utilisationVehicule = utilisationVehicule;
    }

    public Boolean getHistoriqueConduite() {
        return historiqueConduite;
    }

    public void setHistoriqueConduite(Boolean historiqueConduite) {
        this.historiqueConduite = historiqueConduite;
    }

    public Double getPrimeMensuelle() {
        return primeMensuelle;
    }

    public void setPrimeMensuelle(Double primeMensuelle) {
        this.primeMensuelle = primeMensuelle;
    }
}
