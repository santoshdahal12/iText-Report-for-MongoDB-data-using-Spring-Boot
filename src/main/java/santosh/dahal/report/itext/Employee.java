/**
 * 
 */
package santosh.dahal.report.itext;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

/**
 * @author santosh dahal a mongo entity for storing information of an employee
 *         in an office
 *
 */
@Document
public class Employee {

	@Id
	public String id;

	
	private String name;
	private double salary;
	private String position;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	
	

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "Employee [name=" + name + ", salary=" + salary + ", position=" + position + "]";
	}

	public Employee(String name, double salary, String position) {
		super();
		this.name = name;
		this.salary = salary;
		this.position = position;
	}

	public double getSalary() {
		return salary;
	}

	public void setSalary(double salary) {
		this.salary = salary;
	}

	public String getPosition() {
		return position;
	}

	public void setPosition(String position) {
		this.position = position;
	}

	
	

	
}
