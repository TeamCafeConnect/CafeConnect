package com.yash.cafeconnect.entity;


import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Entity
@Table(name="menu")
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class Menu {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int menuId;

    private String menuName;

    @OneToMany(mappedBy = "menu", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JsonIgnore
    private List<Items> items;

    @ManyToOne
    @JoinColumn(name = "cafe_id")
    @JsonIgnore
    private Cafe cafe;

}
