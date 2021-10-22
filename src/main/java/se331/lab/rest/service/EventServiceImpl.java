package se331.lab.rest.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import se331.lab.rest.dao.EventDao;
import se331.lab.rest.dao.OrganizerDao;
import se331.lab.rest.entity.Event;
import se331.lab.rest.entity.Organizer;

import javax.transaction.Transactional;

@Service
public class EventServiceImpl implements EventService{
    @Autowired
    EventDao eventDao;
    @Autowired
    OrganizerDao organizerDao;
    @Override
    public Integer getEventSize() {
        return eventDao.getEventSize();
    }

    @Override
    public Page<Event> getEvents(Integer pageSize, Integer page) {
        return eventDao.getEvents(pageSize, page);
    }

    @Override
    public Event getEvent(Long id) {
        return eventDao.getEvent(id);
    }

    @Override
    @Transactional
    public Event save(Event event) {
        Organizer organizer = organizerDao.findById(event.getOrganizer().getId()).orElse(null);
        event.setOrganizer(organizer);
        organizer.getOwnEvents().add(event);
        return eventDao.save(event);
    }

    @Override
    public Page<Event> getEvents(String title, Pageable pageable) {
        return eventDao.getEvent(title,pageable);
    }
}
