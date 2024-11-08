package ofofo.data.repositories;

import ofofo.data.models.Entry;

import java.util.ArrayList;
import java.util.List;

public class EntryRepositoryImpl implements EntryRepository {
    private final List<Entry> entries;

    public EntryRepositoryImpl() {
        this.entries = new ArrayList<Entry>();
    }

    @Override
    public long count() {
        return entries.size();
    }

    @Override
    public Entry save(Entry entry) {
        if(findById(entry.getEntryId()) != null) {
            update(entry);
            return entry;
        }
        entries.add(entry);
        return entry;
    }

    @Override
    public void update(Entry newEntry) {
        Entry actual = findById(newEntry.getEntryId());
        entries.set(entries.indexOf(actual), newEntry);
    }

    @Override
    public Entry findById(long id) {
        for (Entry entry : this.entries) {
            if(entry.getEntryId() == id) return entry;
        }
        return null;
    }

    @Override
    public Entry findByTitle(String title) {
        for (Entry entry : this.entries) {
            if (entry.getTitle().equalsIgnoreCase(title)) return entry;
        }
        return null;
    }

    @Override
    public List<Entry> findAll() {
        return List.copyOf(this.entries);
    }

    @Override
    public void deleteById(long id) {
        Entry entry = this.findById(id);
        this.entries.remove(entry);
    }


    @Override
    public boolean isEmpty() {
        return count() == 0;
    }

    @Override
    public void deleteAll() {
        entries.clear();
    }

    @Override
    public boolean existById(long id) {
        return findById(id) != null;
    }
}
