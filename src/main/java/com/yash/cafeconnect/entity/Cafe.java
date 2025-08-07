package com.yash.cafeconnect.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.yash.cafeconnect.entity.enums.CafeStatus;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import java.util.List;

@Entity
@Table(name="cafes")
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class Cafe {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int cafeId;

    private String cafeName;

    @Enumerated(EnumType.STRING)
    private CafeStatus cafeStatus;

    @ManyToOne
    @JoinColumn(name="company_id")
    @JsonIgnore
    private Company company;

    @OneToMany(mappedBy = "cafe", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Menu> menuList;

}
