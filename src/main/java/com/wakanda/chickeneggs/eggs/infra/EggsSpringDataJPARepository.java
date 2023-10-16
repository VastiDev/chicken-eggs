package com.wakanda.chickeneggs.eggs.infra;

import com.wakanda.chickeneggs.eggs.domain.Eggs;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.UUID;

public interface EggsSpringDataJPARepository extends JpaRepository<Eggs, UUID> {

}
