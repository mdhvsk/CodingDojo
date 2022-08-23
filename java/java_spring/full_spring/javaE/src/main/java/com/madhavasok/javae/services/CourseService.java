package com.madhavasok.javae.services;

import java.awt.print.Book;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.madhavasok.javae.models.Course;
import com.madhavasok.javae.repositories.CourseRepo;



@Service
public class CourseService {
	@Autowired
	private CourseRepo cRepo;
	
	
	public List<Course> allCourses(){
		return cRepo.findAll();
	}
	
	public Course createCourse(Course course) {
		return cRepo.save(course);
	}
	
	public Course findCourse(Long id) {
		Optional<Course> optionalCourse = cRepo.findById(id);
		if(optionalCourse.isPresent()) {
			return optionalCourse.get();
		}
		return null;
	}
	
	public Course updateCourse(Course course) {
		
		return cRepo.save(course);
	}
	
	public void delete (Long id) {
		System.out.println("Got to service");

		cRepo.deleteById(id);
	}
}
