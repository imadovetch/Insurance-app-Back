package com.programming.techie.Model;

import jakarta.persistence.*;

@Entity
@Table(name = "certifs")
public class Certif {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "assurance_id", referencedColumnName = "id")
    private Assurance assurance; // Foreign key to Assurance entity

    @Column(name = "path", nullable = false)
    private String path; // Path to certificate

    // Getters and Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Assurance getAssurance() {
        return assurance;
    }

    public void setAssurance(Assurance assurance) {
        this.assurance = assurance;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }
}
