package de.tekup.UserService.repository;
import de.tekup.UserService.models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface UserRepository extends JpaRepository<User,Long> {
    @Query("select  u from User u where u.id=:id ")
    User findOneById(@Param("id")Long  id);
    User findUserByEmail(String email);
}