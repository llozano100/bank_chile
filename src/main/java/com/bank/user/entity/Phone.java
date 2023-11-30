package com.bank.user.entity;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name="PHONE")
@Data
public class Phone {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idPhone;
    @Column(name = "phone_number")
    private String phoneNumber;
    @Column(name = "city_code")
    private String cityCode;
    @Column(name = "country_code")
    private String countryCode;
    @ManyToOne
    @JoinColumn(name="uuid", nullable=false)
    private User user;
}
