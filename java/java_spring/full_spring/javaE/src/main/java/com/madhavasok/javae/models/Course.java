package com.madhavasok.javae.models;

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
import javax.persistence.PreUpdate;
import javax.persistence.Table;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;


@Entity
@Table(name = "courses")
public class Course {
	
//	Primary Key
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
//	Member Variables
	@NotNull (message = "Name required")
	@Size(min = 3, max = 50, message = "Name must be between 3 and 50 characters")
	private String name;
	
	@Size(min = 3, max = 50, message = "Instructor must be between 3 and 50 characters")
	private String instructor;
	
	@NotNull(message = "Price required")
	@Min(0)
	private double price;
	
	@NotNull (message = "Day required")
	@Size(min = 3, max = 50, message = "Day must be between 3 and 50 characters" )
	private String dayOfWeek;
	
	


	@NotNull (message = "Description required")
	@Size(min = 3, max = 50, message = "Description must be between 3 and 50 characters")
	private String description;
	
	
	
//	Data Creation Trackers
	@Column(updatable = false)
	private Date createdAt;
	private Date updatedAt;
	
//	Relationships
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="user_id")
	private User user;
	
//	Constructors
	public Course () {
		
	}
	
//	Data Creation Event
	@PrePersist
	protected void onCreate() {
		this.createdAt = new Date()
;	}
	
	@PreUpdate
	protected void onUpdate() {
		this.updatedAt = new Date();
	}
	
	
//	Getters and Setters


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

	public String getInstructor() {
		return instructor;
	}

	public void setInstructor(String instructor) {
		this.instructor = instructor;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public String getDayOfWeek() {
		return dayOfWeek;
	}

	public void setDayOfWeek(String dayOfWeek) {
		this.dayOfWeek = dayOfWeek;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
	
	public Date getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}

	public Date getUpdatedAt() {
		return updatedAt;
	}

	public void setUpdatedAt(Date updatedAt) {
		this.updatedAt = updatedAt;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}
	

}
