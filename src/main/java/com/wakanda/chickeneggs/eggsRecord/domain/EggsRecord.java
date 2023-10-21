package com.wakanda.chickeneggs.eggsRecord.domain;

import com.wakanda.chickeneggs.chicken.domain.Chicken;
import com.wakanda.chickeneggs.eggsRecord.application.api.EggsRecordRequest;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;
import java.util.UUID;
@Getter
@Entity
@NoArgsConstructor(access = AccessLevel.PUBLIC)
@AllArgsConstructor (access = AccessLevel.PUBLIC)
public class EggsRecord {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(columnDefinition = "uuid", name = "idEggsRecord", updatable = false, unique = true, nullable = false)
    private UUID idEggsRecord;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "idChickenLay", referencedColumnName = "idChicken", nullable = false, insertable = false, updatable = false)
    private Chicken chicken;

    @NotNull
    @Column(columnDefinition = "uuid", name = "idChickenLay", nullable = false)
    private UUID idChickenLay;

    @NotNull
    private Integer eggsQuantity;
    @NotNull
    private LocalDate hourDateRegistration;


    public EggsRecord(UUID idChicken, @Valid EggsRecordRequest eggsRecordRequest) {
        this.idChickenLay = idChicken;
        this.eggsQuantity = eggsRecordRequest.getEggsQuantity();
        this.hourDateRegistration = eggsRecordRequest.getHourDateRegistration();
    }

}
