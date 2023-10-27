package com.example.Prueba.models;

import com.fasterxml.jackson.annotation.JsonBackReference;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;

@Entity
@Table(name = "bills")
public class Bill {
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
  	@Column(unique = true, nullable = false)
    private Long id;
    
	@Positive(message = "El monto total debe ser un número positivo.")
    private double totalAmount;

    @NotEmpty(message = "La descripción no puede estar vacía.")
    @Size(max = 200, message = "La descripción no puede tener más de 200 caracteres.")
    private String description;

    @JsonBackReference
    @ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name = "id_user")
    private User user;

    public Bill() {
    }

    public Bill(double totalAmount, String description) {
        this.totalAmount = totalAmount;
        this.description = description;
    }

    // Getters y setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public double getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(double totalAmount) {
        this.totalAmount = totalAmount;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
