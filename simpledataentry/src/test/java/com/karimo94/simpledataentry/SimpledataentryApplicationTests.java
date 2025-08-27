package com.karimo94.simpledataentry;

import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.verify;

import java.util.List;
import java.util.Set;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.context.SpringBootTest;

import com.karimo94.simpledataentry.model.Employee;
import com.karimo94.simpledataentry.repository.EmployeeRepo;
import com.karimo94.simpledataentry.service.EmployeeService;

import jakarta.validation.ConstraintViolation;
import jakarta.validation.Validation;
import jakarta.validation.*;

@SpringBootTest
@ExtendWith(MockitoExtension.class)
class SimpledataentryApplicationTests {

	@Mock
	private EmployeeRepo employeeRepo;
	@InjectMocks
	private EmployeeService employeeService;

	Validator validator = Validation.buildDefaultValidatorFactory().getValidator();

	//should really use Mockito for these tests, but this is just a demo app
	@Test
	void testSaveEmployeeMissingFields() {
		
		Employee testEmployee = new Employee();
		testEmployee.setAge(35);
		testEmployee.setHometown("New York");
		Employee response = employeeService.saveEmployee(testEmployee);
		Set<ConstraintViolation<Employee>> violations = validator.validate(testEmployee);
		assert(response == null);
		assert(!violations.isEmpty());
	}
	@Test
	void testSaveEmployee() {
		Employee testEmployee = new Employee();
		testEmployee.setAge(35);
		testEmployee.setHometown("New York");
		testEmployee.setName("Test User");
		testEmployee.setTitle("Firmware Engineer");
		given(employeeRepo.save(testEmployee)).willReturn(testEmployee);
		Employee response = employeeService.saveEmployee(testEmployee);
		assert(response != null && response.getName() == "Test User");
		verify(employeeRepo).save(testEmployee);
	}
	@Test
	void testGetAllEmployees() {
		Employee emp1 = new Employee("Test User", 35, "Firmware Engineer", "New York, NY");
		Employee emp2 = new Employee();
		Employee emp3 = new Employee("Indiana Jones", 40, "Archaeologist", "Chicago, IL");
		Employee emp4 = new Employee("",50,"Unknown", "Madrid, ES");
		employeeService.saveEmployee(emp1);
		employeeService.saveEmployee(emp2);
		employeeService.saveEmployee(emp3);
		employeeService.saveEmployee(emp4);
		given(employeeRepo.findAll()).willReturn(List.of(emp1, emp3));
		List<Employee> allEmployees = employeeService.getAllEmployees();
		assert(allEmployees.size() == 2);
		verify(employeeRepo).findAll();
	}
}
