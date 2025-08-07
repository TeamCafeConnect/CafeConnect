package com.yash.cafeconnect.entity;

import com.yash.cafeconnect.entity.enums.MenuStatus;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.DayOfWeek;

@Entity
@Table(name="week_schedule")
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class MenuWeeklySchedule {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int sno;
    private String description;

    @Enumerated(EnumType.STRING)
    private DayOfWeek day;



    @ManyToOne
    @JoinColumn(name="menu_id")
    private Menu menu;

    @Enumerated(EnumType.STRING)
    private MenuStatus status;

}
