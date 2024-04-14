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
@Table(name="statistic")
@Data
public class StatisticEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="statistic_id")
    Long id;

    @ManyToOne
    @JoinColumn(name="statistic_profession_id")
    ProfessionEntity profession;

    @ManyToOne
    @JoinColumn(name="statistic_type_id")
    TypeEntity type;

    @Column(name="statistic_value", nullable = false)
    Integer value;

    @CreationTimestamp
    @Column(name="statistic_created_at")
    Date createdAt;

    @UpdateTimestamp
    @Column(name="statistic_updated_at")
    Date updatedAt;
}
