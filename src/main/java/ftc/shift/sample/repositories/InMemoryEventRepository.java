package ftc.shift.sample.repositories;

import ftc.shift.sample.models.Event;
import org.springframework.stereotype.Repository;

import java.util.*;

/**
 * Реализиция, хранящая все данные в памяти приложения
 */
@Repository
public class InMemoryEventRepository implements EventRepository {

    private Map<String, Event> eventCache = new HashMap<>();

    public InMemoryEventRepository() {
        eventCache.put("1", new Event("1", 2, "Two girls one map", "Double math analysis without penetration", "54.8437876,83.0718511", new ArrayList(Arrays.asList(1,5,2)), new ArrayList(Arrays.asList(1,4,2,6)),"2018-07-03 19:00:00","2018-07-04 12:00:00"));
        eventCache.put("2", new Event("2",  1, "Mourning", "In memory of good API on JS", "54.8437876,83.0718511", Collections.singletonList(2),Collections.singletonList(3),"2018-05-03 15:00:00","2018-06-04 12:00:00"));
    }


    @Override
    public Event fetchEvent(final String id) {
        return eventCache.get(id);
    }

    @Override
    public Event updateEvent(final Event event) {
        eventCache.put(event.getId(), event);
        return event;
    }

    @Override
    public void deleteEvent(final String id) {
        eventCache.remove(id);
    }

    @Override
    public Event createEvent(final Event event) {
        event.setId(String.valueOf(System.currentTimeMillis()));  //очень плохой способ генерировать Id, тут только для примера
        eventCache.put(event.getId(), event);
        return event;
    }

    @Override
    public Collection<Event> getAllEvents() {
        return eventCache.values();
    }
}