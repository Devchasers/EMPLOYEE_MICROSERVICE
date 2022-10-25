package esprit.fgsc.EMPLOYEESMICROSERVICES.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import esprit.fgsc.EMPLOYEESMICROSERVICES.entities.Employee;

@Repository
public interface IEmployeRepository extends MongoRepository<Employee, String>{

}
