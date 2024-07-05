package it.syncroweb.template.repository;

import it.syncroweb.template.domain.model.tables.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface UsersRepository extends JpaRepository<Users, Integer> {

    Optional<Users> findByUsername(String username);

    Optional<Users> findById(Integer userId);

    Optional<Users> findByFirstnameAndLastname(String firstname, String lastname);

    @Query(value = """
            SELECT u FROM Users u WHERE CONCAT(u.firstname, ' ', u.lastname) = :autista
            """)
    Optional<Users> finByAutistaFirstnamePlusLastname(String autista);

    @Query(value = """
            SELECT u FROM Users u WHERE CONCAT(u.lastname, ' ', u.firstname) = :autista
            """)
    Optional<Users> finByAutistaLastnamePlusFirstname(@Param("autista") String autista);

    @Query(value = """
            SELECT u FROM Users u inner join u.roles r on u.id = r.id where r.name = :role
            """)
    List<Users> findUsersByRole(String role);

    @Query(value = """
            SELECT r.name FROM Users u inner join u.roles r where u.id = :id
            """)
    String findRoleByUserId(Integer id);
}
