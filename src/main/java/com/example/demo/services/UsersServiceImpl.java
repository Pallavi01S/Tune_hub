package com.example.demo.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.Users;
import com.example.demo.repository.UsersRepository;

@Service
public class UsersServiceImpl implements UsersService{
    @Autowired
    UsersRepository repository;
	
	@Override
	public String addUser(Users users) {
		repository.save(users);
		return "User added successfully";
	}

	@Override
	public boolean emailExists(String email) {
		if(repository.findByEmail(email)==null) {
		return false;
		}
		else {
		return true;
		}
	}

	@Override
	public boolean validateUser(String email, String password) {
		Users users=repository.findByEmail(email);
		String db_pass=users.getPassword();
		if(password.equals(db_pass))
			return true;
		else
		    return false;
	}

	@Override
	public String getRole(String email) {
	    Users users=repository.findByEmail(email);
		return users.getRole();
	}

	@Override
	public Users getUser(String email) {
		return repository.findByEmail(email);
		
	}

	@Override
	public Users updateUser(Users user) {
		return repository.save(user);
		 
	}
	

}
