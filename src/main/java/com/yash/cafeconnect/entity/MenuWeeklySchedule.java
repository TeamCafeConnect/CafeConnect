package com.yash.cafeconnect.entity;
import java.time.DayOfWeek;

public class MenuWeeklySchedule {
    private int weeklySchedueId;
    private String description;
    private DayOfWeek day;
    private Menu menu;

    public MenuWeeklySchedule(){

    }


    public MenuWeeklySchedule(int weeklySchedueId, String description, DayOfWeek day, Menu menu) {
        this.weeklySchedueId = weeklySchedueId;
        this.description = description;
        this.day = day;
        this.menu = menu;
    }

    public int getWeeklySchedueId() {
        return weeklySchedueId;
    }

    public void setWeeklySchedueId(int weeklySchedueId) {
        this.weeklySchedueId = weeklySchedueId;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public DayOfWeek getDay() {
        return day;
    }

    public void setDay(DayOfWeek day) {
        this.day = day;
    }

    public Menu getMenu() {
        return menu;
    }

    public void setMenu(Menu menu) {
        this.menu = menu;
    }
}