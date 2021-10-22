package se331.lab.rest.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import se331.lab.rest.repository.EventRepository;
import se331.lab.rest.security.entity.User;
import se331.lab.rest.security.repository.UserRepository;

@Repository
public class UserDaoImpl implements UserDao{
    @Autowired
    UserRepository userRepository;
    @Override
    public User save(User user) {
        return userRepository.save(user);
    }
}