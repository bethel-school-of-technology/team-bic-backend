package com.Capstone;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;



public interface UserRepository extends JpaRepository<User, Long> {
	User findByUsername(String username);
	
	//List<Routine> findByUser_id(Long user_id);
}
