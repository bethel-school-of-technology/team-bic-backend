package com.Capstone;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;


@RestController
public class WorkoutController {
	@Autowired
    WorkoutRepository dao;
	
	
	@GetMapping("/add_workout/{workout_id}")
    public ResponseEntity<Workout> getWorkouts(@PathVariable(value="workout_id") Long workout_id) {
        Workout foundWorkout= dao.findById(workout_id).orElse(null);

        if(foundWorkout == null) {
            return ResponseEntity.notFound().header("Workout","Nothing found with that id").build();
        }
        return ResponseEntity.ok(foundWorkout);
    }
	
	@PostMapping("/createWorkout")
	public ResponseEntity<Workout> postWorkout(@RequestBody Workout workout) {

	    // Saving to DB using an instance of the repo interface.
	    Workout createdWorkout= dao.save(workout);

	    // RespEntity crafts response to include correct status codes.
	    return ResponseEntity.ok(createdWorkout);
	}
}
