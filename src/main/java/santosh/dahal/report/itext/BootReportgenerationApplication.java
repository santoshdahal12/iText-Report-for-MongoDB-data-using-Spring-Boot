package santosh.dahal.report.itext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class BootReportgenerationApplication implements CommandLineRunner {

	
	@Autowired
	EmployeeRepository repository;
	
	@Autowired
	GenerateReport generateReport;
	public static void main(String[] args) {
		SpringApplication.run(BootReportgenerationApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {

		repository.deleteAll();

		// save a couple of Employees
		repository.save(new Employee("Santosh", 3000,"Developer"));
		repository.save(new Employee("Dylan", 4000,"Sr. Developer"));
		repository.save(new Employee("Govind", 3000,"Developer"));
		repository.save(new Employee("Abinash", 3000,"Developer"));

		// fetch all Employees
		System.out.println("Employees found with findAll():");
		System.out.println("-------------------------------");
		for (Employee Employee : repository.findAll()) {
			System.out.println(Employee);
		}
		System.out.println();

		// fetch an individual Employee
		System.out.println("Employee found with findByFirstName('Santosh'):");
		System.out.println("--------------------------------");
		System.out.println(repository.findByName("Santosh"));

		System.out.println("Employees found with findByPosition('Developer'):");
		System.out.println("--------------------------------");
		for (Employee Employee : repository.findAllByPosition("Developer")) {
			System.out.println(Employee);
		}
		
		generateReport.createPdf();

	}

}
