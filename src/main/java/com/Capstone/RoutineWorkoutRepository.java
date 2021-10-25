package com.Capstone;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

public interface RoutineWorkoutRepository extends JpaRepository<routineWorkout, Long> {
	Optional<routineWorkout> findById(Long routineWorkout_id);
}


