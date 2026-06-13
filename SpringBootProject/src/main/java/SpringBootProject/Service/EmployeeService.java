package SpringBootProject.Service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import SpringBootProject.Entity.Employee;
import SpringBootProject.Exception.ResourceNotFoundException;
import SpringBootProject.Repository.EmployeeRpository;

@Service
public class EmployeeService {
	@Autowired
 private EmployeeRpository repository;
	
	 public Employee saveEmployee(Employee employee) {
	        return repository.save(employee);
	    }

	    public List<Employee> getAllEmployees() {
	        return repository.findAll();
	    }
	  //GET EMPLOYEE BY ID
//	    public Employee getEmployeeById(Long id) {
//	        return repository.findById(id).orElse(null);
//	    }
	    
	    
	    // i am writing for this purpose is exception handling 
	    public Employee getEmployeeById(Long id) {

	        return repository.findById(id)
	                .orElseThrow(() ->
	                new ResourceNotFoundException("Employee Not Found"));
	    }
	    
	    //UPDATE   http://localhost:8082/employee/update/1
	    
	    public Employee updateEmployee(Long id, Employee employee) {

	        Employee emp = repository.findById(id).orElse(null);

	        emp.setName(employee.getName());
	        emp.setEmail(employee.getEmail());
	        emp.setSalary(employee.getSalary());

	        return repository.save(emp);
	    }
	    public String deleteEmployee(Long id) {

	        repository.deleteById(id);

	        return "Employee Deleted Successfully";
	    }
	    //only one recored we can add in json formate
	    public Employee getEmployeeByName(String name) {
	        return repository.findByName(name);
	    }
	    public List<Employee> saveAllEmployees(List<Employee> employees) {
	        return repository.saveAll(employees);
	    }
	    //pagination 
	    public Page<Employee> getEmployees(int page, int size) {

	        Pageable pageable = PageRequest.of(page, size);

	        return repository.findAll(pageable);
	    }
	    
	    //sorting
	    public List<Employee> getSortedEmployees(String field) {

	        return repository.findAll(Sort.by(field));
	    }
	  
	}

