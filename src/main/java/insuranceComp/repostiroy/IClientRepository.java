package insuranceComp.repostiroy;

import insuranceComp.model.Client;
import insuranceComp.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;

@Repository
public interface IClientRepository extends JpaRepository<Client, Integer> {

    @Query(value = "SELECT * FROM client WHERE id = ?1", nativeQuery = true)
    Client getClientById(String id);

    @Transactional
    @Modifying
    @Query(value = "UPDATE client SET firstName = ?1 WHERE id = ?2", nativeQuery = true)
    void changeFirstName(String firstName, String id);

    @Transactional
    @Modifying
    @Query(value = "UPDATE client SET lastName = ?1 WHERE id = ?2", nativeQuery = true)
    void changeLastName(String lastName, String id);

    @Transactional
    @Modifying
    @Query(value = "UPDATE client SET employer = ?1 WHERE id = ?2", nativeQuery = true)
    void changeEmployer(String employer, String id);

    @Transactional
    @Modifying
    @Query(value = "UPDATE Client SET email = ?1 WHERE id = ?2", nativeQuery = true)
    void changeEmail(String email, String id);

    @Transactional
    @Modifying
    @Query(value = "UPDATE client SET phone = ?1 WHERE id = ?2", nativeQuery = true)
    void changePhone(String phone, String id);

    @Transactional
    @Modifying
    @Query(value = "UPDATE client SET debt = ?1 WHERE id = ?2", nativeQuery = true)
    void changeDebt(double debt, String id);

    @Transactional
    @Modifying
    @Query(value = "UPDATE client SET address = ?1 WHERE id = ?2", nativeQuery = true)
    void changeAddress(String address, String id);

    @Query(value = "SELECT * FROM client WHERE id = ?1", nativeQuery = true)
    ArrayList<Client> idExists(String id);

    @Query(value = "SELECT * FROM client WHERE email = ?1", nativeQuery = true)
    ArrayList<Client> emailExists(String email);

    @Query(value = "SELECT * FROM client WHERE phone = ?1", nativeQuery = true)
    ArrayList<Client> phoneExists(String phone);
}
