package tech.blur.eventhub.repositories;

import tech.blur.eventhub.models.Event;
import org.springframework.stereotype.Repository;

import java.util.*;

/**
 * Реализиция, хранящая все данные в памяти приложения
 */
@Repository
public class InMemoryEventRepository implements EventRepository {

    private Map<String, Event> eventCache = new HashMap<>();
    private Map<String, Event> eventCacheSearch = new HashMap<>();
    public InMemoryEventRepository() {
        eventCache.put("1", new Event("1", 2, "SrgGrch", "Two girls one map",
                "Double math analysis without triple integration", "54.9869693,82.9131314",
                new ArrayList(Arrays.asList(1,5,2)), new ArrayList(Arrays.asList(1,4,2,6)),"2018-07-03 19:00:00",
                "2018-07-04 12:00:00"));
        eventCache.put("2", new Event("2",  1, "MacOSO", "Mourning",
                "In memory of good API on JS", "54.8437635,83.0891522",
                Collections.singletonList(2),Collections.singletonList(3),"2018-05-03 15:00:00",
                "2018-06-04 12:00:00"));
        eventCacheSearch.put("Two girls one map", new Event("1", 2, "SrgGrch", "Two girls one map",
                "Double math analysis without triple integration", "54.9869693,82.9131314",
                new ArrayList(Arrays.asList(1,5,2)), new ArrayList(Arrays.asList(1,4,2,6)),"2018-07-03 19:00:00",
                "2018-07-04 12:00:00"));
        eventCacheSearch.put("Mourning", new Event("1", 1, "MacOSO", "Mourning", "In memory of good API on JS", "54.8437635,83.0891522",
                Collections.singletonList(2),Collections.singletonList(3),"2018-05-03 15:00:00","2018-06-04 12:00:00"));
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
    public ArrayList<Event> searchEvent(String name) {
        ArrayList<Event> events = new ArrayList<>();
        for (int i = 1; i<=eventCache.size(); i++){
            if ((eventCache.get(Integer.toString(i)).getName().toLowerCase()).contains(name.toLowerCase())){
                events.add(eventCache.get(Integer.toString(i)));
            }
        }
        return events;
    }

    @Override
    public void deleteEvent(final String id) {
        eventCache.remove(id);
    }

    @Override
    public Event createEvent(final Event event) {
        event.setId(Integer.toString(eventCache.size()+1));
        eventCacheSearch.put(event.getName(), event);
        eventCache.put(event.getId(), event);
        return event;
    }

    @Override
    public Collection<Event> getAllEvents() {
        return eventCache.values();
    }
}