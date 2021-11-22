package by.bsc.miac.repository;

import by.bsc.miac.entity.ReportEntity;
import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;

@Component
public interface IReportRepository extends JpaRepository<ReportEntity, Long> {
}
