package com.dac.JPA.REST.entites;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="BajajUser")
public class User {
	
//	1. Status
//	2. User ID
//	3. Email ID
//	4. College Roll Number
//	5. Array for numbers
//	6. Array for alphabets
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	
	private boolean is_success;
	private String user_id;
	private String email;
	private String roll_number;
	private String[] numbers;
	private String[] alphabets;
	private String data;
	
	
	public String getData() {
		return data;
	}
	public void setData(String data) {
		this.data = data;
	}
//	public String[] getNumbers() {
//		return numbers;
//	}
//	public void setNumbers(String[] numbers) {
//		this.numbers = numbers;
//	}
//	public String[] getAlphabets() {
//		return alphabets;
//	}
//	public void setAlphabets(String[] alphabets) {
//		this.alphabets = alphabets;
//	}
//	public User(boolean is_success, String user_id, String email, String roll_number, String[] numbers,
//			String[] alphabets) {
//		super();
//		this.is_success = is_success;
//		this.user_id = user_id;
//		this.email = email;
//		this.roll_number = roll_number;
//		this.numbers = numbers;
//		this.alphabets = alphabets;
//	}
//	public boolean isIs_success() {
//		return is_success;
//	}
//	public void setIs_success(boolean is_success) {
//		this.is_success = is_success;
//	}
//	public String getUser_id() {
//		return user_id;
//	}
//	public void setUser_id(String user_id) {
//		this.user_id = user_id;
//	}
//	public String getEmail() {
//		return email;
//	}
//	public void setEmail(String email) {
//		this.email = email;
//	}
//	public String getRoll_number() {
//		return roll_number;
//	}
//	public void setRoll_number(String roll_number) {
//		this.roll_number = roll_number;
//	}
	public char charAt(int i) {
		// TODO Auto-generated method stub
		return 0;
	}
	
	
	
	
}
