package ftc.shift.sample.api;


import ftc.shift.sample.services.BookService;
import ftc.shift.sample.models.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

@RestController
public class TagsController {

  private static final String TAGS_PATH = Resources.API_PREFIX + "tags";

  @Autowired
  private TagService service;

  @GetMapping(TAGS_PATH + "/{id}")
  public @ResponseBody
  BaseResponse<Tag> readTag(@PathVariable String id) {
    BaseResponse<Tag> response = new BaseResponse<>();
    Tag tag = service.provideTag(id);

    if (null == tag) {
      response.setStatus("TAG_NOT_EXIST");  //для статусов  можно сделать отдельные Enum-ы или вынести как строковые константы
      response.setMessage("Tag not found!");
    } else {
      response.setData(tag);
    }
    return response;
  }

  @GetMapping(TAGS_PATH)
  public @ResponseBody
  BaseResponse<Collection<Tag>> listTags() {
    BaseResponse<Collection<Tag>> response = new BaseResponse<>();
    Collection<Tag> result = service.provideTags();
    response.setData(result);
    return response;
  }

  @PostMapping(TAGS_PATH)
  public @ResponseBody
  BaseResponse<Tag> createBook(@RequestBody Tag tag) {
    BaseResponse<Tag> response = new BaseResponse<>();
    Tag result = service.createTag(tag);
    response.setData(result);
    return response;
  }

  @DeleteMapping(TAGS_PATH + "/{id}")
  public @ResponseBody
  BaseResponse deleteTag(@PathVariable String id) {
    service.deleteTag(id);
    return new BaseResponse(); //нет тела, только статус
  }

  @PatchMapping(TAGS_PATH + "/{id}")
  public @ResponseBody
  BaseResponse<Tag> updateBook(@PathVariable String id, @RequestBody Tag tag) {
    BaseResponse<Tag> response = new BaseResponse<>();
    Tag result = service.updateBook(tag);
    response.setData(result);
    return response;
  }

}