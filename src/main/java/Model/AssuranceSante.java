package Model;

import jakarta.persistence.*;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "assurance_sante")
public class AssuranceSante {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull(message = "Âge est obligatoire")
    @Min(value = 0, message = "L'âge doit être supérieur ou égal à 0")
    private Integer age;

    @NotNull(message = "Antécédents médicaux sont obligatoires")
    private Boolean antecedentsMedicaux; // true = antécédents, false = sans antécédents

    @NotBlank(message = "Type de couverture est obligatoire")
    private String typeCouverture; // 'de base' ou 'premium'

    @Column(nullable = false)
    private Double primeMensuelle; // Calculée à partir des règles

    // Constructors, getters, and setters

    public AssuranceSante() {
    }

    public AssuranceSante(Integer age, Boolean antecedentsMedicaux, String typeCouverture, Double primeMensuelle) {
        this.age = age;
        this.antecedentsMedicaux = antecedentsMedicaux;
        this.typeCouverture = typeCouverture;
        this.primeMensuelle = primeMensuelle;
    }

    // Getters and Setters

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public Boolean getAntecedentsMedicaux() {
        return antecedentsMedicaux;
    }

    public void setAntecedentsMedicaux(Boolean antecedentsMedicaux) {
        this.antecedentsMedicaux = antecedentsMedicaux;
    }

    public String getTypeCouverture() {
        return typeCouverture;
    }

    public void setTypeCouverture(String typeCouverture) {
        this.typeCouverture = typeCouverture;
    }

    public Double getPrimeMensuelle() {
        return primeMensuelle;
    }

    public void setPrimeMensuelle(Double primeMensuelle) {
        this.primeMensuelle = primeMensuelle;
    }
}
