package com.Capstone;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;



public interface RoutineRepository extends JpaRepository<Routine, Long>{
	Optional<Routine> findById(Long routine_id);
	
	//Routine get(Class<Routine> class1, long routine_id);

	
}
