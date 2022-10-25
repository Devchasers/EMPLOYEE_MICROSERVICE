package esprit.fgsc.EMPLOYEESMICROSERVICES.services;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import esprit.fgsc.EMPLOYEESMICROSERVICES.entities.Employee;
import esprit.fgsc.EMPLOYEESMICROSERVICES.repository.IEmployeRepository;


@Service
public class EmployeService {
	
	@Autowired
	private IEmployeRepository employeRepository;

public Employee addEmployee(Employee employee) {
		return employeRepository.save(employee);
		
	}
	
	public List<Employee>getAllEmployees(){
		 return employeRepository.findAll();
	}
	
	public void deleteEmployee(String id) {   
		employeRepository.deleteById(id);
    	
	}
           
public Employee updateEmployee(String id,Employee newEmployee) {
	if(employeRepository.findById(id).isPresent()) {
		Employee existingEmployee = employeRepository.findById(id).get();
		existingEmployee.setFirstName(newEmployee.getFirstName());
		existingEmployee.setLastName(newEmployee.getLastName());
		existingEmployee.setAddress(newEmployee.getAddress());
		existingEmployee.setEmail(newEmployee.getEmail());
		existingEmployee.setTel(newEmployee.getTel());
		existingEmployee.setDesignation(newEmployee.getDesignation());
		existingEmployee.setGender(newEmployee.getGender());
		existingEmployee.setBirthDate(newEmployee.getBirthDate());
	    existingEmployee.setJoinDate(newEmployee.getJoinDate());  
		return employeRepository.save(existingEmployee);
		
	}else {
		return null;
	}
}

public Employee getEmployeeById(String id) {
	return employeRepository.findById(id).get();
	
}
}
