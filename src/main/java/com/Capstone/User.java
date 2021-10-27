package com.Capstone;
import java.util.HashSet;

import java.util.Set;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;  
import javax.persistence.*;

//add many to many relationships code here

@Entity
@Table(name="users")
public class User {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="user_id")
	private long userId;
	private String username;
	private String email;
	private String password;
	
	//@OneToMany(cascade = { CascadeType.ALL })
	//@JsonIgnoreProperties("users")
	@OneToMany(mappedBy="user")
	private Set <Routine> routines = new HashSet<>();
	
	
	public String getUsername() {
		return username;
	}
	public void setUsername(String user_name) {
		this.username = user_name;
	}
	
	public long getUser_id() {
		return userId;
	}
	public void setUser_id(long user_id) {
		this.userId = user_id;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public Set<Routine> getRoutines() {
		return routines;
	}
	public void setRoutines(Set<Routine> routines) {
		this.routines = routines;
	}
	
}
