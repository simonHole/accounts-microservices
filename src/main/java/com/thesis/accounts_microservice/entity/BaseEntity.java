package com.thesis.accounts_microservice.entity;

import jakarta.persistence.Column;
import jakarta.persistence.MappedSuperclass;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.time.LocalDateTime;

// Mapped Superclass - indicates to the Spring Data JPA framework that this class is going to act as a superclass for all my entities, wherever
// I'm trying to extend this base entity class.
@MappedSuperclass
@Getter
@Setter
@ToString
public class BaseEntity {

    // updatable - if false is whenever a record is being updated inside the database table, I don't want this column to be considered by Spring Data JPA
    // to populate the value and to update the value, which means this field will not be updated whenever I'm trying update my record.
    @Column(updatable = false)
    private LocalDateTime createdAt;

    @Column(updatable = false)
    private String createdBy;

    @Column(insertable = false)
    private LocalDateTime updatedAt;

    @Column(insertable = false)
    private String updatedBy;
}
