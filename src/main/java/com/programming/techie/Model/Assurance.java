package com.programming.techie.Model;

import jakarta.persistence.*;

@Entity
@Inheritance(strategy = InheritanceType.JOINED) // Using Joined strategy for inheritance
@Table(name = "assurances")
public abstract class Assurance {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "user_id", referencedColumnName = "id")
    private User user; // Assuming there is a 'User' entity with an 'id' column

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    // Getters and Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
