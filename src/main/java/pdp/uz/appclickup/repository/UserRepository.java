package pdp.uz.appclickup.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pdp.uz.appclickup.entity.User;

import javax.validation.constraints.Email;
import java.util.Optional;
import java.util.UUID;

public interface UserRepository extends JpaRepository<User, Integer> {
    boolean existsByEmail(@Email String email);

    Optional<User> findByEmail(@Email String email);

}
