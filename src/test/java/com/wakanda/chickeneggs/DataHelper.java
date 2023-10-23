package com.wakanda.chickeneggs;

import com.wakanda.chickeneggs.chicken.application.api.ChickenRequest;
import com.wakanda.chickeneggs.chicken.application.api.ChickenResponse;
import com.wakanda.chickeneggs.chicken.domain.Chicken;
import com.wakanda.chickeneggs.eggsRecord.application.api.EggsRecordListResponse;
import com.wakanda.chickeneggs.eggsRecord.application.api.EggsRecordRequest;
import com.wakanda.chickeneggs.eggsRecord.domain.EggsRecord;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.UUID;

public class DataHelper {

    public static ChickenRequest createChickenRequest(String name, LocalDate birthDate) {
        return new ChickenRequest(name, birthDate);
    }

    public static Chicken createChickenFromRequest(ChickenRequest request) {
        Chicken chicken = new Chicken(request);
        chicken.setIdChicken(UUID.randomUUID());
        return chicken;
    }

    public static ChickenResponse createChickenResponse() {
        return ChickenResponse.builder()
                .idChicken(UUID.randomUUID())
                .build();
    }

    public static List<Chicken> createListOfChickens() {

        List<ChickenRequest> requests = new ArrayList<>();
        requests.add(createChickenRequest("ChickenName1", LocalDate.now().minusDays(5)));
        requests.add(createChickenRequest("ChickenName2", LocalDate.now().minusMonths(1)));
        requests.add(createChickenRequest("ChickenName3", LocalDate.now().minusWeeks(2)));

        List<Chicken> chickens = new ArrayList<>();
        for (ChickenRequest request : requests) {
            chickens.add(createChickenFromRequest(request));}
        return chickens;
    }
    public static EggsRecord createEggsRecord(UUID chickenId, int quantity, LocalDate registrationDate) {
        return EggsRecord.builder()
                .idEggsRecord(UUID.randomUUID())
                .idChickenLay(chickenId)
                .eggsQuantity(quantity)
                .hourDateRegistration(registrationDate)
                .build();
    }
    public static List<EggsRecord> createEggsRecordList() {
        Chicken chicken = createChickenFromRequest(createChickenRequest("Chicken1", LocalDate.now()));
        UUID chickenId = chicken.getIdChicken();
        return Arrays.asList(
                createEggsRecord(chickenId, 10, LocalDate.now()),
                createEggsRecord(chickenId, 20, LocalDate.now().minusDays(1)));
    }

    public static EggsRecordRequest createEggsRecordRequest(int i, LocalDate now) {
        return EggsRecordRequest.builder()
                .eggsQuantity(10)
                .hourDateRegistration(LocalDate.now()).build();
    }

    public static Chicken createValidChicken() {
        Chicken chicken = new Chicken();
        chicken.setIdChicken(UUID.randomUUID());
        chicken.setNameChicken("TestChicken");
        return chicken;
    }

    public static EggsRecord createValidEggsRecord() {
        EggsRecord eggsRecord = new EggsRecord();
        eggsRecord.setChicken(createValidChicken());
        eggsRecord.setIdEggsRecord(UUID.randomUUID());
        eggsRecord.setEggsQuantity(10);
        eggsRecord.setHourDateRegistration(LocalDate.now());
        return eggsRecord;
    }

    public static EggsRecordListResponse createEggsRecordListResponse() {
        EggsRecord eggsRecord = createValidEggsRecord();
        return new EggsRecordListResponse(eggsRecord);
    }

}

