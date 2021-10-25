package com.Capstone;
import java.sql.Timestamp;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

@Entity
@Table(name="routines")
public class Routine {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long routine_id;
	private String routine_name;
	private String subtitle;
	private String muscle_group;
	private String photo_url;
	
	//@OneToMany(mappedBy = "routines")
	@ManyToOne
	@JoinColumn(name="user_id", nullable=false)
	@JsonIgnoreProperties("routines")
	@JsonProperty("user")
    User user;
	//private Set<User> users = new HashSet<>();
	
	
	@OneToMany(mappedBy = "routine")
	//@JsonIgnoreProperties("routines")
	//@JsonIgnore
	//@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property="routine_id")
	private Set<routineWorkout> routineWorkouts = new HashSet<routineWorkout>();
	
	
	
	
	public String getPhoto_url() {
		return photo_url;
	}
	public void setPhoto_url(String photo_url) {
		this.photo_url = photo_url;
	}
    
	public long getRoutine_id() {
		return routine_id;
	}
	public void setRoutine_id(int routine_id) {
		this.routine_id = routine_id;
	}
	public String getRoutine_name() {
		return routine_name;
	}
	public void setRoutine_name(String routine_name) {
		this.routine_name = routine_name;
	}
	public String getSubtitle() {
		return subtitle;
	}
	public void setSubtitle(String subtitle) {
		this.subtitle = subtitle;
	}
	public String getMuscle_group() {
		return muscle_group;
	}
	public void setMuscle_group(String muscle_group) {
		this.muscle_group = muscle_group;
	}
	
	
    public Set<routineWorkout> getRoutineWorkouts() {
        return routineWorkouts;
    }
	
}
