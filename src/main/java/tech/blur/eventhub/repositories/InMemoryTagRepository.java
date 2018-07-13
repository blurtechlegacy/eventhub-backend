package tech.blur.eventhub.repositories;

import tech.blur.eventhub.models.Tag;
import org.springframework.stereotype.Repository;

import java.util.*;

/**
 * Реализиция, хранящая все данные в памяти приложения
 */
@Repository
public class InMemoryTagRepository implements TagRepository {

    private Map<String, Tag> tagCache = new HashMap<>();

    public InMemoryTagRepository() {
        tagCache.put("1", new Tag("1", "кино", 1));
        tagCache.put("2", new Tag("2", "природа", 1));
        tagCache.put("3", new Tag("3", "конференция", 0));
        tagCache.put("4", new Tag("4", "программирование", 0));
        tagCache.put("5", new Tag("5", "гитара", 0));
        tagCache.put("6", new Tag("6", "футбол", 0));
        tagCache.put("7", new Tag("7", "волейбол", 1));
        tagCache.put("8", new Tag("8", "скейт", 0));
        tagCache.put("9", new Tag("9", "велосипед", 0));
        tagCache.put("10", new Tag("10", "за городом", 0));
        tagCache.put("12", new Tag("12", "вечеринка", 0));
        tagCache.put("13", new Tag("13", "парк", 1));
        tagCache.put("14", new Tag("14", "музей", 0));
    }


    @Override
    public Tag fetchTag(final String id) {
        return tagCache.get(id);
    }

    @Override
    public Tag updateTag(final Tag tag) {
        tagCache.put(tag.getId(), tag);
        return tag;
    }

    @Override
    public void deleteTag(final String id) {
        tagCache.remove(id);
    }

    @Override
    public Tag createTag(final Tag tag) {
        tag.setId(Integer.toString(tagCache.size()+1));
        tagCache.put(tag.getId(), tag);
        return tag;
    }

    @Override
    public Collection<Tag> getAllTags() {
        return tagCache.values();
    }
}
