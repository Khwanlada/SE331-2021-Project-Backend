package se331.lab.rest.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import se331.lab.rest.dao.OrganizerDao;
import se331.lab.rest.dao.UserDao;
import se331.lab.rest.entity.Organizer;
import se331.lab.rest.repository.OrganizerRepository;
import se331.lab.rest.security.entity.Authority;
import se331.lab.rest.security.entity.AuthorityName;
import se331.lab.rest.security.entity.User;
import se331.lab.rest.security.repository.AuthorityRepository;
import se331.lab.rest.security.repository.UserRepository;

import javax.transaction.Transactional;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;

@Service
public class UserServiceImpl implements UserService{

    @Autowired
    private AuthorityRepository authorityRepository;
    @Autowired
    UserDao userDao;
    @Autowired
    OrganizerDao organizerDao;
    @Autowired
    OrganizerRepository organizerRepository;
    @Override
    @Transactional
    public User save(User user) {
        PasswordEncoder encoder = new BCryptPasswordEncoder();
        user.setPassword(encoder.encode(user.getPassword()));
        user.setEnabled(true);
        user.setLastPasswordResetDate(Date.from(LocalDate.of(2021, 01, 01).atStartOfDay(ZoneId.systemDefault()).toInstant()));
        Authority authority = authorityRepository.findByName(AuthorityName.ROLE_USER);
        user.getAuthorities().add(authority);
        Organizer organizer = organizerRepository.save(Organizer.builder()
                .name(user.getFirstname()).build());
        organizer.setUser(user);
        user.setOrganizer(organizer);
        organizerRepository.save(organizer);

        return userDao.save(user);
    }
}