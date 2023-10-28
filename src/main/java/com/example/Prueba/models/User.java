package com.example.Prueba.models;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
@Table(name = "user")
public class User {
   @Id
	 @GeneratedValue(strategy = GenerationType.IDENTITY)
	 @Column(unique = true, nullable = false)
	 private Long id;
   	 @NotBlank(message = "El nombre no puede estar en blanco")
   	 private String name;

     @Min(value = 18, message = "La edad debe ser mayor o igual a 18")
     private Integer age;

     @Email(message = "Debe ingresar una dirección de correo electrónico válida")
     private String email;
     
     @NotEmpty
     @Pattern(regexp = "^(?=.*[A-Za-z])(?=.*\\d).{8,}$", 
     	message = "La contraseña debe tener al menos 8 caracteres y contener letras y números.")
     private String password;
	
	 @JsonManagedReference
	 @OneToMany(cascade=CascadeType.ALL, fetch=FetchType.LAZY, mappedBy = "user")
	 private List<Bill> bills;
	 
	    public User() {
	    }

	    public User(String name, Integer age, String email, String password) {
	        this.name = name;
	        this.age = age;
	        this.email = email;
	        this.password = password;
	    }

	    // Getters y setters
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

	    public Integer getAge() {
	        return age;
	    }

	    public void setAge(Integer age) {
	        this.age = age;
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

	    public List<Bill> getBills() {
	        return bills;
	    }

	    public void setBills(List<Bill> bills) {
	        this.bills = bills;
	    }

}
