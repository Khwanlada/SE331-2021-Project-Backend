package se331.lab.rest.security.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import se331.lab.rest.security.entity.User;

public interface UserRepository extends JpaRepository<User, Long> {
    User findByUsername(String username);
}
