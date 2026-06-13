package SpringBootProject.Controller;

import java.util.List;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import SpringBootProject.Entity.Employee;
import SpringBootProject.Service.EmployeeService;

@RestController
@RequestMapping("/employee")
public class EmployeeController {
	 @Autowired
	    private EmployeeService service;
	 
	 
	 //SAVE EMPLOYEE
	 @PostMapping("/save")
	    public Employee saveEmployee(@RequestBody Employee employee) {
	        return service.saveEmployee(employee);
	    }
	 
	 //GET EMPLOYEE
	 @GetMapping("/all")
	    public List<Employee> getAllEmployees() {
	        return service.getAllEmployees();
	    }
	 
	 //GET EMPLOYEE BY ID
	 @GetMapping("/{id}")
	 public Employee getEmployeeById(@PathVariable Long id) {
	     return service.getEmployeeById(id);
	 }
	 //UPDATE  EMPLOYEE   http://localhost:8082/employee/update/1  --> AFTER UPDATE WRITE A QUERY  http://localhost:8082/employee/1
	 @PutMapping("/update/{id}")
	 public Employee updateEmployee(@PathVariable Long id,
	                                @RequestBody Employee employee) {

	     return service.updateEmployee(id, employee);
	 }
	 //DELETE EMPLOYEE    http://localhost:8082/employee/delete/1
	 @DeleteMapping("/delete/{id}")
	 public String deleteEmployee(@PathVariable Long id) {

	     return service.deleteEmployee(id);
	 }
	 //CUSTOM METHODS
	 //only one recored we can add jason formate 
	 
	 @GetMapping("/name/{name}")
	 public Employee getEmployeeByName(@PathVariable String name) {
	     return service.getEmployeeByName(name);
	 }
	 
	 @PostMapping("/saveAll")
	 public List<Employee> saveAllEmployees(@RequestBody List<Employee> employees) {

	     return service.saveAllEmployees(employees);
	 }
	 //pagination   http://localhost:8082/employee/page?page=0&size=2
	 @GetMapping("/page")
	 public Page<Employee> getEmployees(
	         @RequestParam int page,
	         @RequestParam int size) {

	     return service.getEmployees(page, size);
	 }
	 
	//sorting http://localhost:8082/employee/sort?field=name
	 @GetMapping("/sort")
	 public List<Employee> getSortedEmployees(@RequestParam String field) {
	     return service.getSortedEmployees(field);
	 }
	}

