package com.Capstone;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

@RestController
public class routineWorkoutController {
	@Autowired
    RoutineWorkoutRepository dao;
	
	@Autowired
    RoutineRepository routine_dao;
	
	@Autowired
    WorkoutRepository workout_dao;

	private Object get;
	
	
	@GetMapping("/showRoutineWorkouts/{routineWorkout_id}")
    public ResponseEntity<routineWorkout> getRoutineWorkouts(@PathVariable(value="routineWorkout_id") Long routineWorkout_id) {
        routineWorkout foundRoutineWorkout= dao.findById(routineWorkout_id).orElse(null);

        if(foundRoutineWorkout == null) {
            return ResponseEntity.notFound().header("routineWorkout","Nothing found with that id").build();
        }
        return ResponseEntity.ok(foundRoutineWorkout);
    }
    
    @DeleteMapping("/deleteRoutineWorkout/{routineWorkout_id}")
    public ResponseEntity<routineWorkout> deleteRoutineWorkout(@PathVariable(value="routineWorkout_id") Long routineWorkout_id) {
        routineWorkout foundRoutineWorkout = dao.findById(routineWorkout_id).orElse(null);

        if(foundRoutineWorkout == null) {
            return ResponseEntity.notFound().header("RoutineWorkout","Nothing found with that id").build();
        }else {
            dao.delete(foundRoutineWorkout);
        }
        return ResponseEntity.ok().build();
    }
    
    @PostMapping("/createRoutineWorkout")
	 public ResponseEntity<routineWorkout> postRoutineWorkout(@RequestBody CreateRoutineWorkoutRequest createRoutineWorkoutRequest) {
	    
		routineWorkout rw = new routineWorkout();
		//Routine routine = (Routine) routine_dao.get(Routine.class, createRoutineWorkoutRequest.routine_id);
		//Workout workout = (Workout) workout_dao.get(Workout.class, createRoutineWorkoutRequest.workout_id);
		Routine routine = (Routine) routine_dao.findById(createRoutineWorkoutRequest.routine_id).orElse(null);
		Workout workout = (Workout) workout_dao.findById(createRoutineWorkoutRequest.workout_id).orElse(null);
		rw.setReps(createRoutineWorkoutRequest.reps);
		rw.setReps(createRoutineWorkoutRequest.sets);
		
		rw.setWorkout(workout);
		rw.setRoutine(routine);
		
		
		routineWorkout createdRw= dao.save(rw);
		
		return ResponseEntity.ok(createdRw);
		
	}
    
    
    /*
	@PostMapping("/createRoutineWorkout")
	public ResponseEntity<routineWorkout> postRoutineWorkout(@RequestBody routineWorkout routineWorkout) {
	
	    
		// Saving to DB using an instance of the repo interface.
		routineWorkout createdRoutineWorkout = dao.save(routineWorkout);
		
	    // RespEntity crafts response to include correct status codes.
	    return ResponseEntity.ok(createdRoutineWorkout);
		
		
		
	}
    */
    
	@PutMapping("/editRoutineWorkout/{id}")
	public ResponseEntity<routineWorkout> putRoutine(@PathVariable(value="routineWorkout_id") Long routineWorkout_id) {
	    
	    routineWorkout foundRoutineWorkout = dao.findById(routineWorkout_id).orElse(null);

	    return ResponseEntity.ok(foundRoutineWorkout);
	}
}
