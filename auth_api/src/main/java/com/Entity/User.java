package com.Entity;

import java.util.Date;

import javax.persistence.*;
import javax.validation.constraints.*;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import lombok.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer userId;

    @Column(nullable = false, length = 100)
    @NotBlank(message = "Name is required")
    @Size(min = 3, max = 100)
    private String name;

    @Column(nullable = false, unique = true, length = 150)
    @Email
    @NotBlank
    private String email;

    @Column(nullable = false)
    private Long phno;

    @Column(nullable = false)
    private String pwd;

    @Column
    private String pwdUpdated;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private Role role;

    @CreationTimestamp
    private Date createdDate;

    @UpdateTimestamp
    private Date updatedDate;
}
