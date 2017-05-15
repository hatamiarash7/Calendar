package ir.hatamiarash.calendar.entity;

import calendar.PersianDate;

public class EventEntity {
    private PersianDate date;
    private String title;
    private String type;
    private boolean holiday;

    public EventEntity(PersianDate date, String title, boolean holiday, String _type) {
        this.date = date;
        this.title = title;
        this.holiday = holiday;
        this.type = _type;
    }

    public PersianDate getDate() {
        return date;
    }

    public void setDate(PersianDate date) {
        this.date = date;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public boolean isHoliday() {
        return holiday;
    }

    public void setHoliday(boolean holiday) {
        this.holiday = holiday;
    }

    public String getType() {
        return type;
    }
}