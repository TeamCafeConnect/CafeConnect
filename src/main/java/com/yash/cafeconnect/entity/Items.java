package com.yash.cafeconnect.entity;

import com.yash.cafeconnect.entity.enums.ItemStatus;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "items")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Items {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int itemId;
    private String description;
    private int price;

    @Enumerated(EnumType.STRING)
    private ItemStatus itemStatus;

    @ManyToOne
    @JoinColumn(name = "menu_id")
    private Menu menu;
}
