package com.yash.cafeconnect.entity;

import com.yash.cafeconnect.entity.enums.UserRoles;
import com.yash.cafeconnect.entity.enums.VerificationStatus;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name="user_info")
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class User {

    @Id
    private String emailId;
    private String name;
    private String mobileNo;
    private String password;

    @Enumerated(EnumType.STRING)
    private UserRoles role;

    @Enumerated(EnumType.STRING)
    private VerificationStatus verificationStatus;

    @ManyToOne
    @JoinColumn(name="office_id")
    private Office office;

}
