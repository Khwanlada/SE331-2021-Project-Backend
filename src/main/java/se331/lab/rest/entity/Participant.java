package se331.lab.rest.entity;

import lombok.*;

import javax.persistence.*;
import java.util.List;

@Data
@Builder
@Entity
@NoArgsConstructor
@AllArgsConstructor
public class Participant {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @EqualsAndHashCode.Exclude
    Long id;
    String name;
    String telNo;
    @ManyToMany
    List<Event> eventHistory;
}
