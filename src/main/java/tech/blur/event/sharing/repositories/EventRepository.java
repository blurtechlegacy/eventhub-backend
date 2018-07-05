package tech.blur.event.sharing.repositories;

import tech.blur.event.sharing.models.Event;

import java.util.Collection;

public interface EventRepository {

  Event fetchEvent(String id);

  Event updateEvent(Event event);

  void deleteEvent(String id);

  Event createEvent(Event event);

  Collection<Event> getAllEvents();
}