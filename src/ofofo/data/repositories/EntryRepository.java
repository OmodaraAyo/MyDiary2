package ofofo.data.repositories;

import ofofo.data.models.Entry;

import java.util.List;

public interface EntryRepository {

    Entry save(Entry entry);
    void update(Entry entry);
    Entry findById(long id);
    Entry findByTitle(String title);
    List<Entry> findAll();
    void deleteById(long id);
    long count();
    boolean isEmpty();
    void deleteAll();
    boolean existById(long id);
}
