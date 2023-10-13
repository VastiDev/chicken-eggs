package com.wakanda.chickeneggs.eggs.domain;

import com.wakanda.chickeneggs.chicken.domain.Chicken;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;
import java.util.UUID;
@Getter
@Entity
@NoArgsConstructor(access = AccessLevel.PRIVATE)
@AllArgsConstructor (access = AccessLevel.PUBLIC)
public class DailyEggsRecord{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(columnDefinition = "uuid", name= "idDailyEggsRecord", updatable = false, unique = true, nullable = false)
    private UUID idDailyEggsRecord;
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "id_chicken", nullable = false)
    private Chicken chicken;
    @NotNull
    private Integer eggsQuantity;
    @NotNull
    private LocalDate hourDateRegistration;


}