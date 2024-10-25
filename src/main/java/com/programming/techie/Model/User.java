package com.programming.techie.Model;

import jakarta.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.validation.constraints.Min; // Import this for age validation
import java.time.LocalDate;

@Entity
@Table(name = "users") // Table name in the database
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "Name cannot be empty")
    @Column(nullable = false) // Ensure this field is not null in the database
    private String name;

    @NotBlank(message = "Email cannot be empty")
    @Email(message = "Email should be valid")
    @Column(nullable = false, unique = true) // Ensure this field is not null and unique
    private String email;

    @NotBlank(message = "Password cannot be empty")
    @Size(min = 6, message = "Password must be at least 6 characters")
    @Column(nullable = false) // Ensure this field is not null in the database
    private String password;

    @NotBlank(message = "Phone number cannot be empty")
    @Column(nullable = false) // Ensure this field is not null in the database
    private String phoneNumber;

    @NotBlank(message = "Address cannot be empty")
    @Column(nullable = false) // Ensure this field is not null in the database
    private String adresse;

    @NotNull(message = "Age cannot be null") // Use NotNull for integer validation
    @Min(value = 0, message = "Age must be at least 0") // Optional: enforce a minimum age
    private Integer age; // Change to Integer (wrapper class) to allow null values

    // Default constructor
    public User() {
    }

    // Parameterized constructor
    public User(String name, String email, String phoneNumber, String adresse, String password, Integer age) {
        this.name = name;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.adresse = adresse;
        this.password = password;
        this.age = age;
    }

    // Getters and Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getAdresse() {
        return adresse;
    }

    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", adresse='" + adresse + '\'' +
                ", age=" + age +
                '}';
    }
}
