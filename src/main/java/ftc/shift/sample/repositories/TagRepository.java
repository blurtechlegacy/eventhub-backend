package ftc.shift.sample.repositories;

import ftc.shift.sample.models.Tag;

import java.util.Collection;

/**
 * Интерфейес для получения данных по книгам из БД
 */
public interface TagRepository {

  Tag fetchTag(String id);

  Tag updateTag(Tag tag);

  void deleteTag(String id);

  Tag createTag(Tag tag);

  Collection<Tag> getAllTags();
}
