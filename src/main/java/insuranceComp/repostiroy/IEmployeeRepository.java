package insuranceComp.repostiroy;

import insuranceComp.model.Client;
import insuranceComp.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;

@Repository
public interface IEmployeeRepository extends JpaRepository<Employee, String> {

    @Query(value = "SELECT * FROM employee WHERE email = ?1", nativeQuery = true)
    ArrayList<Employee> emailExists(String email);

    @Query(value = "SELECT * FROM employee WHERE email = ?1 AND password = ?2", nativeQuery = true)
    Employee loginEmployee(String email, String password);

    @Query(value = "SELECT * FROM employee WHERE id = ?1", nativeQuery = true)
    ArrayList<Employee> idExists(String id);

}
