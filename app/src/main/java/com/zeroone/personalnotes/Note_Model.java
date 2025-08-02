package com.zeroone.personalnotes;
public class Note_Model {

    private long id;
    private String title;
    private String content;
    private String dateTime; // Add date and time field

    public Note_Model(long id, String title, String content, String dateTime) {
        this.id = id;
        this.title = title;
        this.content = content;
        this.dateTime = dateTime;
    }

    // Getters and setters for fields
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getDateTime() {
        return dateTime;
    }

    public void setDateTime(String dateTime) {
        this.dateTime = dateTime;
    }
}
