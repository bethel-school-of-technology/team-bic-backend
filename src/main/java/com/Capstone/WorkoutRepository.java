package com.Capstone;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;


public interface WorkoutRepository extends JpaRepository<Workout, Long>{
	Optional<Workout> findById(Long workout_id);
	
	//Workout get(Class<Workout> class1, long workout_id);
}
