package com.madhavasok.beltExamDemo.models;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.PrePersist;
import javax.persistence.Table;
import javax.validation.constraints.Size;

@Entity
@Table(name = "robots")
public class Robot {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Size(min = 2, message = "Must be at least two characters")
	private String name;
	
	@Size(min = 2, message = "Must be at least two characters")
	private String weapon;
	
	@Size(min = 2, message = "Must be at least two characters")
	private String color;
	
	
	@Column(updatable=false)
	private Date createdAt;
	private Date updatedAt;
	


	public Robot() {
		
	}
	
	@PrePersist
	protected void onCreate() {
		this.createdAt = new Date();
	}
	@PrePersist
	protected void onUpdate() {
		this.createdAt = new Date();
	}
}
