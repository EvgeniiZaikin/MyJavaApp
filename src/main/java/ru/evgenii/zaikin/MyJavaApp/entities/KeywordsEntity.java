package ru.evgenii.zaikin.MyJavaApp.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.util.Date;

@Entity
@Data
@Table(name="keywords")
public class KeywordsEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="keyword_id")
    Long id;

    @Column(name="keyword_value", nullable = false, unique = true)
    String value;

    @ManyToOne
    @JoinColumn(name="keyword_profession_id")
    ProfessionEntity profession;

    @CreationTimestamp
    @Column(name="keyword_created_at")
    Date createdAt;

    @UpdateTimestamp
    @Column(name="keyword_updated_at")
    Date updatedAt;
}
