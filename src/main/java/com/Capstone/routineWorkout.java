package com.Capstone;
import java.sql.Timestamp;
import java.util.List;
import java.util.Set;
import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.*;

@Entity
@Table(name="routineWorkouts")
public class routineWorkout {
	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    //@Column(name = "routineWorkout_id")
    long routineWorkout_id;
	
	@ManyToOne(cascade = CascadeType.MERGE)
    @JoinColumn(name = "workout_id")
	//@JsonIgnoreProperties("routine_workouts")
	//@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property="workout_id")
	Workout workout;
	
	@ManyToOne(cascade = CascadeType.MERGE)
    @JoinColumn(name = "routine_id")
	@JsonIgnoreProperties("routineWorkouts")
	//@JsonIgnoreProperties("routine_workouts")
	//@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property="routine_id")
	Routine routine;
	
	// additional fields
    long sets;
    long reps;
    
    public long getRoutineWorkout_id() {
		return routineWorkout_id;
	}
	public void setRoutineWorkout_id(long routineWorkout_id) {
		this.routineWorkout_id = routineWorkout_id;
	}
	
	
	public Workout getWorkout() {
		return workout;
	}
	public void setWorkout(Workout workout) {
		this.workout = workout;
	}
	
	
	public Routine getRoutine() {
		return routine;
	}
	public void setRoutine(Routine routine) {
		this.routine = routine;
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
