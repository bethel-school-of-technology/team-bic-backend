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
public class RoutineController {
	@Autowired
    RoutineRepository dao;
	
	
	@GetMapping("/checkRoutine/{routine_id}")
    public ResponseEntity<Routine> getRoutines(@PathVariable(value="routine_id") Long routine_id) {
        Routine foundRoutine= dao.findById(routine_id).orElse(null);

        if(foundRoutine == null) {
            return ResponseEntity.notFound().header("Routine","Nothing found with that id").build();
        }
        return ResponseEntity.ok(foundRoutine);
    }
	
	
	@PostMapping("/createRoutine")
	public ResponseEntity<Routine> postRoutine(@RequestBody Routine routine) {

	    // Saving to DB using an instance of the repo interface.
	    Routine createdRoutine = dao.save(routine);

	    // RespEntity crafts response to include correct status codes.
	    return ResponseEntity.ok(createdRoutine);
	}
	
	@PutMapping("/editRoutine/{routine_id}")
	//public ResponseEntity<Routine> putRoutine(@PathVariable(value="routine_id") Long routine_id) {
	public ResponseEntity<Routine> putRoutine(@PathVariable(value="routine_id") Long routine_id, @RequestBody Routine routine) {  
	    Routine foundRoutine = dao.findById(routine_id).orElse(null);
	    		
	    if (foundRoutine == null) {
	    	return ResponseEntity.ok(foundRoutine);
	    }
	    Routine updatedRoutine = dao.save(routine);
	    
	    
	    return ResponseEntity.ok(updatedRoutine);
	}
}
	

