package tech.blur.eventhub.services;

import tech.blur.eventhub.models.Tag;
import tech.blur.eventhub.repositories.TagRepository;
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

  public Tag provideTag(String id) {
    return tagRepository.fetchTag(id);
  }

  public Tag updateTag(Tag tag) {
    tagRepository.updateTag(tag);
    return tag;
  }

  public void deleteTag(String id) {
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
