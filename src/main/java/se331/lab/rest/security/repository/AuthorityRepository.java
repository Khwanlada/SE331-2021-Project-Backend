package se331.lab.rest.security.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import se331.lab.rest.security.entity.Authority;
import se331.lab.rest.security.entity.AuthorityName;

public interface AuthorityRepository extends JpaRepository<Authority, Long> {
    Authority findByName(AuthorityName input);
}
