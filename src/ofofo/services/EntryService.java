package ofofo.services;

import ofofo.data.models.Entry;

import java.util.List;

public interface EntryService {

    Entry createEntry(Entry entry);
    Entry updateEntry(Entry entry);
    boolean deleteEntry(long entryId);
    Entry getEntryById(long entryId);
    List<Entry> getAllEntries();
}
