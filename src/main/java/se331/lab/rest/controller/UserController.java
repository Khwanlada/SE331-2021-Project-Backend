package se331.lab.rest.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import se331.lab.rest.security.entity.User;
import se331.lab.rest.service.UserService;
import se331.lab.rest.util.LabMapper;

@RestController
public class UserController {
    @Autowired
    UserService userService;
    @PostMapping("/register")
    public ResponseEntity<?> addUser(@RequestBody User user) {
        User output = userService.save(user);
        return ResponseEntity.ok(LabMapper.INSTANCE.getUserDTO(output));
    }


}