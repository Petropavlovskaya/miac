package by.bsc.miac.repository;

import by.bsc.miac.entity.MaterialEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IMaterialRepository extends JpaRepository<MaterialEntity, Long> {
}
