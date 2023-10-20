package com.wakanda.chickeneggs.eggsRecord.infra;

import com.wakanda.chickeneggs.eggsRecord.domain.EggsRecord;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.UUID;

public interface EggsSpringDataJPARepository extends JpaRepository<EggsRecord, UUID> {
    List<EggsRecord> findByIdChickenLay(UUID idChickenLay);
}
