package com.sof3011.assignment.entities;

import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.MappedSuperclass;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.sql.Timestamp;
@Setter
@Getter
@MappedSuperclass
@AllArgsConstructor
@NoArgsConstructor
public class EntityCore {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotNull
    @Column(name = "created_date",  nullable = false)
    private Timestamp createdDate;
    @Column(name = "modified_date")
    private Timestamp modifiedDate;

}
