package ru.evgenii.zaikin.MyJavaApp.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.util.Date;

@Entity
@Table(name="professions")
@Data
public class ProfessionEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="profession_id")
    Long id;

    @Column(name="profession_title", nullable = false, unique = true)
    String title;

    @CreationTimestamp
    @Column(name="profession_created_at")
    Date createdAt;

    @UpdateTimestamp
    @Column(name="profession_updated_at")
    Date updatedAt;
}
