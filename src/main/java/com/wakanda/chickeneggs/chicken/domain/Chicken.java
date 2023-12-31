package com.wakanda.chickeneggs.chicken.domain;

import com.wakanda.chickeneggs.chicken.application.api.ChickenRequest;
import com.wakanda.chickeneggs.eggsRecord.domain.EggsRecord;
import com.wakanda.chickeneggs.handler.APIException;
import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;



@Getter
@Setter
@Entity
@NoArgsConstructor(access = AccessLevel.PUBLIC)
@AllArgsConstructor(access = AccessLevel.PUBLIC)
public class Chicken {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(columnDefinition = "uuid", name= "idChicken", updatable = false, unique = true, nullable = false)
    private UUID idChicken;
    @NotBlank
    private String nameChicken;
    @NotNull
    private LocalDate birthDate;

    private LocalDateTime hourDateRegistration;
    private LocalDateTime hourDateLastChange;

    @OneToMany(mappedBy = "chicken", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<EggsRecord> eggsRecords;


    public Chicken( ChickenRequest chickenrequest) {
        this.nameChicken = chickenrequest.getNameChicken();
        this.birthDate = chickenrequest.getBirthDate();
        this.hourDateRegistration = LocalDateTime.now();
    }

}
