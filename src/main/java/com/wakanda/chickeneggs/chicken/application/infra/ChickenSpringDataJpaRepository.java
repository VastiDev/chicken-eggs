package com.wakanda.chickeneggs.chicken.application.infra;

import com.wakanda.chickeneggs.chicken.domain.Chicken;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface ChickenSpringDataJpaRepository extends JpaRepository<Chicken, UUID> {

}
