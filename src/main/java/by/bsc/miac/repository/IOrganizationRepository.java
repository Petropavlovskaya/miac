package by.bsc.miac.repository;

import by.bsc.miac.entity.OrganizationEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IOrganizationRepository extends JpaRepository<OrganizationEntity, Long> {
}
