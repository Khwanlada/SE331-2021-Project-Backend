package se331.lab.rest.entity;

import lombok.*;

import javax.persistence.*;
import java.util.List;

@Data
@Builder
@Entity
@NoArgsConstructor
@AllArgsConstructor
public class Event {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @EqualsAndHashCode.Exclude
    Long id;
    String category;
    String title;
    String description;
    String location;
    String date;
    String time;
    Boolean petAllowed;
    @ManyToOne
    Organizer organizer;
    @ManyToMany(mappedBy = "eventHistory")
    List<Participant> participants;
    @ElementCollection
    List<String> imageUrls;
}
