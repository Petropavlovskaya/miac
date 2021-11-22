package by.bsc.miac.service;

import by.bsc.miac.entity.ReportEntity;
import by.bsc.miac.helper.ExcelHelperForm12;
import by.bsc.miac.repository.IReportRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@Service
public class ExcelService {

    @Autowired
    IReportRepository reportRepository;

    public void save(MultipartFile file) {
        try {
            ReportEntity reportEntity = ExcelHelperForm12.excelToReport(file.getInputStream());
            reportRepository.save(reportEntity);
        } catch (IOException e) {
            throw new RuntimeException("fail to store excel data: " + e.getMessage());
        }
    }

    public ReportEntity getReportEntityById(long id) {
        return reportRepository.getById(id);
    }
}
