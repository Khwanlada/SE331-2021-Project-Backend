package se331.lab.rest.service;

import se331.lab.rest.entity.Event;
import se331.lab.rest.security.entity.User;

public interface UserService {
    User save(User user);
}