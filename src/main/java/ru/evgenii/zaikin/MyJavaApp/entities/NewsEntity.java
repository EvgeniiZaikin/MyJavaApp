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
@Table(name="news")
public class NewsEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="new_id")
    Long id;

    @Column(name="new_title", nullable = false)
    String title;

    @Column(name="new_url", unique = true, nullable = false)
    String url;

    @ManyToOne
    @JoinColumn(name="new_status_id")
    StatusEntity status;

    @CreationTimestamp
    @Column(name="new_created_at")
    Date createdAt;

    @UpdateTimestamp
    @Column(name="new_updated_at")
    Date updatedAt;
}
