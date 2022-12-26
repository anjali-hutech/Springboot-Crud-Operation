package com.springboot.crud.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table(name = "employees" )
public class Employee {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;

	// @Column(name = "first_name", nullable=false)
		
	
	@Column(unique = true)
    private String firstName;
	
	// @Column(name = "last_name")
	private String lastName;
	// @Column(name="role")
	private String role;

	private String mail;

	private long phoneNumber;

}
