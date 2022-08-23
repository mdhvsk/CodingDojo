package com.madhavasok.LoginAndRegistration.repositories;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.madhavasok.LoginAndRegistration.models.User;

@Repository
public interface UserRepo extends CrudRepository <User, Long>{
	Optional <User> findByEmail(String email);
	
}
