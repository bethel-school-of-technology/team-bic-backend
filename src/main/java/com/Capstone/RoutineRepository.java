package com.Capstone;
import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;



public interface RoutineRepository extends JpaRepository<Routine, Long>{
	Optional<Routine> findById(Long routine_id);
	
	//need to search for user_id within user object
	List<Routine> findByUserUserId(Long user_id);
	
}
