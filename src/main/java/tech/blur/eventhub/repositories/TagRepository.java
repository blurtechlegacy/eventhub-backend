package tech.blur.eventhub.repositories;

import tech.blur.eventhub.models.Tag;
import java.util.Collection;

public interface TagRepository {

  Tag fetchTag(String id);

  Tag updateTag(Tag tag);

  void deleteTag(String id);

  Tag createTag(Tag tag);

  Collection<Tag> getAllTags();
}