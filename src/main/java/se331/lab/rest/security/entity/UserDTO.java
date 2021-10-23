package se331.lab.rest.security.entity;

import com.sun.istack.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import se331.lab.rest.entity.OrganizerAuthDTO;
import java.util.Date;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UserDTO {
    Long id;
    String username;
    String password;
    String firstname;
    String lastname;
    String email;
    int age;
    Boolean enabled;
    Date lastPasswordResetDate;
    OrganizerAuthDTO organizer;
}