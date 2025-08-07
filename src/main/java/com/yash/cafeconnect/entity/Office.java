package com.yash.cafeconnect.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import java.util.List;

@Entity
@Table(name="office")
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class Office {

    @Id
    private String officeId;
    private String officeName;
    private String city;

    @OneToMany(mappedBy = "office", cascade = CascadeType.ALL)
    private List<User> users;
}
