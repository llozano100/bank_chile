package com.bank.user.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;


@Entity
@Table(name="USER")
@Data
public class User {
    @Id
    @Column(name = "uuid")
    //@GeneratedValue(strategy = GenerationType.UUID)
    private String uuid;

    @Column(name = "first_name")
    private String firstName;
    @Column(name = "last_name")
    private String lastName;
    @Column(name = "email")
    private String email;
    @Column(name = "password")
    private String password;
    @Column(name = "created_data_date")
    private String createdDateSave;
    @Column(name = "updated_data_date")
    private String updatedDateSave;
    @Column(name = "last_login")
    private String lastLoginDate;
    @Column(name = "token")
    private String token;
    @Column(name = "status")
    private Boolean isActive;
    @OneToMany(mappedBy="user")
    private List<Phone> items;

}
