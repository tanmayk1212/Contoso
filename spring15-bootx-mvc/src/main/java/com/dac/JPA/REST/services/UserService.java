package com.dac.JPA.REST.services;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dac.JPA.REST.entites.User;
import com.dac.JPA.REST.repository.UserRepository;
@Service
public class UserService {
	

		@Autowired
		UserRepository useRepo;
		
		public String[] getCompleteEmployee() {
			List<User> arr = (List<User>) useRepo.findAll();
			String[] data = new String[arr.size()];
			return data;
		}
}
