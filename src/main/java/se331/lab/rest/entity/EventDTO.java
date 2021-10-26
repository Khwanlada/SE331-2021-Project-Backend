package se331.lab.rest.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.ManyToOne;
import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class EventDTO {
    Long id;
    String name;
    String surname;
    String age;
    String hometown;
    String status;
    String type;
    String type2;

    Boolean petAllowed;
    EventOrganizerDTO organizer;
    List<String> imageUrls;
}
