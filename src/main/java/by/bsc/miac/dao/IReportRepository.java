package by.bsc.miac.dao;

import by.bsc.miac.entity.MaterialEntity;
import by.bsc.miac.entity.OrganizationEntity;
import by.bsc.miac.entity.ReportEntity;

import javax.persistence.Column;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import java.util.Date;
import java.util.List;

public interface IReportRepository {
    ReportEntity addReport(float produceAll, float produceMonth, float onvrAll, float onvrMonth,
                           float exportUnitAll, float exportUnitMonth, float exportMoneyAll, float exportMoneyMonth,
                           Date date, OrganizationEntity organizationEntity, MaterialEntity materialEntity);

    ReportEntity findReport(int id);
    boolean deleteReport(int id);
    boolean updateReport(int id);
    List<ReportEntity> getAllReports();
}
