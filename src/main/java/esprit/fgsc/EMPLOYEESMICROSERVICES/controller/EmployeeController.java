package esprit.fgsc.EMPLOYEESMICROSERVICES.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import esprit.fgsc.EMPLOYEESMICROSERVICES.entities.Employee;
import esprit.fgsc.EMPLOYEESMICROSERVICES.services.EmployeService;


@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/api")
public class EmployeeController {

	@Autowired
	private  EmployeService employeService;
	@PostMapping("/add")
	@ResponseStatus(HttpStatus.CREATED)
	public ResponseEntity<Employee> createEmployee(@RequestBody Employee employee) {
		return new ResponseEntity<>(employeService.addEmployee(employee), HttpStatus.OK);
	}
	
	@GetMapping("/employees")
	@ResponseStatus(HttpStatus.OK)
	public ResponseEntity<List<Employee> >getAllEmployees(){
		 return new ResponseEntity<>(employeService.getAllEmployees(),HttpStatus.OK);
	}
	
	@DeleteMapping("/delete/{id}")
	@ResponseStatus(HttpStatus.OK)
	public void deleteEmployee(@PathVariable String id) {
		employeService.deleteEmployee(id);
	}

	@PutMapping(value="/update/{id}")
	@ResponseStatus(HttpStatus.OK)
	public ResponseEntity<Employee> updateEmployee(@PathVariable("id") String id,@Valid @RequestBody Employee employee) {
		return new ResponseEntity<>(employeService.updateEmployee(id, employee),HttpStatus.OK);
	}
	
@GetMapping("/employee/{id}")
@ResponseStatus(HttpStatus.OK)
public ResponseEntity<Employee >getEmployeeById(@PathVariable("id") String id){
	 return new ResponseEntity<>(employeService.getEmployeeById(id),HttpStatus.OK);
		}

}
