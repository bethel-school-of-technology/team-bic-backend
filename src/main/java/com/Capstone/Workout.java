package com.Capstone;
import java.sql.Timestamp;
import java.util.HashSet;
import java.util.List;
import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import java.util.Set;


@Entity
@Table(name="workouts")
public class Workout {
	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
	private long workout_id;
	private String workout_name;
	private String photo_url;
	private String muscle_group;
	
	
	@OneToMany(mappedBy = "workout")
	//@JsonIgnoreProperties("workouts")
	@JsonIgnore
	//@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property="workout_id")
	private Set<routineWorkout> routineWorkouts = new HashSet<routineWorkout>();
	
	public String getMuscle_group() {
		return muscle_group;
	}
	public void setMuscle_group(String muscle_group) {
		this.muscle_group = muscle_group;
	}

	public long getWorkout_id() {
		return workout_id;
	}
	public void setWorkout_id(int workout_id) {
		this.workout_id = workout_id;
	}
	public String getWorkout_name() {
		return workout_name;
	}
	public void setWorkout_name(String workout_name) {
		this.workout_name = workout_name;
	}
	public String getPhoto_url() {
		return photo_url;
	}
	public void setPhoto_url(String photo_url) {
		this.photo_url = photo_url;
	}
	
    public Set<routineWorkout> getRoutineWorkouts() {
        return routineWorkouts;
    }
}
