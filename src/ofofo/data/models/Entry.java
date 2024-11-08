package ofofo.data.models;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Entry {
    private String diaryId;
    private long entryId;
    private String title;
    private String content;
    private String dateCreated;
    private String dateModified;

    public Entry() {

    }
    public Entry(String diaryId, long entryId, String title, String description) {
        this.diaryId = diaryId;
        this.entryId = entryId;
        this.title = title;
        this.content = description;
        this.dateCreated = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
    }
    public String getDiaryId() {
        return diaryId;
    }
    public long getEntryId() {
        return entryId;
    }
    public String getTitle() {
        return title;
    }
    public String getContent() {
        return content;
    }
    public String getDateCreated() {
        return dateCreated;
    }
    public String getDateModified() {
        return dateModified;
    }
    public void setTitle(String title) {
        this.title = title;
    }
    public void setContent(String content) {
        this.content = content;
    }
    public void setDateModified(String date) {
        this.dateModified = date;
    }
    @Override
    public String toString() {
        return "{  diaryId: "+ diaryId + ", EntryId: "+ entryId + ", Title: " + title + ", Description: " + content + ", DateCreated: " + dateCreated  +" }";
    }
}