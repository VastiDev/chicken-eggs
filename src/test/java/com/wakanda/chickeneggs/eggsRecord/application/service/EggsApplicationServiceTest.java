package com.wakanda.chickeneggs.eggsRecord.application.service;

import com.wakanda.chickeneggs.DataHelper;
import com.wakanda.chickeneggs.chicken.application.service.ChickenService;
import com.wakanda.chickeneggs.chicken.domain.Chicken;
import com.wakanda.chickeneggs.eggsRecord.application.api.*;
import com.wakanda.chickeneggs.eggsRecord.domain.EggsRecord;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.LocalDate;
import java.util.Collections;
import java.util.List;
import java.util.UUID;

import static org.hibernate.validator.internal.util.Contracts.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class EggsApplicationServiceTest {

    @InjectMocks
    private EggsApplicationService eggsApplicationService;

    @Mock
    private ChickenService chickenService;

    @Mock
    private EggsRepository eggsRepository;

    private EggsRecordRequest eggsRecordRequest;
    private EggsRecord eggsRecord;

    private UUID chickenId;

    private Chicken chicken;

    @BeforeEach
    public void setUp() {
        UUID chickenId = UUID.randomUUID();
        eggsRecordRequest = DataHelper.createEggsRecordRequest(10, LocalDate.now());
        eggsRecord = DataHelper.createEggsRecord(chickenId, eggsRecordRequest.getEggsQuantity(), eggsRecordRequest.getHourDateRegistration());
    }
    @Test
    public void testCreateEggs() {
        when(eggsRepository.saveEggs(any(EggsRecord.class))).thenReturn(eggsRecord);

        EggsRecordResponse response = eggsApplicationService.createEggs(chickenId, eggsRecordRequest);

        verify(chickenService, times(1)).getChickenPerId(chickenId);
        verify(eggsRepository, times(1)).saveEggs(any(EggsRecord.class));
        assertNotNull(response);
        assertEquals(eggsRecord.getIdEggsRecord(), response.getIdEggsRecord());
    }
    // ... seu setup e outros mocks ...

    @Test
    public void testGetEggsPerChickenWithId() {
        EggsRecord eggsRecord = DataHelper.createEggsRecord( chickenId,10, LocalDate.now());
        List<EggsRecord> records = Collections.singletonList(eggsRecord);
        when(eggsRepository.getEggsPerChickenWithId(chickenId)).thenReturn(records);

        EggsRecordListResponse listResponse = DataHelper.createEggsRecordListResponse();
        List<EggsRecordListResponse> mockResponse = Collections.singletonList(listResponse);
        when(EggsRecordListResponse.convert(records)).thenReturn(mockResponse);


        List<EggsRecordListResponse> response = eggsApplicationService.getEggsPerChickenWithId(chickenId);


        verify(chickenService, times(1)).getChickenPerId(chickenId);
        verify(eggsRepository, times(1)).getEggsPerChickenWithId(chickenId);
        assertFalse(response.isEmpty());
        assertEquals(records.size(), response.size());

    }
    @Test
    public void testDeleteEggsWithId() {
        doNothing().when(eggsRepository).deleteEggs(any(EggsRecord.class));
        when(eggsRepository.getEggsPerId(any(UUID.class))).thenReturn(eggsRecord);

        eggsApplicationService.deleteEggsWithId(chickenId, eggsRecord.getIdEggsRecord());

        verify(chickenService, times(1)).getChickenPerId(chickenId);
        verify(eggsRepository, times(1)).getEggsPerId(eggsRecord.getIdEggsRecord());
        verify(eggsRepository, times(1)).deleteEggs(any(EggsRecord.class));
    }

    /*@Test
    public void testGetTotalEggsRecords() {
        List<EggsRecord> records = Collections.singletonList(eggsRecord);
        when(eggsRepository.getTotalEggsRecords()).thenReturn(records);

        List<ListTotalEggsRecords> response = eggsApplicationService.getTotalEggsRecords();

        verify(eggsRepository, times(1)).getTotalEggsRecords();
        assertFalse(response.isEmpty());
        assertEquals(records.size(), response.size());
    }*/

    @Test
    public void testGetAverageEggsInPeriod() {
        LocalDate startDate = LocalDate.now().minusDays(10);
        LocalDate endDate = LocalDate.now();
        when(eggsRepository.getAverageEggsInPeriod(startDate, endDate)).thenReturn(12.0);

        AverageEggsInPeriod response = eggsApplicationService.getAverageEggsInPeriod(startDate, endDate);

        verify(eggsRepository, times(1)).getAverageEggsInPeriod(startDate, endDate);
        assertNotNull(response);

    }



}