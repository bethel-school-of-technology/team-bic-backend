package com.Capstone;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping
public class UserController {
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private MySQLUserDetailsService userService;
	
	@Autowired
    UserRepository dao;
	
	@Autowired
    RoutineRepository routine_dao;
	
	@PostMapping("/register")
	  public void register(@RequestBody User newUser) {
	    userService.Save(newUser);
	  }
	
	@GetMapping("/getAllRoutines/{user_id}")
	@ResponseBody
	public ResponseEntity<List<Routine>> findByUser_id(@PathVariable Long user_id) {

		List<Routine> routineResponse = (List<Routine>) routine_dao.findByUserUserId(user_id);
		return ResponseEntity.ok(routineResponse);
	}
	
	@PutMapping("/editUser/{user_id}")
	public ResponseEntity<User> putRoutine(@PathVariable(value="user_id") Long user_id, @RequestBody User user) {
	    
		User foundUser= dao.findById(user_id).orElse(null);
		
		if (foundUser == null) {
	    	return ResponseEntity.ok(foundUser);
	    }
		
		User updatedUser= dao.save(user);
	    return ResponseEntity.ok(updatedUser);
	}
	
	@GetMapping("/getAllUsers")
	public List<User> getUser() {
	    List<User> foundUser = dao.findAll();
	    return foundUser;
	}
	
	@GetMapping("/home/{user_id}")
    public ResponseEntity<User> getUser(@PathVariable(value="user_id") Long user_id) {
        User foundUser= dao.findById(user_id).orElse(null);

        if(foundUser == null) {
            return ResponseEntity.notFound().header("User","Nothing found with that id").build();
        }
        return ResponseEntity.ok(foundUser);
    }
	@GetMapping("/")
    public String getHomePage() {
        return "home";
    }
	@GetMapping("/secure")
    public String getSecurePage() {
        return "secure";
    }
	
    
    
	
	/*
	@PostMapping("/signUp")
	public ResponseEntity<User> postUser(@RequestBody User user) {

	    // Saving to DB using an instance of the repo interface.
	    User createdUser = dao.save(user);

	    // RespEntity crafts response to include correct status codes.
	    return ResponseEntity.ok(createdUser);
	}
	*/
	
    
	
}
