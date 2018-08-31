package tech.blur.eventhub.repositories;

import tech.blur.eventhub.models.AssignEvent;
import tech.blur.eventhub.models.Event;
import org.springframework.stereotype.Repository;

import java.util.*;

@Repository
public class InMemoryEventRepository implements EventRepository {

    private Map<String, Event> eventCache = new HashMap<>();
    public InMemoryEventRepository() {
        eventCache.put("1", new Event("1", "7", "Илья", "Человек-муравей и Оса",
                "Собираемся за 20 минут до сеанса возле Киносити в Сибирском молле", "55.038864,82.9612697",
                new ArrayList(Arrays.asList("1")), new ArrayList(Arrays.asList("7")),"1531907100000",
                "1531915380000"));
        eventCache.put("2", new Event("2",  "2", "Серёжа", "Выходные на природе",
                "Можно съездить в какую нибудь из беседок в Заельцовском парке. Говорят в приложении BorcshStarter можно еще и распределить кто-что возьмет и кто будет готовить. Можно будет поиграть в волейбол! 🏐", "55.0511904,82.8388093",
                new ArrayList(Arrays.asList("2","7", "13")), new ArrayList(Arrays.asList("2")),"1531663200000",
                "1531681200000"));
        eventCache.put("3", new Event("3", "2", "Серёжа", "Ночные покатушки на великах",
                "Давайте покатаемся ночью на велосипедах по Красному проспекту от Заельцовской 🚲. В принципе можно доехать до Октябрьской.", "55.060416,82.91225150000002",
                new ArrayList(Arrays.asList("9")), new ArrayList(Arrays.asList("2")),"1532721600000",
                "1532736000000"));
        eventCache.put("4", new Event("4", "5", "Маша", "Новый диджей в Guilty",
                "Погнали в Guilty. Говорят там появился новый диджей 🎉🎉. Затусим на всю ночь!", "55.022901,82.92301199999997",
                new ArrayList(Arrays.asList("12")), new ArrayList(Arrays.asList("5")),"1532736000000",
                "1532736000000"));
        eventCache.put("5", new Event("5", "7", "Илья", "Ночёвка с палатками",
                "Давайте соберёмся за городом. Мой кореш возьмет гитару. Я знаю один классный лесок 🌳🌳. Только я с палатками не дружу 🏕️, давайте в Бюро добрых дел попросим помочь?", "55.11402622375434,83.16025904528817",
                new ArrayList(Arrays.asList("2", "5", "10")), new ArrayList(Arrays.asList("7", "6")),"1533279600000",
                "1533394800000"));
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
    public ArrayList<Event> getEventsByUser(String host) {
        ArrayList<Event> events = new ArrayList<>();
        for (int i = 1; i<=eventCache.size(); i++){
            if ((eventCache.get(Integer.toString(i)).getHost().toLowerCase()).contains(host.toLowerCase())){
                events.add(eventCache.get(Integer.toString(i)));
            }
        }
        return events;
    }

    @Override
    public ArrayList<Event> getAssignedEvents(String id) {
        ArrayList<Event> events = new ArrayList<>();
        for (int i = 1; i<=eventCache.size(); i++){
            if (eventCache.get(Integer.toString(i)).getGuests().contains(id)){
                events.add(eventCache.get(Integer.toString(i)));
            }
        }
        return events;
    }

    @Override
    public ArrayList<Event> getEventsByTag(String id) {
        ArrayList<Event> events = new ArrayList<>();
        for (int i = 1; i<=eventCache.size(); i++){
            if (eventCache.get(Integer.toString(i)).getTags().contains(id)){
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
        eventCache.put(event.getId(), event);
        return event;
    }

    public Event assignEvent (final AssignEvent assignEvent){

        if (!eventCache.get(assignEvent.getEvent_id()).getGuests().contains(assignEvent.getUser_id()))
            eventCache.get(assignEvent.getEvent_id()).getGuests().add(assignEvent.getUser_id());

        return eventCache.get(assignEvent.getEvent_id());
    }


    @Override
    public Collection<Event> getAllEvents() {
        return eventCache.values();
    }
}
