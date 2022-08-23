package com.madhavasok.bookclub.models;

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
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Table(name="books")
public class Book {
//	Primary Key
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
//	Member variables
	@NotNull
	@Size(min = 3, max = 50)
	private String title;
	
	@NotNull
	@Size(min = 3, max = 50)
	private String author;
	
	@NotEmpty
	private String thoughts;
	
	
//  Data Creation Trackers
	@Column(updatable = false)
	private Date createdAt;
	private Date updatedAt;
	
//	Relationships
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="user_id")
	private User user;
	
//	Constructors
	public Book() {
		
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




	public Long getId() {
		return id;
	}




	public void setId(Long id) {
		this.id = id;
	}




	public String getTitle() {
		return title;
	}




	public void setTitle(String title) {
		this.title = title;
	}




	public String getAuthor() {
		return author;
	}




	public void setAuthor(String author) {
		this.author = author;
	}




	public String getThoughts() {
		return thoughts;
	}




	public void setThoughts(String thoughts) {
		this.thoughts = thoughts;
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
	
//	Getters and Setters
	
	
}
