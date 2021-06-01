package com.example.test.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.test.model.Engineer;
import com.example.test.repository.EngineerRepository;

@RestController
@RequestMapping("/api/v1")
public class EngineerController {

	@Autowired
	private EngineerRepository engineerRepository;

	//	get all emp
	@GetMapping("/engineers")
	public List<Engineer> getAllEngineers(){
		return this.engineerRepository.findAll();
	}	
	//get emp by id
	@GetMapping("/engineers/{id}")
	public ResponseEntity<Engineer> getEngById(@PathVariable(value="id") Long id) throws ResourceNotFoundException{
		
		Engineer eng= engineerRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Resource not found for the id " + id));
		return ResponseEntity.ok(eng);
	}
	//post employee
	@PostMapping("engineers")
	public Engineer createEngineer(@RequestBody Engineer eng){
	
		return this.engineerRepository.save(eng);
	}
	
	//update emp
	@PutMapping("engineers/{id}")
	public ResponseEntity<Engineer> updateEngineer(@PathVariable(value = "id") Long id , @RequestBody Engineer eng) 
			throws ResourceNotFoundException{
			
		Engineer e= engineerRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Resource not found for the id " + id));
		
		e.setDept(eng.getDept());
		e.setId(eng.getId());
		e.setName(eng.getName());
		return ResponseEntity.ok(this.engineerRepository.save(e));
	}
	
	//delete emp
	@DeleteMapping("engineers/{id}")
	public Map<String, Boolean> deleteEngineer(@PathVariable(value = "id") Long id) throws ResourceNotFoundException{
		Engineer e= engineerRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Resource not found for the id " + id));
		this.engineerRepository.delete(e);
		Map<String, Boolean> m= new HashMap<>();
		m.put("deleted", Boolean.TRUE);
		return m;
		
	}
	
}