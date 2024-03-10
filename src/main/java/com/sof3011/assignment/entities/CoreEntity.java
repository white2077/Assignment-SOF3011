package com.sof3011.assignment.entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.UpdateTimestamp;

import java.sql.Timestamp;
import java.time.LocalDateTime;

@Setter
@Getter
@MappedSuperclass
@AllArgsConstructor
@NoArgsConstructor
public class CoreEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotNull
    @Column(name = "created_date")
    private Timestamp createdDate;
    @Column(name = "modified_date")
    @UpdateTimestamp
    private Timestamp modifiedDate;
    @PrePersist
    public void setCurrentDate(){
        createdDate = Timestamp.valueOf(LocalDateTime.now());
    }
}
