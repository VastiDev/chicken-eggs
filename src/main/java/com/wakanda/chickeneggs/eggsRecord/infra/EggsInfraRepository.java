package com.wakanda.chickeneggs.eggsRecord.infra;

import com.wakanda.chickeneggs.eggsRecord.application.service.EggsRepository;
import com.wakanda.chickeneggs.eggsRecord.domain.EggsRecord;
import com.wakanda.chickeneggs.handler.APIException;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

@Repository
@Log4j2
@RequiredArgsConstructor
public class EggsInfraRepository implements EggsRepository {
    private final EggsSpringDataJPARepository eggsSpringDataJPARepository;

    @Override
    public EggsRecord saveEggs(EggsRecord eggsRecord) {
        log.info("[start] EggsInfraRepository - saveEggs");
        eggsSpringDataJPARepository.save(eggsRecord);
        log.info("[finish] EggsInfraRepository - saveEggs");
        return eggsRecord;
    }

    @Override
    public List<EggsRecord> getEggsPerChickenWithId(UUID idChicken) {
        log.info("[start] EggsInfraRepository - getEggsPerChickenWithId");
        var eggs = eggsSpringDataJPARepository.findByIdChickenLay(idChicken);
        log.info("[finish] EggsInfraRepository - getEggsPerChickenWithId");
        return eggs;
    }

    @Override
    public void deleteEggs(EggsRecord eggsRecord) {
        log.info("[start] EggsInfraRepository - deleteEggs");
        eggsSpringDataJPARepository.delete(eggsRecord);
        log.info("[finish] EggsInfraRepository - deleteEggs");
    }

    @Override
    public List<EggsRecord> getTotalEggsRecords() {
        log.info("[start] EggsInfraRepository - getTotalEggsRecords");
        var totalRecords = eggsSpringDataJPARepository.findAll();
        log.info("[finish] EggsInfraRepository - getTotalEggsRecords");
        return totalRecords;
    }

    @Override
    public Double getAverageEggsInPeriod(LocalDate startDate, LocalDate endDate) {
        log.info("[start] EggsInfraRepository - getAverageEggsInPeriod");
        List<EggsRecord> recordsInPeriod = eggsSpringDataJPARepository.findAllByHourDateRegistrationBetween(startDate, endDate);
        double average = recordsInPeriod.stream()
                .mapToInt(EggsRecord::getEggsQuantity)
                .average()
                .orElse(0.0);
        log.info("[finish] EggsInfraRepository - getAverageEggsInPeriod");
        return average;
    }

    @Override
    public EggsRecord getEggsPerId(UUID idEggsRecord) {
        log.info("[start] EggsInfraRepository - getEggsPerId");
        EggsRecord eggsRecord = eggsSpringDataJPARepository.findById(idEggsRecord)
                        .orElseThrow(()-> APIException.build(HttpStatus.NOT_FOUND, "idEggsRecord not found"));
        log.info("[finish] EggsInfraRepository - getEggsPerId");
        return eggsRecord;
    }
}