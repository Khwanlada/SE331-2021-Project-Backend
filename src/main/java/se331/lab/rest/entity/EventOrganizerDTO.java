package se331.lab.rest.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class EventOrganizerDTO {
    Long id;
    String name;
    String surname;
    String age;
    String hometown;
    String status;
    String type;
    String type2;

    String category;
    String title;
    String description;
    String location;
    String date;
    String time;
}
