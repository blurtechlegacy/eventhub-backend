package tech.blur.eventhub.services;

import tech.blur.eventhub.models.AssignEvent;
import tech.blur.eventhub.models.Event;
import tech.blur.eventhub.repositories.EventRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
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

  public ArrayList<Event> searchEvents(String name){
    return eventRepository.searchEvent(name);
  }

  public ArrayList<Event> getEventsByUser(String host){
    return eventRepository.getEventsByUser(host);
  }

  public Event createEvent(Event event) {
    eventRepository.createEvent(event);
    return event;
  }

  public ArrayList<Event> getAssignedEvents(String id) {
    return eventRepository.getAssignedEvents(id);
  }

  public Event assignEvent (AssignEvent assignEvent){
    return eventRepository.assignEvent(assignEvent);
  }

  public ArrayList<Event> getEventsByTag(String id){
    return eventRepository.getEventsByTag(id);
  }

  public Collection<Event> provideEvents() {
    return eventRepository.getAllEvents();
  }

}
