package ofofo.data.repositories;

import ofofo.data.models.Diary;

import java.util.List;

public interface DiaryRepository {

    Diary save(Diary diary);
    void update(Diary diary);
    Diary findById(String id);
    List<Diary> findByName(String name);
    List<Diary> findAll();
    boolean deleteById(String id);
    boolean existById(String id);
    long count();
}
