package SpringBootProject.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import SpringBootProject.Entity.Employee;

public interface EmployeeRpository extends JpaRepository<Employee,Long> {
	Employee findByName(String name);

}
