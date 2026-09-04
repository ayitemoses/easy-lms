package com.akadev.lms_backend.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "first_name")
    private String firstname;

    @Column(name = "last_Name")
    private String lastName;

    @Column(name = "email_id", nullable = false, unique = true)
    private String email;


    @Column(nullable = false)
    private  String role;

}
