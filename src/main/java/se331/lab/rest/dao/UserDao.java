package se331.lab.rest.dao;

import se331.lab.rest.security.entity.User;

public interface UserDao {
    User save(User user);
}