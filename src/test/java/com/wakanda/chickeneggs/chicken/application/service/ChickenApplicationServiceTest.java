package com.wakanda.chickeneggs.chicken.application.service;

import static com.wakanda.chickeneggs.DataHelper.createChickenRequest;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.when;
import com.wakanda.chickeneggs.DataHelper;
import com.wakanda.chickeneggs.chicken.application.api.ChickenDetailedResponse;
import com.wakanda.chickeneggs.chicken.application.api.ChickenListResponse;
import com.wakanda.chickeneggs.chicken.application.api.ChickenRequest;
import com.wakanda.chickeneggs.chicken.application.api.ChickenResponse;
import com.wakanda.chickeneggs.chicken.application.repository.ChickenRepository;
import com.wakanda.chickeneggs.chicken.domain.Chicken;
import com.wakanda.chickeneggs.eggsRecord.application.service.EggsRepository;
import com.wakanda.chickeneggs.eggsRecord.domain.EggsRecord;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

@SpringBootTest
public class ChickenApplicationServiceTest {

    @MockBean
    private ChickenRepository chickenRepository;

    @MockBean
    private EggsRepository eggsRepository;

    private ChickenApplicationService chickenApplicationService;

    @BeforeEach
    public void setUp() {
        chickenApplicationService = new ChickenApplicationService(chickenRepository, eggsRepository);
    }

    @Test
    public void testCreateChicken() {
        ChickenRequest request = createChickenRequest("chicken1", LocalDate.now());
        Chicken chicken = DataHelper.createChickenFromRequest(createChickenRequest("Chicken1", LocalDate.now()));
        when(chickenRepository.save(any(Chicken.class))).thenReturn(chicken);

        ChickenResponse response = chickenApplicationService.createChicken(request);

        assertEquals(chicken.getIdChicken(), response.getIdChicken());
        Mockito.verify(chickenRepository, times(1)).save(any(Chicken.class));
    }

    @Test
    public void testGetAllChickens() {
        List<Chicken> chickens = DataHelper.createListOfChickens();
        when(chickenRepository.getAllChickens()).thenReturn(chickens);

        List<ChickenListResponse> response = chickenApplicationService.getAllChickens();

        assertEquals(chickens.size(), response.size());
        Mockito.verify(chickenRepository, times(1)).getAllChickens();
    }

    @Test
    public void testGetChickenPerId() {
        UUID chickenId = UUID.randomUUID();
        Chicken chicken = DataHelper.createChickenFromRequest(createChickenRequest("Chicken1", LocalDate.now()));
        when(chickenRepository.getChickenPerId(chickenId)).thenReturn(chicken);
        List<EggsRecord> eggsRecords = DataHelper.createEggsRecordList();
        when(eggsRepository.getEggsPerChickenWithId(chickenId)).thenReturn(eggsRecords);

        ChickenDetailedResponse response = chickenApplicationService.getChickenPerId(chickenId);

        assertEquals(chicken.getNameChicken(), response.getNameChicken()); // Assumindo que ChickenDetailedResponse possui um método getChickenName
        // Verifique outros campos conforme necessário
        Mockito.verify(chickenRepository, times(1)).getChickenPerId(chickenId);
        Mockito.verify(eggsRepository, times(1)).getEggsPerChickenWithId(chickenId);
    }

    @Test
    public void testDeleteChickenPerId() {
        UUID chickenId = UUID.randomUUID();
        Chicken chicken = DataHelper.createChickenFromRequest(createChickenRequest("Chicken1", LocalDate.now()));
        when(chickenRepository.getChickenPerId(chickenId)).thenReturn(chicken);

        chickenApplicationService.deleteChickenPerId(chickenId);

        Mockito.verify(chickenRepository, times(1)).deleteChickenPerId(chicken);
    }
}
