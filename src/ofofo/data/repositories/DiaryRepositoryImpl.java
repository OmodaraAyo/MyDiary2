package ofofo.data.repositories;

import ofofo.data.models.Diary;

import java.util.ArrayList;
import java.util.List;

public class DiaryRepositoryImpl implements DiaryRepository {
    private final List<Diary> diaries;

    public DiaryRepositoryImpl() {
        this.diaries = new ArrayList<Diary>();
    }

    @Override
    public long count() {
        return diaries.size();
    }

    @Override
    public Diary save(Diary diary) {
        if(findById(diary.getId()) != null) {
            update(diary);
            return diary;
        }
        diaries.add(diary);
        return diary;
    }

    @Override
    public void update(Diary newDiary) {
        Diary oldDiary = findById(newDiary.getId());
        diaries.set(diaries.indexOf(oldDiary), newDiary);
    }

    @Override
    public Diary findById(String id) {
        for (Diary diary : diaries) {
            if (diary.getId().equals(id)) {
                return diary;
            }
        }
        return null;
    }

    @Override
    public List<Diary> findByName(String name) {
        List<Diary> matchedNamesDiaries = new ArrayList<>();
        for (Diary diary : diaries) {
            if(diary.getUserName().equalsIgnoreCase(name)) {
                matchedNamesDiaries.add(diary);
            }
        }
        if(!matchedNamesDiaries.isEmpty()) {
            return matchedNamesDiaries;
        }
        return null;
    }

    @Override
    public List<Diary> findAll() {
        return List.copyOf(diaries);
    }

    @Override
    public boolean deleteById(String id) {
        Diary deleteDiary = findById(id);
        if(deleteDiary != null) {
            diaries.remove(deleteDiary);
            return true;
        }
        return false;
    }

    @Override
    public boolean existById(String id) {
        return findById(id) != null;
    }

}
