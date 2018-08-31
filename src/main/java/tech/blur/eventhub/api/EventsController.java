package tech.blur.eventhub.api;


import tech.blur.eventhub.models.AssignEvent;
import tech.blur.eventhub.models.Event;
import tech.blur.eventhub.services.EventService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Collection;

@RestController
public class EventsController {

  private static final String EVENTS_PATH = Resources.API_PREFIX + "events";

  @SuppressWarnings("SpringJavaAutowiredFieldsWarningInspection")
  @Autowired
  private EventService service;

  @GetMapping(EVENTS_PATH + "/{id}")
  public @ResponseBody
  BaseResponse<Event> readEvent(@PathVariable String id) {
    BaseResponse<Event> response = new BaseResponse<>();
    Event event = service.provideEvent(id);

    if (null == event) {
      response.setStatus("EVENT_NOT_EXIST");  //для статусов  можно сделать отдельные Enum-ы или вынести как строковые константы
      response.setMessage("Event not found!");
    } else {
      response.setData(event);
    }
    return response;
  }

  @GetMapping(EVENTS_PATH)
  public @ResponseBody
  BaseResponse<Collection<Event>> listEvents() {
    BaseResponse<Collection<Event>> response = new BaseResponse<>();
    Collection<Event> result = service.provideEvents();
    response.setData(result);
    return response;
  }

  @GetMapping(EVENTS_PATH+ "/search/{name}")
  public @ResponseBody
  BaseResponse<ArrayList<Event>> searchEvents(@PathVariable String name) {
    BaseResponse<ArrayList<Event>> response = new BaseResponse<>();
    ArrayList<Event> result = service.searchEvents(name);
      if (result.isEmpty()) {
          response.setStatus("EVENT_NOT_EXIST");
          response.setMessage("Events not found!");
      } else {
          response.setData(result);
      }
    return response;
  }

  @PostMapping(EVENTS_PATH)
  public @ResponseBody
  BaseResponse<Event> createEvent(@RequestBody Event event) {
    BaseResponse<Event> response = new BaseResponse<>();
    Event result = service.createEvent(event);
    response.setData(result);
    return response;
  }

  @PostMapping(EVENTS_PATH +"/assign")
  public @ResponseBody
  BaseResponse<Event> assignEvent(@RequestBody AssignEvent assignEvent){
    BaseResponse<Event> response = new BaseResponse<>();
    Event result = service.assignEvent(assignEvent);
    response.setData(result);
    return response;
  }

  @GetMapping(EVENTS_PATH + "/byuser/{host}")
  public @ResponseBody
  BaseResponse<ArrayList<Event>> getEventsByUser(@PathVariable String host){
    BaseResponse<ArrayList<Event>> response = new BaseResponse<>();
    ArrayList<Event> result = service.getEventsByUser(host);
    if (result.isEmpty()) {
      response.setStatus("EVENT_NOT_EXIST");
      response.setMessage("Events not found!");
    } else {
      response.setData(result);
    }
    return response;
  }

  @GetMapping(EVENTS_PATH + "/assigned/{id}")
  public @ResponseBody
  BaseResponse<ArrayList<Event>> getAssignedUsers(@PathVariable String id){
    BaseResponse<ArrayList<Event>> response = new BaseResponse<>();
    ArrayList<Event> result = service.getAssignedEvents(id);
    if (result.isEmpty()) {
      response.setStatus("EVENT_NOT_EXIST");  //для статусов  можно сделать отдельные Enum-ы или вынести как строковые константы
      response.setMessage("Events not found!");
    } else {
      response.setData(result);
    }
    return response;
  }

  @GetMapping(EVENTS_PATH + "/bytag/{id}")
  public @ResponseBody
  BaseResponse<ArrayList<Event>> getEventsByTag (@PathVariable String id) {
    BaseResponse<ArrayList<Event>> response = new BaseResponse<>();
    ArrayList<Event> result = service.getEventsByTag(id);
    if (result.isEmpty()) {
      response.setStatus("EVENT_NOT_EXIST");
      response.setMessage("Events not found!");
    } else {
      response.setData(result);
    }
    return response;
  }
  @DeleteMapping(EVENTS_PATH + "/{id}")
  public @ResponseBody
  BaseResponse deleteEvent(@PathVariable String id) {
    service.deleteEvent(id);
    return new BaseResponse();
  }

  @PatchMapping(EVENTS_PATH + "/{id}")
  public @ResponseBody
  BaseResponse<Event> updateEvent(@PathVariable String id, @RequestBody Event event) {
    BaseResponse<Event> response = new BaseResponse<>();
    Event result = service.updateEvent(event);
    response.setData(result);
    return response;
  }

}