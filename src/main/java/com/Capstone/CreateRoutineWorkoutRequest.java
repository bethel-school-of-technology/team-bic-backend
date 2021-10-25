package com.Capstone;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

public class CreateRoutineWorkoutRequest {
	long workout_id;
	long routine_id;
	long sets;
    long reps;
	
	
	
	public long getWorkout_id() {
		return workout_id;
	}
	public void setWorkout_id(long workout_id) {
		this.workout_id = workout_id;
	}
	public long getRoutine_id() {
		return routine_id;
	}
	public void setRoutine_id(long routine_id) {
		this.routine_id = routine_id;
	}
	public long getSets() {
		return sets;
	}
	public void setSets(long sets) {
		this.sets = sets;
	}
	public long getReps() {
		return reps;
	}
	public void setReps(long reps) {
		this.reps = reps;
	}
	
    
    
}
