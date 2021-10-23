package se331.lab.rest.security.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import se331.lab.rest.security.entity.Doctor;

public interface DoctorRepository extends JpaRepository<Doctor, Long> {
    Doctor findByUsername(String username);
}
