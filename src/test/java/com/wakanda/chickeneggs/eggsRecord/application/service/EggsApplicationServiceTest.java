package com.wakanda.chickeneggs.eggsRecord.application.service;

import com.wakanda.chickeneggs.chicken.application.api.ChickenDetailedResponse;
import com.wakanda.chickeneggs.chicken.application.service.ChickenService;
import com.wakanda.chickeneggs.chicken.domain.Chicken;
import com.wakanda.chickeneggs.eggsRecord.application.api.EggsRecordListResponse;
import com.wakanda.chickeneggs.eggsRecord.application.api.EggsRecordRequest;
import com.wakanda.chickeneggs.eggsRecord.application.api.EggsRecordResponse;
import com.wakanda.chickeneggs.eggsRecord.domain.EggsRecord;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;


@RunWith(SpringRunner.class)
@SpringBootTest
class EggsApplicationServiceTest {
    @Autowired
    private EggsApplicationService service;

    @MockBean
    private ChickenService chickenService;

    @MockBean
    private EggsRepository eggsRepository;

    @Test
    public void createEggsTest() {
        // Given
        UUID chickenId = UUID.randomUUID();
        EggsRecordRequest eggsRequest = new EggsRecordRequest(10, LocalDate.now());
        UUID generatedEggsId = UUID.randomUUID();
        EggsRecord mockedEggsRecord = mock(EggsRecord.class);

        Chicken chicken = mock(Chicken.class); // Mocking Chicken class
        ChickenDetailedResponse chickenResponse = new ChickenDetailedResponse(chicken, 10);

        // Setting up the expected behavior for our mocks
        when(mockedEggsRecord.getIdEggsRecord()).thenReturn(generatedEggsId);
        when(chickenService.getChickenPerId(chickenId)).thenReturn(chickenResponse); // Return the ChickenDetailedResponse
        when(eggsRepository.saveEggs(any(EggsRecord.class))).thenReturn(mockedEggsRecord);

        // When
        EggsRecordResponse response;
        response = service.createEggs(chickenId, eggsRequest);

        // Then
        assertEquals(generatedEggsId, response.getIdEggsRecord());
        verify(chickenService, times(1)).getChickenPerId(chickenId);
        verify(eggsRepository, times(1)).saveEggs(any(EggsRecord.class));
    }
    @Test
    public void getEggsPerChickenWithIdTest() {
        // Given
        UUID chickenId = UUID.randomUUID();
        List<EggsRecord> mockEggsRecords = Arrays.asList(mock(EggsRecord.class), mock(EggsRecord.class));
        when(chickenService.getChickenPerId(chickenId)).thenReturn(mock(ChickenDetailedResponse.class));
        when(eggsRepository.getEggsPerChickenWithId(chickenId)).thenReturn(mockEggsRecords);

        // When
        List<EggsRecordListResponse> result = service.getEggsPerChickenWithId(chickenId);

        // Then
        assertEquals(mockEggsRecords.size(), result.size());
    }


}