package tech.blur.eventhub.services;

import tech.blur.eventhub.models.Event;
import tech.blur.eventhub.repositories.EventRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;

@Service
public class EventService {

  private final EventRepository eventRepository;

  @Autowired
  public EventService(final EventRepository eventRepository) {
    this.eventRepository = eventRepository;
  }

  public Event provideEvent(String id) {
    return eventRepository.fetchEvent(id);
  }

  public Event updateEvent(Event event) {
    eventRepository.updateEvent(event);
    return event;
  }

  public void deleteEvent(String id) {
    eventRepository.deleteEvent(id);
  }


  public Event createEvent(Event event) {
    eventRepository.createEvent(event);
    return event;
  }

  public Collection<Event> provideEvents() {
    return eventRepository.getAllEvents();
  }

}
