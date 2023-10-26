package com.wakanda.chickeneggs.eggsRecord.infra;

import com.wakanda.chickeneggs.eggsRecord.domain.EggsRecord;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

public interface EggsSpringDataJPARepository extends JpaRepository<EggsRecord, UUID> {
    List<EggsRecord> findByIdChickenLay(UUID idChickenLay);

    List<EggsRecord> findAllByHourDateRegistrationBetween(LocalDate startDate, LocalDate endDate);

   /* List<EggsRecord> findAllEggsPerChickenPerId(UUID idChicken, LocalDate startDate, LocalDate endDate);*/
}
