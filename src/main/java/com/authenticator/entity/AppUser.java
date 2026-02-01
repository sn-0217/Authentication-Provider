package com.authenticator.entity;

import java.time.Instant;

import jakarta.annotation.PostConstruct;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "users")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder(toBuilder = true)
public class AppUser {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "user_name", unique = true)
    private String userName;
    @Column(unique = true)
    private String password;
    @Column(unique = true)
    private String email;

    private Instant createdAt;
    private Instant modifiedAt;

    @PostConstruct
    public void updateTimes(){
        if(this.createdAt == null) {
            this.createdAt = Instant.now();
            this.modifiedAt = this.createdAt;
        }
    }
}
