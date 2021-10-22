package se331.lab.rest.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Repository;
import se331.lab.rest.entity.Event;
import se331.lab.rest.repository.EventRepository;

@Repository
@Profile("db")
public class EventDaoDbImpl implements EventDao {
    @Autowired
    EventRepository eventRepository;

    @Override
    public Integer getEventSize() {
        return Math.toIntExact(eventRepository.count());
    }

    @Override
    public Page<Event> getEvents(Integer pageSize, Integer page) {
        return eventRepository.findAll(PageRequest.of(page - 1, pageSize));
    }

    @Override
    public Event getEvent(Long id) {
        return eventRepository.findById(id).orElse(null);
    }

    @Override
    public Event save(Event event) {
        return eventRepository.save(event);
    }

    @Override
    public Page<Event> getEvent(String title, Pageable page) {
        return eventRepository.findByTitleIgnoreCaseContainingOrDescriptionIgnoreCaseContainingOrOrganizer_NameIgnoreCaseContaining(title,title,title,page);
    }
}
