package com.yash.cafeconnect.entity;
import com.yash.cafeconnect.entity.enums.MenuStatus;

import java.time.DayOfWeek;

public class MenuWeeklySchedule {
    private int weeklyScheduleId;
    private String description;
    private DayOfWeek day;
    private MenuStatus menu;

    public MenuWeeklySchedule(){

    }


    public MenuWeeklySchedule(int weeklyScheduleId, String description, DayOfWeek day, MenuStatus menu) {
        this.weeklyScheduleId = weeklyScheduleId;
        this.description = description;
        this.day = day;
        this.menu = menu;
    }

    public int getWeeklySchedueId() {
        return weeklyScheduleId;
    }

    public void setWeeklySchedueId(int weeklySchedueId) {
        this.weeklyScheduleId = weeklySchedueId;
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

    public MenuStatus getMenu() {
        return menu;
    }

    public void setMenu(MenuStatus menu) {
        this.menu = menu;
    }
}