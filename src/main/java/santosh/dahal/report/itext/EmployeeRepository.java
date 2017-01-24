package santosh.dahal.report.itext;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;

public interface EmployeeRepository extends MongoRepository<Employee, String>{
	public Employee findByName(String name);
    //public List<Employee> findAllByName(String name);
	public List<Employee> findAllByPosition(String position);
}
