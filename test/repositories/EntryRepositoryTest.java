package repositories;

import ofofo.data.models.Entry;
import ofofo.data.repositories.EntryRepository;
import ofofo.data.repositories.EntryRepositoryImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;


public class EntryRepositoryTest {
    EntryRepository repo;

    @BeforeEach
    public void startAllWithThis() {
        repo = new EntryRepositoryImpl();
    }

    @Test
    public void test_That_EntriesRepository_Is_Empty_ByDefault() {
        assertTrue(repo.isEmpty());
    }

    @Test
    public void when_Multiple_Entries_Are_Saved_Test_To_Find_Saved_Entry_By_Title(){
        Entry entry = new Entry("Ayodele", 1, "Games", "GodOfWar");
        repo.save(entry);
        assertEquals(1, repo.count());
        Entry entry2 = new Entry("Ayodele", 2, "Movies", "WalkingDead");
        repo.save(entry2);
        assertEquals(2, repo.count());
        assertEquals("GodOfWar", repo.findByTitle("Games").getContent());
    }
    @Test
    public void when_Multiple_Entries_Are_Saved_Test_To_Find_Saved_Entry_By_Id(){
        Entry entry = new Entry("Ayodele", 1, "Games", "God Hand");
        repo.save(entry);
        assertEquals(1, repo.count());
        Entry entry2 = new Entry("Ayodele", 2, "Movies", "WalkingDead");
        repo.save(entry2);
        assertEquals(2, repo.count());
        assertEquals("WalkingDead", repo.findById(2).getContent());
    }

    @Test
    public void test_To_Delete_A_SavedEntry_By_Id(){
        Entry entry = new Entry("Ayodele", 1, "Games", "God Hand");
        repo.save(entry);
        assertEquals(1, repo.count());
        Entry entry2 = new Entry("Ayodele", 2, "Movies", "WalkingDead");
        repo.save(entry2);
        assertEquals(2, repo.count());
        repo.deleteById(2);
        assertEquals(1, repo.count());
        assertNull(repo.findById(2));
        assertEquals("God Hand", repo.findById(1).getContent());
    }

    @Test
    public void test_To_Update_A_SavedEntry_By_Id(){
        Entry entry = new Entry("Ayodele", 1, "Games", "God Hand");
        repo.save(entry);
        assertEquals(1, repo.count());
        Entry entry2 = new Entry("Ayodele", 2, "Movies", "WalkingDead");
        repo.save(entry2);
        assertEquals(2, repo.count());
        Entry updatedEntry = new Entry("Ayodele", 2, "Movies", "Games Of Thrones");
        repo.save(updatedEntry);
        assertEquals(2, repo.count());
        assertEquals("Games Of Thrones", repo.findById(2).getContent());
        Entry updatedEntry2 = new Entry("Ayodele", 2, "Movies", "Prison break");
        repo.save(updatedEntry2);
        assertEquals(2, repo.count());
        assertEquals("Prison break", repo.findById(2).getContent());
    }

    @Test
    public void test_To_Find_All_Entries(){
        Entry entry = new Entry("Ayodele", 1, "Games", "God Hand");
        repo.save(entry);
        assertEquals(1, repo.count());
        Entry entry2 = new Entry("Ayodele", 2, "Movies", "WalkingDead");
        repo.save(entry2);
        assertEquals(2, repo.count());
        Entry entry3 = new Entry("Ayodele", 3, "Food", "Bread");
        repo.save(entry3);
        assertEquals(3, repo.count());
        List<Entry> expected = repo.findAll();
        System.out.println(expected);
        assertEquals(expected, repo.findAll());
    }

    @Test
    public void test_To_Delete_All_Saved_Entries_In_The_Repository(){
        Entry entry = new Entry("Ayodele", 1, "Games", "God Hand");
        repo.save(entry);
        assertEquals(1, repo.count());
        Entry entry2 = new Entry("Ayodele", 2, "Movies", "WalkingDead");
        repo.save(entry2);
        assertEquals(2, repo.count());
        Entry entry3 = new Entry("Ayodele", 3, "Food", "Bread");
        repo.save(entry3);
        assertEquals(3, repo.count());
        repo.deleteAll();
        assertEquals(0 , repo.count());
    }
    @Test
    public void test_To_Check_That_An_Entry_Exist_By_Id(){
        Entry entry = new Entry("Ayodele", 1, "Games", "God Hand");
        repo.save(entry);
        assertEquals(1, repo.count());
        Entry entry2 = new Entry("Ayodele", 2, "Movies", "WalkingDead");
        repo.save(entry2);
        assertEquals(2, repo.count());
        Entry entry3 = new Entry("Ayodele", 3, "Food", "Bread");
        repo.save(entry3);
        assertEquals(3, repo.count());
        assertTrue(repo.existById(2));
        assertFalse(repo.existById(4));
    }

    @Test
    public void test_To_Create_Multiple_Entries_for_different_Actor(){
        Entry entry = new Entry("Ayodele", 1, "Games", "God Hand");
        repo.save(entry);
        assertEquals(1, repo.count());
        Entry entry2 = new Entry("Ayodele", 2, "Movies", "WalkingDead");
        repo.save(entry2);
        EntryRepository daveRepo = new EntryRepositoryImpl();
        Entry daveEntry = new Entry("Dave", 1, "food", "Rice");
        daveRepo.save(daveEntry);
        assertEquals(1, daveRepo.count());
    }
}
