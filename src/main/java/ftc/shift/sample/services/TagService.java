package ftc.shift.sample.services;

import ftc.shift.sample.models.Tag;
import ftc.shift.sample.repositories.TagRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;

@Service
public class TagService {

  private final TagRepository tagRepository;

  @Autowired
  public TagService(final TagRepository tagRepository) {
    this.tagRepository = tagRepository;
  }

  public Tag provideTag(Integer id) {
    return tagRepository.fetchTag(id);
  }

  public Tag updateTag(Tag tag) {
    tagRepository.updateTag(tag);
    return tag;
  }

  public void deleteTag(Integer id) {
    tagRepository.deleteTag(id);
  }


  public Tag createTag(Tag tag) {
    tagRepository.createTag(tag);
    return tag;
  }

  public Collection<Tag> provideTags() {
    return tagRepository.getAllTags();
  }

}
