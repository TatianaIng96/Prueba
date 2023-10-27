package com.example.Prueba.models;

import jakarta.persistence.*;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
@Table(name = "user")
public class User {
   @Id
	 @GeneratedValue(strategy = GenerationType.IDENTITY)
	 @Column(unique = true, nullable = false)
	 private Long id;
	 private String name;
	 private Integer age;
	 private String email;
	
	 @JsonManagedReference
	 @OneToMany(cascade=CascadeType.ALL, fetch=FetchType.LAZY, mappedBy = "user")
	 private List<Bill> bills;
	 
	    public User() {
	    }

	    public User(String name, Integer age, String email) {
	        this.name = name;
	        this.age = age;
	        this.email = email;
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

	    public List<Bill> getBills() {
	        return bills;
	    }

	    public void setBills(List<Bill> bills) {
	        this.bills = bills;
	    }

}
