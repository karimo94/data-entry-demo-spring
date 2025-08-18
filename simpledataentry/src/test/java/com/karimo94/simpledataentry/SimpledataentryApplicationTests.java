package com.karimo94.simpledataentry;



import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.karimo94.simpledataentry.controller.DataEntryController;

@SpringBootTest
class SimpledataentryApplicationTests {

	@Autowired
	DataEntryController myTestController;

	//should really use Mockito for these tests, but this is just a demo app
	@Test
	void testSaveEmployeeMissingFields() {
		/*Employee testEmployee = new Employee();
		testEmployee.age = 35;
		testEmployee.hometown = "New York";
		myTestController.savEmployee(testEmployee);	
		List<Employee> allEmployees = myTestController.getAllEmployees();
		assertEquals(allEmployees.size(), 0);*/
	}
	@Test
	void testSaveEmployee() {
		/*Employee testEmployee = new Employee();
		testEmployee.age = 35;
		testEmployee.hometown = "New York";
		myTestController.savEmployee(testEmployee);	
		List<Employee> allEmployees = myTestController.getAllEmployees();
		assertEquals(allEmployees.size(), 1);*/
	}
	@Test
	void testGetAllEmployees() {
		/*Employee emp1 = new Employee("Test User", 35, "Firmware Engineer", "New York, NY");
		Employee emp2 = new Employee();
		Employee emp3 = new Employee("Indiana Jones", 40, "Archaeologist", "Chicago, IL");
		Employee emp4 = new Employee("",50,"Unknown", "Madrid, ES");
		myTestController.savEmployee(emp1);
		myTestController.savEmployee(emp2);
		myTestController.savEmployee(emp3);
		myTestController.savEmployee(emp4);
		List<Employee> allEmployees = myTestController.getAllEmployees();
		assertEquals(allEmployees, 2);*/
	}
}
