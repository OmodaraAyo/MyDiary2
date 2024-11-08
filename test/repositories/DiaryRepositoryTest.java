package repositories;

import ofofo.data.models.Diary;
import ofofo.data.repositories.DiaryRepository;
import ofofo.data.repositories.DiaryRepositoryImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class DiaryRepositoryTest {
    private DiaryRepository diaryRepository;

    @BeforeEach
    public void setUp() {
        diaryRepository = new DiaryRepositoryImpl();
    }

    @Test
    public void test_To_Save_A_Diary() {
        Diary diary = new Diary("Ayodele123","Ayodele", "Lion1234");
        diaryRepository.save(diary);
        assertEquals(1, diaryRepository.count());
    }

    @Test
    public void when_Multiple_Diaries_Are_Saved_Test_To_Find_Saved_Diary_By_Id(){
        Diary diary1 = new Diary("Ayodele123","Ayodele", "Lion1234");
        diaryRepository.save(diary1);
        assertEquals(1, diaryRepository.count());
        Diary diary2 = new Diary("John12","John", "Lion1234");
        diaryRepository.save(diary2);
        assertEquals(2, diaryRepository.count());
        Diary expected = diaryRepository.findById("Ayodele123");
        System.out.println(expected);
        assertEquals(diary1, expected);
    }

    @Test
    public void test_To_Update_An_Already_Saved_Diary(){
        Diary diary1 = new Diary("Ayodele123","Ayodele", "Lion1234");
        diaryRepository.save(diary1);
        assertEquals(1, diaryRepository.count());
        Diary diary2 = new Diary("Ayodele123","Ayodele", "Tiger123");
        diaryRepository.save(diary2);
        assertEquals(1, diaryRepository.count());
    }
    @Test
    public void test_To_Find_Saved_Diary_By_Name(){
        Diary diary1 = new Diary("Ayodele123","Ayodele", "Lion1234");
        diaryRepository.save(diary1);
        assertEquals(1, diaryRepository.count());
        Diary diary2 = new Diary("John12","John", "Lion1234");
        diaryRepository.save(diary2);
        assertEquals(2, diaryRepository.count());
        Diary diary3 = new Diary("Ayodele1234","Ayodele", "plantain12223");
        diaryRepository.save(diary3);
        assertEquals(3, diaryRepository.count());
        List<Diary> expected = diaryRepository.findByName("Ayodele");
        System.out.println(expected);
        assertEquals(expected, diaryRepository.findByName("Ayodele"));
    }

    @Test
    public void test_To_FindAll_Saved_Diary(){
        Diary diary1 = new Diary("Ayodele123","Ayodele", "Lion1234");
        diaryRepository.save(diary1);
        assertEquals(1, diaryRepository.count());
        Diary diary2 = new Diary("John12","John", "Lion1234");
        diaryRepository.save(diary2);
        assertEquals(2, diaryRepository.count());
        Diary diary3 = new Diary("pabz02","Pablo", "Skull1234");
        diaryRepository.save(diary3);
        assertEquals(3, diaryRepository.count());
        List<Diary> expected = diaryRepository.findAll();
        System.out.println(expected);
        assertEquals(expected, diaryRepository.findAll());
    }

    @Test
    public void test_To_Delete_A_SavedDiary_By_Id(){
        Diary diary1 = new Diary("Ayodele123","Ayodele", "Lion1234");
        diaryRepository.save(diary1);
        assertEquals(1, diaryRepository.count());
        Diary diary2 = new Diary("John12","John", "Lion1234");
        diaryRepository.save(diary2);
        assertEquals(2, diaryRepository.count());
        Diary diary3 = new Diary("pabz02","Pablo", "Skull1234");
        diaryRepository.save(diary3);
        assertEquals(3, diaryRepository.count());
        boolean expected = diaryRepository.deleteById("pabz02");
        assertTrue(expected);
        assertEquals(2, diaryRepository.count());
        assertFalse(diaryRepository.deleteById("gucchie70"));
    }
    @Test
    public void test_To_Check_That_A_Diary_Exist_By_Id(){
        Diary diary1 = new Diary("Ayodele123","Ayodele", "Lion1234");
        diaryRepository.save(diary1);
        assertEquals(1, diaryRepository.count());
        Diary diary2 = new Diary("John12","John", "Lion1234");
        diaryRepository.save(diary2);
        assertEquals(2, diaryRepository.count());
        Diary diary3 = new Diary("pabz02","Pablo", "Skull1234");
        diaryRepository.save(diary3);
        assertEquals(3, diaryRepository.count());
        assertTrue(diaryRepository.existById("John12"));
        assertFalse(diaryRepository.existById("Wizkid"));
    }
}
