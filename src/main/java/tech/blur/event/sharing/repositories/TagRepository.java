package tech.blur.event.sharing.repositories;

import tech.blur.event.sharing.models.Tag;
import java.util.Collection;

public interface TagRepository {

  Tag fetchTag(String id);

  Tag updateTag(Tag tag);

  void deleteTag(String id);

  Tag createTag(Tag tag);

  Collection<Tag> getAllTags();
}